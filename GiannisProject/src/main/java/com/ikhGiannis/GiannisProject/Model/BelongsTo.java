package com.ikhGiannis.GiannisProject.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "belongs_to")
public class BelongsTo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
        @Column(name="user_id")
        private Integer userId;

        @Column(name="court_id")
        private String courtId;

        @Column(name="groups_id")
        private String groupId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getCourtId() {
        return courtId;
    }

    public void setCourtId(String courtId) {
        this.courtId = courtId;
    }
}
