package com.ikhGiannis.GiannisProject.Repository;


import com.ikhGiannis.GiannisProject.Model.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RateRepository extends JpaRepository<Rate, Integer> {

}


