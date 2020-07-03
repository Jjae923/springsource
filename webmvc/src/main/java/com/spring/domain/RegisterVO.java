package com.spring.domain;

import lombok.Data;

@Data
public class RegisterVO {
	private String userid;
	private String password;
	private String comfirm_password;
	private String mobile;
}
