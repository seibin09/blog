package co.kr.lim.biz.member.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.kr.lim.biz.member.bean.Member;

public interface MemberDao extends JpaRepository<Member, Long>{

}
