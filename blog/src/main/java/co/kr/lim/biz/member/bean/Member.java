package co.kr.lim.biz.member.bean;

import java.util.Date;

import javax.persistence.*;

import org.springframework.data.annotation.Id;

@Entity
public class Member {
	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true)
	private String username;

	private String password;

	private String email;

	private String fullName;

	@Temporal(TemporalType.TIMESTAMP)
	private Date joined;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;

	private boolean admin;
}
