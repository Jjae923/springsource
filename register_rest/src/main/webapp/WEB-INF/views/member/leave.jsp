<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<form id="leaveform" action="" method="post">
	<div class="card"  style="width: 40rem;margin:40px auto;">	
		<div class="card-header">
	    	<h4>회원탈퇴</h4>
	  	</div>
	 	<div class="card-body">	
			<div class="form-group row justify-content-center">		
				<div class="col-sm-10">	
					<input type="text" name="userid" id="userid" class="form-control" value="${auth.userid}" readonly/>
			 		<small id="userid" class="text-info"></small>		
				</div>
			</div>	
			<div class="form-group row justify-content-center">		
				<div class="col-sm-10">	
					<input type="password" name="current_password" id = "current_password" class="form-control" placeholder="비밀번호" autofocus="autofocus"/>
					<small id="current_password" class="text-info"></small>
				</div>	
			</div>				
			<div class="form-group text-center">		
				<button type="button" class="btn btn-primary">탈퇴</button>
			    <button type="button" class="btn btn-secondary" id="leavecancel">취소</button>		
			</div>
		</div>
	</div>		
</form>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$(function(){
	// userid와 password를 서버로 보내서 회원탈퇴
	// json 형태로 보낸 후 성공하면 index로 이동
	
	// http://localhost:8080/member/leave + delete
	$(".btn-primary").click(function(e){
		e.preventDefault();
		
		let userid = $("#userid").val();
		let password = $("#current_password").val();
		
		let param = {
			userid : userid,
			password : password
		};
		
		// 폼 안의 데이터를 json 형태로 서버로 보내기
		// 입력 후 결과를 받아 출력하기 
		$.ajax({
			url : 'leave', // http://localhost:8080/member/leave => @delete
			type : 'delete',
			contentType : 'application/json',
			data : JSON.stringify(param),
			success : function(data){
				alert(data);
				location.href='/';
			},
			error : function(xhr, txtStatus, error){
				// alert(xhr.responseText);
				let msg = xhr.responseText;
				if(msg === 'fail'){
					alert('현재 비밀번호를 확인해 주세요');
					$("#current_password").val("");
					$("#current_password").focus();
				}
			}
		})
	})
})
</script>
