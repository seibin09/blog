package co.kr.lim.biz.member.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.lim.biz.member.bean.Member;
import co.kr.lim.biz.member.bean.MemberDto;
import co.kr.lim.biz.member.dao.MemberDao;
import co.kr.lim.biz.member.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private ModelMapper modelMapper;
	
	@Autowired
	private MemberDao memberDao = null;
	
	@Override
	public Member memberCreate(MemberDto.create create) {
		Member member =  modelMapper.map(create, Member.class);
		return memberDao.save(member);
	}

}
