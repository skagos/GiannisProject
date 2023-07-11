package com.ikhGiannis.GiannisProject.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        @Column(name="user_id")
        private Integer userId;

        @Column(name="name")
        private String userName;

        @Column(name="email")
        private String email;

        @Column(name="phone")
        private String phone;

        @Column(name="address")
        private String address;

        @Column(name="password")
        private String password;

        @OneToMany(mappedBy = "users")

        //@On(mappedBy = "users")


    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
