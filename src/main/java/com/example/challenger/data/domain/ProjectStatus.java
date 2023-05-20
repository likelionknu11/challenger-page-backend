package com.example.challenger.data.domain;


import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="project_status")
public class ProjectStatus {
    //Id column
    @Id
    @GeneratedValue
    @Column(name = "project_status_id")
    private long id;

    //Other columns
    @Column(length = 10)
    @NotNull
    private String status;

//    //Slave
//    @OneToOne(mappedBy = "statusValue")
//    private Post post;
}