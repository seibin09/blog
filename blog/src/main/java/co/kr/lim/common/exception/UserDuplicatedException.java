package co.kr.lim.common.exception;

public class UserDuplicatedException extends BaseException{

	private static final long serialVersionUID = -6052941085304458496L;

	public UserDuplicatedException(String message, String code) {
		super(message, code);
	}
	
	public UserDuplicatedException(String message) {
		super(message);
	}
	
}
