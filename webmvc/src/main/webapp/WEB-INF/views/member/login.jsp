<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login</h1>
	<form action="" method="post"> <!-- action을 표기하지 않을 경우 post의 같은 주소로 -->
		<div>
			<label for="userid">아이디</label>
			<input type="text" name="userid" id="userid" />
		</div>
		<div>
			<label for="password">패스워드</label>
			<input type="password" name="password" id="password" />
		</div>
		<div>
			<label for="age">나이</label>
			<input type="text" name="age" id="age" value='<%=request.getParameter("age")%>' />
		</div>
		<div>
			<button>전송</button>
		</div>
	</form>
</body>
</html>