package com.example.challenger.data.domain;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name="admin")
public class Admin {
    //Id column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    @NotNull
    private long id;

    //Other columns
    @Column(name = "login_id", columnDefinition = "TEXT")
    @NotNull
    private String loginId;

    @Column(columnDefinition = "TEXT")
    @NotNull
    private String password;

    @Column(length = 20)
    @NotNull
    private String name;

    @Column(length = 45)
    @NotNull
    private String position;

    // constructor
    public Admin() {}

    @Builder
    public Admin(long id, String loginId, String password, String name, String position){
        this.id = id;
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.position = position;
    }
}
