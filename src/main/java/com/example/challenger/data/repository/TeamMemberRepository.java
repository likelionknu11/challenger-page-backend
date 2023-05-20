package com.example.challenger.data.repository;

import com.example.challenger.data.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamMemberRepository extends JpaRepository<Member, Long> {
    List<Member> findAllByTeamId(Long teamId);
}