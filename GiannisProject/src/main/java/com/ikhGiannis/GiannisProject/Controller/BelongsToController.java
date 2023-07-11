package com.ikhGiannis.GiannisProject.Controller;


import com.ikhGiannis.GiannisProject.Model.BelongsTo;
import com.ikhGiannis.GiannisProject.Model.Team;
import com.ikhGiannis.GiannisProject.Model.User;
import com.ikhGiannis.GiannisProject.Repository.BelongsToRepository;
import com.ikhGiannis.GiannisProject.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/belongsTo")
public class BelongsToController {

    @Autowired
    private BelongsToRepository belongsToRepository;

    @GetMapping("/all")
    public List<BelongsTo> findAllBelongs(){ return  (List<BelongsTo>) belongsToRepository.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<BelongsTo> findUserById(@PathVariable(value = "id")int id){
        Optional<BelongsTo> belongsTo = belongsToRepository.findById(id);

        if (belongsTo.isPresent()) {
            return ResponseEntity.ok().body(belongsTo.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
