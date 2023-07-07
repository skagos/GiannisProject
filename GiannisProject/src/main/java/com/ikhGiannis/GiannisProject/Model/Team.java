package com.ikhGiannis.GiannisProject.Model;

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

    @Column(name = "court_id")
    private Integer courtId;

    @Column(name= "joined_players")
    private Integer joinedPlayers;

    @Column(name="owner_id")
    private Integer ownerId;

    @Column(name="group_capacity")
    private Integer groupCapacity;

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getJoinedPlayers() {
        return joinedPlayers;
    }

    public void setJoinedPlayers(Integer joinedPlayers) {
        this.joinedPlayers = joinedPlayers;
    }

    public Integer getCourtId() {
        return courtId;
    }

    public void setCourtId(Integer courtId) {
        this.courtId = courtId;
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
}
