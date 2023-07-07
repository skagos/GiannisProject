package com.ikhGiannis.GiannisProject.Controller;

import com.ikhGiannis.GiannisProject.Model.Court;
import com.ikhGiannis.GiannisProject.Model.SportCenter;
import com.ikhGiannis.GiannisProject.Repository.CourtRepository;
import com.ikhGiannis.GiannisProject.Repository.SportCenterRepository;
import com.ikhGiannis.GiannisProject.Service.SportCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sportCenter")
public class SportCenterController extends Court{
    @Autowired
    private SportCenterRepository sportCenterRepository;
    private CourtRepository courtRepository;
    @Autowired
    private SportCenterService ikhSportCenterService;



//    @GetMapping("/all")
//    public Page<SportCenter> getAllSportCenters(@RequestParam(defaultValue = "0") int page,
//                                                @RequestParam(defaultValue = "100") int size) {
//        Pageable pageable = PageRequest.of(page, size);
//        return sportCenterRepository.findAll(pageable);
//    }



    @GetMapping("/courtCounts")
    public List<SportCenter> getSportCenterCourtCounts() {
        return sportCenterRepository.kati();
    }


    @GetMapping("/all")
    public List<Page<SportCenter>> getAllSportCenters() {
        List<Page<SportCenter>> sportCenterPages = new ArrayList<>();
        int page = 0;
        Page<SportCenter> sportCenterPage;

        do {
            Pageable pageable = PageRequest.of(page, 100);
            sportCenterPage = sportCenterRepository.findAll(pageable);
            sportCenterPages.add(sportCenterPage);

            page++;
        }  while (page < 10 );
        //while (page < 10 );
        //while (sportCenterPage.hasNext());

        System.out.println("-----------------------------------------end of page-----------------------------------");
        return sportCenterPages;
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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSportCenter(@PathVariable (value = "id") int sportCenterId, @RequestBody SportCenter sportCenter) {
        Optional<SportCenter> existingSportCenter = sportCenterRepository.findById(sportCenterId);
        if (existingSportCenter.isPresent()) {
            sportCenterRepository.delete(existingSportCenter.get());
            return ResponseEntity.ok("Sport Center deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateSportCenter(@PathVariable (value = "id") int sportCenterId, @RequestBody SportCenter updatedSportCenter) {
        Optional<SportCenter> optionalSportCenter = sportCenterRepository.findById(sportCenterId);
        if (optionalSportCenter.isPresent()) {
            SportCenter existingSportCenter = optionalSportCenter.get();
            existingSportCenter.setSportCenterName(updatedSportCenter.getSportCenterName());
            existingSportCenter.setAddress(updatedSportCenter.getAddress());
            existingSportCenter.setCourts(updatedSportCenter.getCourts());
            SportCenter savedSportCenter = sportCenterRepository.save(existingSportCenter);
            return ResponseEntity.ok("Sport Center updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/patch/update/{id}")
    public ResponseEntity<String> partiallyUpdateSportCenter(@PathVariable(value = "id") int id, @RequestBody SportCenter partialSportCenter) {
        Optional<SportCenter> optionalSportCenter = sportCenterRepository.findById(id);
        if (optionalSportCenter.isPresent()) {
            SportCenter existingSportCenter = optionalSportCenter.get();

            if (partialSportCenter.getSportCenterName() != null) {
                existingSportCenter.setSportCenterName(partialSportCenter.getSportCenterName());
            }
            if (partialSportCenter.getOwner() != null) {
                existingSportCenter.setOwner(partialSportCenter.getOwner());
            }
            if (partialSportCenter.getAddress() != null) {
                existingSportCenter.setAddress(partialSportCenter.getAddress());
            }
            if (partialSportCenter.getCourts() != null) {
                existingSportCenter.setCourts(partialSportCenter.getCourts());
            }

            SportCenter savedSportCenter = sportCenterRepository.save(existingSportCenter);
            return ResponseEntity.ok("Court partially updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/bulkInstert")
    public ResponseEntity Bulk () {
         ikhSportCenterService.bulkInsertTry();
         return null;
    }

}
