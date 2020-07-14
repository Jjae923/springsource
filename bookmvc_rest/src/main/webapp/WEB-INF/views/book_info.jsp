<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
      integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
      crossorigin="anonymous"
    />
	<script
	  src="https://code.jquery.com/jquery-3.5.1.min.js"
	  integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
	  crossorigin="anonymous"></script>
    <script
      src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
      integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
      crossorigin="anonymous"
    ></script>
    <title>도서 관리 시스템</title>
  </head>
  <body>
    <div class="jumbotron">
      <h3>Ajax로 구현한 도서관리시스템</h3>
    </div>
    <div class="container">
    	<button type="button" id="get">도서 정보 하나 가져오기</button>
    	<button type="button" id="remove">도서 정보 삭제하기</button>
    	<button type="button" id="modify">도서 정보 수정하기</button>
    </div>
    <div id ="result">
    	<table class="table">
    		
    	</table>
    </div>
<script>
$(function(){
	// 버튼이 눌러지면
	$("#get").click(function(){
		// 결과를 보여줄 위치 가져오기
		let result = $("#result table");
		
		// http://localhost:8080/1234 + get
		// http://localhost:8080/code + get방식 요청을 한 후
		// 서버가 보내주는 json 데이터를 result에 테이블 형태로 보여주기
		$.ajax({
			url : '1234',
			type : 'get',
			success : function(item){
				console.log(item);
				let str="";
				
				str += "<tr><td>";
				str += item.code + "</td><td>" + item.title + "</td>";
				str += "<td>" + item.writer + "</td><td>" + item.price + "</td></tr>";
					
				result.html(str);
			}
		})	
	})
	
	// 삭제하기
	$("#remove").click(function(){
		$.ajax({
			url : '2277',
			type : 'delete',
			success : function(data){
				console.log(data);
				alert(data);
			},
			error : function(xhr, txtStatus, error){
				alert(xhr.responseText);
			}
		})
	})
	
	// 수정하기
	// JSON.stringify() : 클라이언트 측에서 서버로 데이터를 보낼 때 사용
	// 					  자바스크립트 객체를 변환 시켜서 보내줌
	$("#modify").click(function(){
		// 코드랑 가격 => 
		let param = {
			code : '1003',
			price : 50000
		};
		
		$.ajax({
			url : '/modify',
			type : 'put',
			contentType : "application/json",
			data : JSON.stringify(param),
			success : function(data){
				alert(data);
			},
			error : function(xhr, txtStatus, error){
				alert(xhr.responseText);
			}
		})
	})
})
</script>
</body>
</html>
