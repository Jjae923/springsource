package com.spring.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class MemberVO {
	private String userid;
	private String userpw;
	private String username;
	private Date regdate;
	private Date updatedate;
	private boolean enabled;
	
	// 권한 정보
	private List<AuthVO> authList;	// 한 개의 ID에 권한이 여러개가 들어올 수 있기 때문에 LIST
}
