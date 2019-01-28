/**
 * 
 */
package co.kr.lim.common.exception;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import co.kr.lim.common.ErrorResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * @author YoungBoss
 * @since  2019. 1. 28.
 * 
 */
@ControllerAdvice
@RestController
@Slf4j
public class CommonExceptionHandler {

	private String propertiesMessage;
	
	@ExceptionHandler(BaseException.class)
	public ErrorResponse commonExceptionHandler(BaseException e) {
		ErrorResponse errorResponse = new ErrorResponse();
		if(StringUtils.isEmpty(e.getMessage())) {
			errorResponse.setMessage(propertiesMessage);
		}else {
			errorResponse.setMessage(e.getMessage());
		}
		errorResponse.setCode(e.getCode());
		return errorResponse;
	}
}
