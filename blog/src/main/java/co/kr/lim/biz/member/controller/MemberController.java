package co.kr.lim.biz.member.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.kr.lim.biz.member.bean.Member;
import co.kr.lim.biz.member.bean.MemberDto;
import co.kr.lim.biz.member.service.MemberService;
import co.kr.lim.common.ErrorResponse;
import co.kr.lim.common.exception.UserDuplicatedException;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MemberController {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private MemberService memberService;
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/member", method = RequestMethod.POST, headers = { "Content-Type=application/json" })
	public ResponseEntity createMember(@RequestBody @Valid MemberDto.Create create, BindingResult result) {
		if (result.hasErrors()) {
			log.debug("BindingResult Fail");
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setMessage("잘못된 요청입니다.");
			errorResponse.setCode("bad.request");
			// TODO BindingResult 안에 들어있는 에러 정보 사용하기.
			return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
		}
		memberService.memberCreate(create);
		return new ResponseEntity<>(modelMapper.map(create, Member.class), HttpStatus.CREATED);
	}
	
	@ExceptionHandler(UserDuplicatedException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse handleUserDuplicatedException(UserDuplicatedException e) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage("[" + e.getUsername() + "] 중복된 username 입니다.");
		errorResponse.setCode("duplicated.username.exception");
		return errorResponse;
	}
	
}
