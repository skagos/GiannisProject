package com.ikhGiannis.GiannisProject.Repository;

import com.ikhGiannis.GiannisProject.Model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}


