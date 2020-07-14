package com.spring.service;

import com.spring.domain.AuthVO;
import com.spring.domain.ChangeVO;
import com.spring.domain.LeaveVO;
import com.spring.domain.LoginVO;

public interface MemberService {
	public AuthVO login(LoginVO login);
	// 비밀번호 추출
	public String getPwd(String userid);
	// 비밀번호 변경
	public boolean updatePwd(ChangeVO vo);
	// 회원 탈퇴
	public boolean delete(String userid);
}
