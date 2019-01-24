package co.kr.lim.biz.member.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.kr.lim.MemberControllerTest;
import co.kr.lim.biz.member.bean.Member;
import co.kr.lim.biz.member.bean.MemberDto;
import co.kr.lim.common.ErrorResponse;

@RestController
public class MemberController {

	@Autowired
	private ModelMapper modelMapper;
	
	private static Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/member", method = RequestMethod.POST, headers = { "Content-Type=application/json" })
	public ResponseEntity createMember(@RequestBody @Valid MemberDto.Create create, BindingResult result) {
		if (result.hasErrors()) {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setMessage("잘못된 요청입니다.");
			errorResponse.setCode("bad.request");
			// TODO BindingResult 안에 들어있는 에러 정보 사용하기.
			return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
		}
//		Member member = new Member();

		return new ResponseEntity<>(modelMapper.map(create, Member.class), HttpStatus.CREATED);
	}
}
