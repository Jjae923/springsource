package com.spring.service;

import com.spring.domain.AuthVO;
import com.spring.domain.LoginVO;

public interface MemberService {
	public AuthVO login(LoginVO login);
}
