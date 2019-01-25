package co.kr.lim.biz.member.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import co.kr.lim.biz.member.bean.Member;
public interface MemberRepository extends JpaRepository<Member, Long>{

	Member findByUsername(String username);
}
