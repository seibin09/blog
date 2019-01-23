package co.kr.lim.biz.member.service;

import co.kr.lim.biz.member.bean.Member;
import co.kr.lim.biz.member.bean.MemberDto;

public interface MemberService {
	
	public Member memberCreate(MemberDto.Create create);
	

}
