package com.ikhGiannis.GiannisProject.Controller;


import com.ikhGiannis.GiannisProject.Model.Team;
import com.ikhGiannis.GiannisProject.Model.User;
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
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public List<User> findAllUsers(){ return  (List<User>) userRepository.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable(value = "id")int userId){
        Optional<User> user = userRepository.findById(userId);

        if (user.isPresent()) {
            return ResponseEntity.ok().body(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
