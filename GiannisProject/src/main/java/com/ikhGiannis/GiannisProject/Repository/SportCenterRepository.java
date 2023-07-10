package com.ikhGiannis.GiannisProject.Repository;

import com.ikhGiannis.GiannisProject.Model.SportCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.From;
import java.util.List;

@Repository
public interface SportCenterRepository extends JpaRepository<SportCenter, Integer> {

    @Query("SELECT u FROM SportCenter u")
    List<SportCenter> kati();

    @Query("SELECT u.sportCenterName,u.sportCenterId FROM SportCenter u WHERE u.sportCenterName = 'center 2'")
    List<String> getSportCenterNames();

    @Query("SELECT c.sportCenter.sportCenterId, c.sportCenter.sportCenterName, COUNT(c) " +
            "FROM Court c " +
            "GROUP BY c.sportCenter.sportCenterId, c.sportCenter.sportCenterName " +
            "ORDER BY COUNT(c) DESC")
    List<Object[]> findSportCenterCourtCounts();



    @Query("SELECT sc.sportCenterId AS sportCenterId, sc.sportCenterName AS sportCenterName, sc.address AS address, " +
            "COUNT(c) AS courtCount, c.sport AS sport " +
            "FROM SportCenter sc JOIN sc.courts c GROUP BY sc.sportCenterId, sc.sportCenterName, sc.address,c.sport")
    List<SportCenterDTO> findAllWithCourtCount();

    @Query("SELECT sc.sportCenterId AS sportCenterId,c.sport AS sports,c.capacity AS capacity " +
            "FROM SportCenter sc JOIN sc.courts c GROUP BY sc.sportCenterId,c.sport,c.capacity")
    List<SportCenterDTO2> findAllCapacitySport();

}

