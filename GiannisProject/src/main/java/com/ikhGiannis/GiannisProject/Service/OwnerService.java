package com.ikhGiannis.GiannisProject.Service;

import com.ikhGiannis.GiannisProject.Model.Court;
import com.ikhGiannis.GiannisProject.Model.Owner;
import com.ikhGiannis.GiannisProject.Repository.OwnerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class OwnerService {
    private OwnerRepository ownerRepository;
    public OwnerService(OwnerRepository ownerRepository){this.ownerRepository=ownerRepository;}

    public Owner getOwnerById(int id) {
        Optional<Owner> ownerOptional = ownerRepository.findById(id);
        return ownerOptional.orElse(null);
    }

    public Owner saveOwner(Owner owner) {
        return ownerRepository.save(owner);
    }
    public ResponseEntity<String> createOwner(Owner owner) {
        return ResponseEntity.ok("Owner added successfully");
    }
    public ResponseEntity<String> deleteOwner(Owner owner) {
        return ResponseEntity.ok("Owner deleted successfully");
    }


}
