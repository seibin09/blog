package co.kr.lim.biz.member.bean;


import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class Member {
//	@Id
//	@GeneratedValue
//	private Long id;

//	@Column(unique = true)
	@Id
	private String username;

	private String password;
//
//	private String email;
//
//	private String fullName;
//
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date joined;
//
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date updated;
//
//	private boolean admin;
}
