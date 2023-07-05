package com.ikhGiannis.GiannisProject.Repository;
import com.ikhGiannis.GiannisProject.Model.Court;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface SportCenterRepository extends JpaRepository<Court, Integer> {


}