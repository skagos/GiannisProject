package com.ikhGiannis.GiannisProject.Controller;

import com.ikhGiannis.GiannisProject.Model.Court;
import com.ikhGiannis.GiannisProject.Repository.CourtRepository;
import com.ikhGiannis.GiannisProject.Service.CourtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/api/court")
public class CourtController {

    @Autowired
    private CourtRepository courtRepository;
    //private CourtService courtService;

    @GetMapping("/all")
    public List<Court> findAllCourts() {
        //System.out.println("fadsdfd");
        return (List<Court>) courtRepository.findAll();
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
    public ResponseEntity<String> createCourt(@RequestBody Court court) {
        Court Court = courtRepository.save(court);
        return ResponseEntity.ok("Court added successfully");
    }
    //

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCourt( @RequestBody Court court) {
        courtRepository.delete(court);
        return ResponseEntity.ok("Court deleted successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCourt(@PathVariable Integer id, @RequestBody Court updatedCourt) {
        Optional<Court> optionalCourt = courtRepository.findById(id);
        if (optionalCourt.isPresent()) {
            Court existingCourt = optionalCourt.get();
            existingCourt.setCourtName(updatedCourt.getCourtName());
            //existingCourt.setSportCenterId(updatedCourt.getSportCenterId());
            existingCourt.setCapacity(updatedCourt.getCapacity());
            existingCourt.setPrice(updatedCourt.getPrice());
//            existingCourt.setSport(updatedCourt.getSport());

            Court savedCourt = courtRepository.save(existingCourt);
            return ResponseEntity.ok("Court updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


   /*@PatchMapping("/{id}")
    public ResponseEntity<String> updateCourt(@PathVariable("id") Long id, @Validated @RequestBody Court court) {
        Court existingCourt = courtRepository.findCourtById(id);

        if (existingCourt == null) {
            return ResponseEntity.notFound().build();
        }

        // Update the fields of the existing court with the new values
        existingCourt.setName(court.getName());
        existingCourt.setSport(court.getSport());
        existingCourt.setCapacity(court.getCapacity());
        existingCourt.setPrice(court.getPrice());
        // Add more fields to update as needed

        courtRepository.save(existingCourt);
        return ResponseEntity.ok("Court updated successfully");
    }*/

}



