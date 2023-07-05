package com.ikhGiannis.GiannisProject.Controller;



import com.ikhGiannis.GiannisProject.Model.Court;
import com.ikhGiannis.GiannisProject.Model.Owner;
import com.ikhGiannis.GiannisProject.Repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/owner")
public class OwnerController {

    @Autowired
    private OwnerRepository ownerRepository;

    //private OwnerService ownerService;

    @GetMapping("/all")
    public List<Owner> findAllOwners(){
        return (List<Owner>) ownerRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Owner> findOwnerById(@PathVariable(value = "id")int ownerId){
        Optional<Owner> owner = ownerRepository.findById(ownerId);

        if (owner.isPresent()) {
            return ResponseEntity.ok().body(owner.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/create")
    public ResponseEntity<String> createOwner(@RequestBody Owner owner) {
        owner = ownerRepository.save(owner);
        return ResponseEntity.ok("Owner added successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOwnerById(@PathVariable (value = "id") int owenerId) {
        Optional<Owner> owner = ownerRepository.findById(owenerId);
        if (owner.isPresent()) {
            ownerRepository.delete(owner.get());
            return ResponseEntity.ok("Owner deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCourt(@PathVariable (value = "id") int ownerId, @RequestBody Owner updatedOwner) {
        Optional<Owner> optionalOwner = ownerRepository.findById(ownerId);
        if (optionalOwner.isPresent()) {
            Owner existingOwner = optionalOwner.get();
            existingOwner.setOwnerName(updatedOwner.getOwnerName());
            existingOwner.setSurname(updatedOwner.getSurname());
            existingOwner.setPassword(updatedOwner.getPassword());
            existingOwner.setEmail(updatedOwner.getEmail());

            Owner savedOwner = ownerRepository.save(existingOwner);
            return ResponseEntity.ok("Owner updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
