package com.example.challenger.data.dao.impl;


import com.example.challenger.data.dao.TeamMemberDAO;
import com.example.challenger.data.domain.Member;
import com.example.challenger.data.domain.Team;
import com.example.challenger.data.repository.TeamMemberRepository;
import com.example.challenger.data.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TeamMemberDAOImpl implements TeamMemberDAO {
    private final TeamMemberRepository teamMemberRepository;
    private final TeamRepository teamRepository;

    @Autowired
    public TeamMemberDAOImpl(TeamMemberRepository teamMemberRepository, TeamRepository teamRepository) {
        this.teamMemberRepository = teamMemberRepository;
        this.teamRepository = teamRepository;
    }

    @Override
    public Member addMember(Member member) {
        Member savedTeamMember = teamMemberRepository.save(member);
        return savedTeamMember;
    }

    public Optional<Member> getMemberInfo(Long id) {
        return teamMemberRepository.findById(id);
    }

    @Override
    public Member updateTeamMemberName(Member member) throws Exception {
        Optional<Member> selectedMember = teamMemberRepository.findById(member.getId());
        Team team = teamRepository.getById(selectedMember.get().getTeam().getId());
        Member updatedTeamMember;
        if(selectedMember.isPresent()) {
            member.setId(selectedMember.get().getId());
            member.setName(member.getName());
            member.setPosition(selectedMember.get().getPosition());
            member.setTeam(team);

            updatedTeamMember = teamMemberRepository.save(member);
        } else {
            throw new Exception();
        }

        return updatedTeamMember;
    }

    @Override
    public void deleteMember(Long id) throws Exception {
        Optional<Member> selectedMember = teamMemberRepository.findById(id);
        if(selectedMember.isPresent()) {
            Member member = selectedMember.get();
            member.setTeam(null);
            teamMemberRepository.delete(member);
        } else {
            throw new Exception();
        }
    }

    @Override
    public List<Member> selectAllTeamMember(Long id) {
        return teamMemberRepository.findAllByTeamId(id);
    }
}