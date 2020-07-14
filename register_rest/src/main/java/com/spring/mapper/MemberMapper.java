package com.spring.mapper;

import org.apache.ibatis.annotations.Param;

import com.spring.domain.AuthVO;
import com.spring.domain.ChangeVO;
import com.spring.domain.LeaveVO;
import com.spring.domain.LoginVO;

import oracle.jdbc.proxy.annotation.GetProxy;

public interface MemberMapper {
	public AuthVO login(LoginVO login);
	public String getPassword(String userid);
	// public int updatePwd(@Param("userid") String userid,@Param("new_password") String new_password);
	public int updatePwd(ChangeVO vo); // 좀더 쉬운 방법
	public int deleteMember(String userid);
}
