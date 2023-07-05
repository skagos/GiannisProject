package com.ikhGiannis.GiannisProject.Repository;
import com.ikhGiannis.GiannisProject.Model.Court;
import com.ikhGiannis.GiannisProject.Model.SportCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface SportCenterRepository extends JpaRepository<SportCenter, Integer> {


}