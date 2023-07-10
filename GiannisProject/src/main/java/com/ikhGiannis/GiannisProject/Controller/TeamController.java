package com.ikhGiannis.GiannisProject.Controller;
import com.ikhGiannis.GiannisProject.Model.Owner;
import com.ikhGiannis.GiannisProject.Model.Team;
import com.ikhGiannis.GiannisProject.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/group")
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    @GetMapping("/all")
    public List<Team> findAllGroup(){ return  (List<Team>) teamRepository.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Team> findTeamById(@PathVariable(value = "id")int groupId){
        Optional<Team> team = teamRepository.findById(groupId);

        if (team.isPresent()) {
            return ResponseEntity.ok().body(team.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/patch/update/{id}")
    public ResponseEntity<String> partiallyUpdateGroup(@PathVariable(value = "id") int id, @RequestBody Team partialTeam) {
        Optional<Team> optionalGroup = teamRepository.findById(id);
        if (optionalGroup.isPresent()) {
            Team existingGroup = optionalGroup.get();

            Team savedTeam = teamRepository.save(existingGroup);
            return ResponseEntity.ok("Group partially updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}






