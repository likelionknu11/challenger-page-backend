package com.example.challenger.data.dao;

import com.example.challenger.data.domain.Member;

import java.util.List;
import java.util.Optional;

public interface TeamMemberDAO {
    Member addMember(Member member);
    Optional<Member> getMemberInfo(Long id);
    List<Member> selectAllTeamMember(Long id);
    Member updateTeamMemberName(Long id, String name) throws Exception;
    void deleteMember(Long id) throws Exception;
}