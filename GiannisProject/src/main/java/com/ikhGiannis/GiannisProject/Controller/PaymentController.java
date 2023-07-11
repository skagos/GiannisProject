package com.ikhGiannis.GiannisProject.Controller;


import com.ikhGiannis.GiannisProject.Model.Payment;
import com.ikhGiannis.GiannisProject.Repository.PaymentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @GetMapping("/all")
    public List<Payment> findAllUsers(){ return  (List<Payment>) paymentRepository.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> findPaymentById(@PathVariable(value = "id")int paymentId){
        Optional<Payment> payment = paymentRepository.findById(paymentId);

        if (payment.isPresent()) {
            return ResponseEntity.ok().body(payment.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
