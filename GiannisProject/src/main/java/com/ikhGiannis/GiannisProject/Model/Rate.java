package com.ikhGiannis.GiannisProject.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Rates")
public class Rate {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="rate_id")
    private Integer rateId;

    @Column(name="rate")
    private String rate;

    @Column(name="stars")
    private Float stars;

    @OneToOne
    @JoinColumn(name ="user_id",nullable = false)
    private User user;
    @OneToMany(mappedBy = "rate")
    @JsonIgnoreProperties({"rate"})


    public Integer getRateId() {
        return rateId;
    }

    public void setRateId(Integer rateId) {
        this.rateId = rateId;
    }

    public Float getStars() {
        return stars;
    }

    public void setStars(Float stars) {
        this.stars = stars;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



}
