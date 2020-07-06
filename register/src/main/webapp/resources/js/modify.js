/**
 * changePwd.jsp 유효성 검증하기
 */
// 규칙
// 비밀번호 : 영문자, 숫자, 특수문자 조합으로 8~15자리

$(function(){
	$("#changePwd").validate({
		// 규칙명시
		rules:{
			password:{
				required : true,
			},
			new_password:{
				required : true,
				validPWD : true
			},
			confirm_password:{
				required : true,
				validPWD : true,
//				equalTo : "#new_password"
			}
		}, // 규칙 끝 
		// 메세지
		messages:{
			password:{
				required : "현재 비밀번호는 필수 속성입니다."
			},
			new_password:{
				required : "비밀번호는 필수 속성입니다."
			},
			confirm_password:{
				required : "비밀번호는 필수 속성입니다.",
//				equalTo : "입력한 비밀번호와 다릅니다."
			}
		},// messages end
		// 에러메세지 위치 지정
		errorPlacement:function(error,element){ 
			$(element).closest("form").find("small[id='"+element.attr("id")+"']").append(error);
		}
	})
})

// 유효성 검증
$.validator.addMethod("validPWD",function(value){
	const regPwd = /(?=^[A-z])(?=.*\d)(?=.*[!@#$%^&*])[A-z\d!@#$%^&*]{8,15}$/;
	return regPwd.test(value);
}, "비밀번호는 영문자, 숫자, 특수문자의 조합으로 8~15자리 만들어야 합니다.");
