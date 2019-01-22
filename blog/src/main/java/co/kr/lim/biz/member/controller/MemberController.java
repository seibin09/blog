package co.kr.lim.biz.member.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.kr.lim.biz.member.bean.Member;
import co.kr.lim.biz.member.bean.MemberDto;
import co.kr.lim.biz.member.bean.MemberDto.create;



@RestController
public class MemberController {

	@Autowired
	private ModelMapper modelMapper;
	
	@RequestMapping(value="member", method = RequestMethod.POST)
	public ResponseEntity<create> createMember(@RequestBody MemberDto.create create) {
		Member member = new Member();
		return new ResponseEntity<>(modelMapper.map(member, MemberDto.create.class), HttpStatus.CREATED);
	}
	
}
