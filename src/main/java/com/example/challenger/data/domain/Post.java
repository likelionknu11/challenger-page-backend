package com.example.challenger.data.domain;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="post")
public class Post {
    //Id column
    @Id
    @GeneratedValue
    @Column(name = "post_id")
    private long id;

    //Other columns
    @Column(name = "project_name", length = 45)
    @NotNull
    private String projectName;

    @Column(name = "github_path", columnDefinition = "TEXT")
    private String githubPath;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(columnDefinition = "TEXT")
    private String imagePath;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "team_id")
    private Team team;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "project_status_id")
    private ProjectStatus statusValue;
}