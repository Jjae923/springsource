<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/security/tags"  prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인한 사용자 중에서 관리자만 접근 가능</h1>
	<form action="/logout" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<button>로그아웃</button>
	</form> 
	<%-- 
		principal : 데이터베이스에서 인증이 끝난 정보
	
	 --%>
	<div>
		<ul>
			<li>Admin 인증 정보</li>
			<li>principal : <sec:authentication property="principal"/></li>
			<li>MemberVO : <sec:authentication property="principal.member"/> </li>
			<li>사용자이름 : <sec:authentication property="principal.member.username"/></li>
			<li>사용자아이디 : <sec:authentication property="principal.member.userid"/></li>
			<li>사용자권한리스트 : <sec:authentication property="principal.member.authList"/></li>
		</ul>
	</div>
</body>
</html>
