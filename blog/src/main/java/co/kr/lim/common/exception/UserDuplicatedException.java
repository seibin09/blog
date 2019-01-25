package co.kr.lim.common.exception;

public class UserDuplicatedException extends RuntimeException{

	private static final long serialVersionUID = -6052941085304458496L;

	private String username;

	public UserDuplicatedException(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	
}
