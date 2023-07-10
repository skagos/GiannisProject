package com.ikhGiannis.GiannisProject.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Set;


@Entity
@Table(name = "sport_center")
public class SportCenter {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="center_id")
    private Integer sportCenterId;

    @Column(name="name")
    private String sportCenterName;

    @Column(name="address")
    private String address;

    @Transient
    private Long courtCount;

    @Transient
    private Long courtNum;

    @Transient
    private Long sport;

    @Transient
    private Long capacity;


    //@JsonIgnoreProperties(value = {"courtId"})
    @OneToMany(mappedBy = "sportCenter")
    private Set<Court> courts;

    public Long getCourtCount() {
        return courtCount;
    }

    public void setCourtCount(Long courtCount) {
        this.courtCount = courtCount;
    }

    @JsonIgnoreProperties(value = {"ownerId"})
    @ManyToOne
    @JoinColumn(name="owner_id",nullable = false)
    private Owner owner;


    public Integer getSportCenterId() {
        return sportCenterId;
    }

    public void setSportCenterId(Integer sportCenterId) {
        this.sportCenterId = sportCenterId;
    }

    public String getSportCenterName() {
        return sportCenterName;
    }

    public void setSportCenterName(String sportCenterName) {
        this.sportCenterName = sportCenterName;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Court> getCourts() {
        return courts;
    }

    public Long getCourtNum() {
        return courtNum;
    }

    public void setCourtNum(Long courtNum) {
        this.courtNum = courtNum;
    }

    public Long getSport() {
        return sport;
    }

    public void setSport(Long sport) {
        this.sport = sport;
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    @JsonIgnore
    public void setCourts(Set<Court> courts) {
        this.courts = courts;
    }

}
