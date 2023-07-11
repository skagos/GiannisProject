package com.ikhGiannis.GiannisProject.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "payment")
public class Payment {
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        @Column(name="payment_id")
        private Integer paymentId;

        @Column(name="amount")
        private String amount;

        @ManyToOne
        @JoinColumn(name = "user_id",nullable = false)
        private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
