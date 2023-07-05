package com.ikhGiannis.GiannisProject.Model;


import jakarta.persistence.*;

@Entity
@Table(name = "sport_center")
public class SportCenter {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="center_id")
    private Integer sportCenterId;

    @Column(name="name")
    private String sportCenterName;
    @Column(name="owner_id")
    private Integer ownerId;

    @Column(name="address")
    private String address;


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

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer sportCenterId) {
        this.ownerId = ownerId;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
