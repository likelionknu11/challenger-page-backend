package com.example.challenger.data.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Table(name="member")
@Builder
public class Member {
    //Id column
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private long id;

    //Other columns
    @Column(length = 20)
    @NotNull
    private String name;

    @Column(length = 20)
    @NotNull
    private String position;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name="team_id")
    @NotNull
    private Team team;
}