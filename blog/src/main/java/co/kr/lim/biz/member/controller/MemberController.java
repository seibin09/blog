package co.kr.lim.biz.member.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.kr.lim.biz.member.bean.Member;
import co.kr.lim.biz.member.bean.MemberDto;
import co.kr.lim.common.ErrorResponse;

@RestController
public class MemberController {

	@Autowired
	private ModelMapper modelMapper;
	
    @Value("${jdbc.url}")
    private String url;
	
	@RequestMapping(value="member", method = RequestMethod.POST)
	public ResponseEntity createMember(@RequestBody @Valid MemberDto.Create create,  BindingResult result) {
		if(result.hasErrors()) {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setMessage("잘못된 요청입니다.");
			errorResponse.setCode("bad.request");
			// TODO BindingResult 안에 들어있는 에러 정보 사용하기.
			return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
		}
		Member member = new Member();
		
		return new ResponseEntity<>(modelMapper.map(member, MemberDto.Create.class), HttpStatus.CREATED);
	}
	
}
