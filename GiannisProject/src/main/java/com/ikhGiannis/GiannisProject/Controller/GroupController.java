package com.ikhGiannis.GiannisProject.Controller;
import com.ikhGiannis.GiannisProject.Model.Group;
import com.ikhGiannis.GiannisProject.Model.Owner;
import com.ikhGiannis.GiannisProject.Repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/group")
public class GroupController {

    @Autowired
    private GroupRepository groupRepository;

    @GetMapping("/all")
    public List<Group> findAllGroups(){ return  (List<Group>) groupRepository.findAll(); }

//    @PatchMapping("/patch/update/{id}")
//    public ResponseEntity<String> partiallyUpdateGroup(@PathVariable(value = "id") int id, @RequestBody Group partialGroup) {
//        Optional<Group> optionalGroup = groupRepository.findById(id);
//        if (optionalGroup.isPresent()) {
//            Group existingGroup = optionalGroup.get();
//
//            Group savedGroup = groupRepository.save(existingGroup);
//            return ResponseEntity.ok("Group partially updated successfully");
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }


}






