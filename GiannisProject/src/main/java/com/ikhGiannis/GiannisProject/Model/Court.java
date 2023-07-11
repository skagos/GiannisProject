package com.ikhGiannis.GiannisProject.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serial;
import java.util.Set;

@Entity
@Table(name = "Court")
public class Court {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String courtName;

    @Column(name="sport")
    private String sport;
    @Column(name="capacity")
    private Integer capacity;
    @Column(name="price")
    private Integer price;

    //@JsonIgnoreProperties(value = {"courtId"})

    @ManyToOne
    @JsonIgnoreProperties({"courts","sport","capacity","courtNum","courtCount"})
    @JoinColumn(name="sport_center_id", nullable=false)
    private SportCenter sportCenter;

    @OneToMany(mappedBy = "court")
    @JsonIgnoreProperties({"sportCenter","courts","teams"})
    private Set<Team> teams;

    @OneToOne
    @JoinColumn(name ="rate_id",nullable = false)
    private Rate rate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourtName() {
        return courtName;
    }

    public void setCourtName(String courtName) {
        this.courtName = courtName;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public SportCenter getSportCenter() {
        return sportCenter;
    }

    public void setSportCenter(SportCenter sportCenter) {
        this.sportCenter = sportCenter;
    }
    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }
}
