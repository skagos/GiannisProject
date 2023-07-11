package com.ikhGiannis.GiannisProject.Controller;


import com.ikhGiannis.GiannisProject.Model.Rate;
import com.ikhGiannis.GiannisProject.Repository.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rate")
public class RateController {

    @Autowired
    private RateRepository rateRepository;

    @GetMapping("/all")
    public List<Rate> findAllUsers(){ return  (List<Rate>) rateRepository.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Rate> findRateById(@PathVariable(value = "id")int rateId){
        Optional<Rate> user = rateRepository.findById(rateId);

        if (user.isPresent()) {
            return ResponseEntity.ok().body(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
