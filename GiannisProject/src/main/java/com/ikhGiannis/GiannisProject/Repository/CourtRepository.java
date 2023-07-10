package com.ikhGiannis.GiannisProject.Repository;

import com.ikhGiannis.GiannisProject.Model.Court;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourtRepository extends JpaRepository<Court, Integer> {

//    @Query("SELECT MIN(c.courtNumber), AVG(c.courtNumber)" +
//            "FROM Court c" +
//            "WHERE c.sportCenterId = :sportCenterId")
//    List<Court> findSportCenterCourtStatistics();
    
}
