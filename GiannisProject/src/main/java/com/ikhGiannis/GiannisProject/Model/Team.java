package com.ikhGiannis.GiannisProject.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "team")
public class Team {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="group_id")
    private Integer groupId;

    @Column(name = "sport")
    private String groupSport;

    @Column(name= "joined_players")
    private Integer joinedPlayers;


    @Column(name="group_capacity")
    private Integer groupCapacity;

    @ManyToOne
    @JsonIgnoreProperties({"teams","sportCenter","courts","user","rate"})
    @JoinColumn(name = "court_id",nullable = false)
    private Court court;

    @OneToOne
    @JsonIgnoreProperties({"rate"})
    @JoinColumn(name = "owner_id",nullable = false)
    private User user;


    public Integer getJoinedPlayers() {
        return joinedPlayers;
    }

    public void setJoinedPlayers(Integer joinedPlayers) {
        this.joinedPlayers = joinedPlayers;
    }



    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupSport() {
        return groupSport;
    }

    public void setGroupSport(String groupSport) {
        this.groupSport = groupSport;
    }

    public Integer getGroupCapacity() {
        return groupCapacity;
    }

    public void setGroupCapacity(Integer groupCapacity) {
        this.groupCapacity = groupCapacity;
    }

    public Court getCourt() {
        return court;
    }

    public void setCourt(Court court) {
        this.court = court;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
