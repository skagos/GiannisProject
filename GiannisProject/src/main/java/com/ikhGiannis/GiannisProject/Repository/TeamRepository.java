package com.ikhGiannis.GiannisProject.Repository;
import com.ikhGiannis.GiannisProject.Model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

}