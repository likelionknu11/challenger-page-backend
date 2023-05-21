package com.example.challenger.data.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Table(name="team")
@Builder
public class Team {
    //Id column
    @Id @GeneratedValue
    @Column(name = "team_id")
    private long id;

    //Other columns
    @Column(length = 45)
    @NotNull
    private String name;

    //    Slave
    //    @OneToMany(mappedBy = "teamId", orphanRemoval = true)
    //    List<Member> teamMember = new ArrayList<>(); //팀 맴버 조회
}