package co.kr.lim.common.exception;

/**
 * @author YoungBoss
 * @since 2019. 1. 28.
 * 
 */
public class BaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;
	private String code;
	
	public BaseException(String message, String code){
		this.message = message;
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}


}
