package com.ikhGiannis.GiannisProject.Model;


import jakarta.persistence.*;

@Entity
@Table(name = "sport_center")
public class SportCenter {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="center_id")
    private Integer id;

    @Column(name="name")
    private String name;
    @Column(name="owner_id")
    private Integer ownerId;

    @Column(name="address")
    private String address;


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
