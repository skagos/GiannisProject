package com.ikhGiannis.GiannisProject.Repository;

import com.ikhGiannis.GiannisProject.Model.SportCenter;
import jakarta.persistence.NamedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface SportCenterRepository extends JpaRepository<SportCenter, Integer> {

    @Query("SELECT u FROM SportCenter u")
    List<SportCenter> kati();
}

