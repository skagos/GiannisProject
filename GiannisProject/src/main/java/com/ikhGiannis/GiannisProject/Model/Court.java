package com.ikhGiannis.GiannisProject.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Court")
public class Court {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;
    @Column(name="sport_center_id")
    private Integer sportCenterId;

    @Column(name="sport")
    private String sport;
    @Column(name="capacity")
    private Integer capacity;
    @Column(name="price")
    private Integer price;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSportCenterId() {
        return sportCenterId;
    }

    public void setSportCenterId(Integer sportCenterId) {
        this.sportCenterId = sportCenterId;
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
}
