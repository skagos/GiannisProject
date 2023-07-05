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

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteOwner( @RequestBody Owner owner) {
        ownerRepository.delete(owner);
        return ResponseEntity.ok("Owner deleted successfully");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCourt(@PathVariable Integer id, @RequestBody Owner updatedOwner) {
        Optional<Owner> optionalOwner = ownerRepository.findById(id);
        if (optionalOwner.isPresent()) {
            Owner existingOwner = optionalOwner.get();
            existingOwner.setOwnerName(updatedOwner.getOwnerName());
            existingOwner.setSurname(updatedOwner.getSurname());
            existingOwner.setPassword(updatedOwner.getPassword());

            Owner savedOwner = ownerRepository.save(existingOwner);
            return ResponseEntity.ok("Owner updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
