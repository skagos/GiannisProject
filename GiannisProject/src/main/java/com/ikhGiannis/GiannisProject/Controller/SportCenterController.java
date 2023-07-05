package com.ikhGiannis.GiannisProject.Controller;

import com.ikhGiannis.GiannisProject.Model.Court;
import com.ikhGiannis.GiannisProject.Model.SportCenter;
import com.ikhGiannis.GiannisProject.Repository.CourtRepository;
import com.ikhGiannis.GiannisProject.Repository.SportCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sportCenter")
public class SportCenterController extends Court{
    @Autowired

    private SportCenterRepository sportCenterRepository;
    private CourtRepository courtRepository;

    @GetMapping("/all")
    public List<SportCenter> findAllCourts() {
        return (List<SportCenter>) sportCenterRepository.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<SportCenter> findSportCenterById(@PathVariable(value = "id") int sportCenterId) {
        Optional<SportCenter> sportCenter = sportCenterRepository.findById(sportCenterId);

        if (sportCenter.isPresent()) {
            return ResponseEntity.ok().body(sportCenter.get());
            //return ResponseEntity.ok().body(Courts.get());
        } else {
            return ResponseEntity.notFound().build();
        }
   }

    @PostMapping("/create")
    public ResponseEntity<String> createSportCenter(@RequestBody SportCenter sportCenter) {
        SportCenter SportCenter = sportCenterRepository.save(sportCenter);
        return ResponseEntity.ok("Sport Center added successfully");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteSportCenter(@Validated @RequestBody SportCenter sportCenter) {
        sportCenterRepository.delete(sportCenter);
        return ResponseEntity.ok("Sport Center deleted successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateSportCenter(@PathVariable Integer sportCenterId, @RequestBody SportCenter updatedSportCenter) {
        Optional<SportCenter> optionalSportCenter = sportCenterRepository.findById(sportCenterId);
        if (optionalSportCenter.isPresent()) {
            SportCenter existingSportCenter = optionalSportCenter.get();
            existingSportCenter.setCourts(updatedSportCenter.getCourts());
            existingSportCenter.setSportCenterName(updatedSportCenter.getSportCenterName());
            existingSportCenter.setOwnerId(updatedSportCenter.getOwnerId());
            existingSportCenter.setAddress(updatedSportCenter.getAddress());

            SportCenter savedSportCenter = sportCenterRepository.save(existingSportCenter);
            return ResponseEntity.ok("Sport Center updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
