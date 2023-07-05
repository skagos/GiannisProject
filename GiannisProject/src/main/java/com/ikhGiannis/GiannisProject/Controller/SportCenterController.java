package com.ikhGiannis.GiannisProject.Controller;

import com.ikhGiannis.GiannisProject.Model.SportCenter;
import com.ikhGiannis.GiannisProject.Repository.SportCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nearcourt/sportCenter")
public class SportCenterController {
    @Autowired

    private SportCenterRepository sportCenterRepository;

    @GetMapping
    public List<SportCenter> findAllCourts() {

        return null;
    }



    @GetMapping("court/{id}")
    public ResponseEntity<SportCenter> findSportCenterById(@PathVariable(value = "id") int id) {

       return  null;
   }

    @PostMapping("court/{update}")

   public SportCenter saveSportCenter(@Validated @RequestBody SportCenter sportCenter) {

        return sportCenter;
   }

}
