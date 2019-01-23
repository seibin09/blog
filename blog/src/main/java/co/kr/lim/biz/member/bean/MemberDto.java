package co.kr.lim.biz.member.bean;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

public class MemberDto {

	@Data
	public static class Create {

		@NotBlank
		@Size(min = 5)
		private String username;

		@NotBlank
		@Size(min = 5)
		private String password;

	}
}
