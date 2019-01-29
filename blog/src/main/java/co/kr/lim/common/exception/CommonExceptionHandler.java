package co.kr.lim.common.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import co.kr.lim.common.ErrorResponse;

/**
 * @author YoungBoss
 * @since  2019. 1. 28.
 * 
 */
@ControllerAdvice
@RestController
public class CommonExceptionHandler {

	@ExceptionHandler(BaseException.class)
	public ErrorResponse commonExceptionHandler(BaseException e) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage("서버오류가 발생하였습니다.");
		errorResponse.setCode("500");
		return errorResponse;
	}
}
