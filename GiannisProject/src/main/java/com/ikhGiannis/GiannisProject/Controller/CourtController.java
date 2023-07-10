package com.ikhGiannis.GiannisProject.Controller;

import com.ikhGiannis.GiannisProject.Model.Court;
import com.ikhGiannis.GiannisProject.Repository.CourtRepository;
import com.ikhGiannis.GiannisProject.Service.CourtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/api/court")
public class CourtController {

    @Autowired
    private CourtRepository courtRepository;
    private CourtService courtService;

    private WebClient webClient;

    public CourtController() {
        this.webClient = WebClient.builder()
                .baseUrl("https://countriesnow.space/api/v0.1/countries")
                .build();

    }

    private Mono<String> callWebClient() {
        return webClient.get()
                .uri("/positions")
                .retrieve()
                .bodyToMono(String.class);
    }

    @GetMapping("/positions")
    public Mono<String> getPositionDetails() {
        return webClient.get()
                .uri("/positions")
                .retrieve()
                .bodyToMono(String.class);
    }

//    @GetMapping("/statistics")
//    public List<Court> getStatistics() {
//        return courtRepository.findSportCenterCourtStatistics();
//    }

    @GetMapping("/currency")
    public Mono<String> getCurrencyDetails() {
        return webClient.get()
                .uri("/currency")
                .retrieve()
                .bodyToMono(String.class);
    }

    @GetMapping("/flag")
    public Mono<String> getFlagDetails() {
        return webClient.get()
                .uri("/flag/unicode")
                .retrieve()
                .bodyToMono(String.class);
    }


    @GetMapping("/all/{num}/{size}")
    public Page<Court> findAllCourts(@PathVariable("num") int pageNumber,
                                     @PathVariable("size") int pageSize)
    {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Court> courtPage = courtRepository.findAll(pageable);

        return courtPage;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Court> findCourtById(@PathVariable(value = "id") int id) {
        Optional<Court> court = courtRepository.findById(id);

        if (court.isPresent()) {
            return ResponseEntity.ok().body(court.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<String> createCourt(@RequestBody Court newCourt) {
        Court newcourt = courtRepository.save(newCourt);
        return ResponseEntity.ok("Court added successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCourtById(@PathVariable (value = "id") int id) {
        Optional<Court> court = courtRepository.findById(id);
        if (court.isPresent()) {
            courtRepository.delete(court.get());
            return ResponseEntity.ok("Court deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCourt(@PathVariable (value = "id") int id, @RequestBody Court updatedCourt) {
        Optional<Court> optionalCourt = courtRepository.findById(id);
        if (optionalCourt.isPresent()) {
            Court existingCourt = optionalCourt.get();
            existingCourt.setCourtName(updatedCourt.getCourtName());
            //existingCourt.setSportCenterId(updatedCourt.getSportCenterId());
            existingCourt.setCapacity(updatedCourt.getCapacity());
            existingCourt.setPrice(updatedCourt.getPrice());
            existingCourt.setSport(updatedCourt.getSport());

            Court savedCourt = courtRepository.save(existingCourt);
            return ResponseEntity.ok("Court updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PatchMapping("/patch/update/{id}")
    public ResponseEntity<String> partiallyUpdateCourt(@PathVariable(value = "id") int id, @RequestBody Court partialCourt) {
        Optional<Court> optionalCourt = courtRepository.findById(id);
        if (optionalCourt.isPresent()) {
            Court existingCourt = optionalCourt.get();


            if (partialCourt.getCourtName() != null) {
                existingCourt.setCourtName(partialCourt.getCourtName());
            }
            if (partialCourt.getSportCenter() != null) {
                existingCourt.setSportCenter(partialCourt.getSportCenter());
            }
            if (partialCourt.getCapacity() != null) {
                existingCourt.setCapacity(partialCourt.getCapacity());
            }
            if (partialCourt.getPrice() != null) {
                existingCourt.setPrice(partialCourt.getPrice());
            }
            if (partialCourt.getSport() != null) {
                existingCourt.setSport(partialCourt.getSport());
            }

            Court savedCourt = courtRepository.save(existingCourt);
            return ResponseEntity.ok("Court partially updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}



