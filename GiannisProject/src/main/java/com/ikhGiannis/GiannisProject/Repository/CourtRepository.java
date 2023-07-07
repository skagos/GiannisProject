package com.ikhGiannis.GiannisProject.Repository;

import com.ikhGiannis.GiannisProject.Model.Court;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourtRepository extends JpaRepository<Court, Integer> {
    
}
