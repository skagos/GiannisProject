package com.ikhGiannis.GiannisProject.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "owner")
public class Owner {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="owner_id")
    private Integer ownerId;

    @Column(name="name")
    private String ownerName;
    @Column(name="surname")
    private String surname;

    @Column(name="email")
    private String email;
    @Column(name="password")
    private Integer password;
    public Integer getOwnerId() {   return ownerId; }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {  return ownerName;   }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    public Integer getPassword() {
        return password;
    }
    public void setPassword(Integer password) {
        this.password = password;
    }

}
