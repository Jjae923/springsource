package com.spring.mapper;

import com.spring.domain.AuthVO;
import com.spring.domain.LoginVO;

public interface MemberMapper {
	public AuthVO login(LoginVO login);
}
