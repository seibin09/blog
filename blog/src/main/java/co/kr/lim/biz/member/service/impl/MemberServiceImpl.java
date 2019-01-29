package co.kr.lim.biz.member.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.lim.biz.member.bean.Member;
import co.kr.lim.biz.member.bean.MemberDto;
import co.kr.lim.biz.member.dao.MemberRepository;
import co.kr.lim.biz.member.service.MemberService;
import co.kr.lim.common.exception.UserDuplicatedException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemberServiceImpl implements MemberService{

    @Autowired
    private ModelMapper modelMapper;
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public Member memberCreate(MemberDto.Create create) {
		Member member =  modelMapper.map(create, Member.class);
		if(memberRepository.findByUsername(create.getUsername()) != null) {
			log.info("duplication Exception username = [{}]", create.getUsername());
			throw new UserDuplicatedException(create.getUsername());
		}
		return memberRepository.save(member);
	}

}
