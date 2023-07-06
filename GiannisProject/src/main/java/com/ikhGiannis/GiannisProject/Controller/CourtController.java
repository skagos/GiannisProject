package com.ikhGiannis.GiannisProject.Controller;

import com.ikhGiannis.GiannisProject.Model.Court;
import com.ikhGiannis.GiannisProject.Model.SportCenter;
import com.ikhGiannis.GiannisProject.Repository.CourtRepository;
import com.ikhGiannis.GiannisProject.Service.CourtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/api/court")
public class CourtController {

    @Autowired
    private CourtRepository courtRepository;
    //private CourtService courtService;

//    @GetMapping("/all")
//    public List<Page<Court>> findAllCourts() {
//        List<Page<Court>> courts = new ArrayList<>();
//        int pageCount = 0;
//        Page<Court> courtPage;
//        do{
//            Pageable pageable = PageRequest.of(pageCount,10);
//            courtPage = courtRepository.findAll(pageable);
//            courtPages.add(courtPage);
//            System.out.println("end of page");
//            pageCount++;
//        }while (courtPage.hasNext());
//
//        return courtPages;
//    }
@GetMapping("/all")
public List<Page<Court>> findAllCourts() {
    List<Page<Court>> courtPages = new ArrayList<>();
    int pageCount = 0;
    Page<Court> courtPage;
    do {
        Pageable pageable = PageRequest.of(pageCount, 10000);
        courtPage = courtRepository.findAll(pageable);
        courtPages.add(courtPage);
        pageCount++;
    }  while (courtPage.hasNext());
    //while (pageCount < 1000 );
    //while (courtPage.hasNext());
    System.out.println("-----------------------------------------end of page-----------------------------------");
    return courtPages;
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



