<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>calc.jsp 결과값 보여주기</h1>
	
	<%-- 도메인 객체에 이름을 주지 않은 경우 --%>
	<h3>${numVO.num1}</h3>
	<h3>${numVO.num2}</h3>
	<h3>${numVO.op}</h3>

	<%-- 도메인 객체에 이름을 준 경우 --%>
	<h3>${vo.num1}</h3>
	<h3>${vo.num2}</h3>
	<h3>${vo.op}</h3>
	<h3>${result}</h3>

	<%-- Model에 담은 경우 --%>
	<h3>${num1}</h3>
	<h3>${num2}</h3>
	<h3>${op}</h3>
	<h3>${result}</h3>
</body>
</html>