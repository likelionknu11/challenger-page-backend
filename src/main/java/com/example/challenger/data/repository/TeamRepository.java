package com.example.challenger.data.repository;

import com.example.challenger.data.domain.Member;
import com.example.challenger.data.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    List<Member> findAllById(Long id);
}