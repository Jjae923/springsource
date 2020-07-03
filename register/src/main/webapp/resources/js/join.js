/**
 * joinForm.jsp 유효성 검증하기
 */
// 규칙
// 아이디 : 영문자, 숫자, 특수문자 조합으로 6~12자리
// 비밀번호 : 영문자, 숫자, 특수문자 조합으로 8~15자리
// 이름 : 2~4자리 입력 가능
// 성별 : 필수 입력
// 이메일 : 필수 입력, 이메일 검증

$(function(){
	$("#regist").validate({
		// 규칙명시
		rules:{
			userid:{
				required : true,
				validID : true,
				remote : { // validate 메뉴얼 => ajax가 아닌 remote로 표기
					url : "/register/checkId",
					type : "post",
					data : {
						userid : function(){
							return $('#userid').val();
						}
					}
				}
			},
			password:{
				required : true,
				validPWD : true
			},
			confirm_password:{
				required : true,
				validPWD : true,
				equalTo : "#password"
			},
			name:{
				required : true,
				validNAME : true
			},
			gender:{
				required : true
			},
			email:{
				required : true,
				email : true
			}
		}, // 규칙 끝 
		// 메세지
		messages:{
			userid:{
				required : "아이디는 필수 속성입니다.",
				remote : "이 아이디는 사용중입니다."
			},
			password:{
				required : "비밀번호는 필수 속성입니다."
			},
			confirm_password:{
				required : "비밀번호는 필수 속성입니다.",
				equalTo : "입력한 비밀번호와 다릅니다."
			},
			name:{
				required : "이름은 필수 속성입니다."
			},
			gender:{
				required : "성별은 필수 속성입니다."
			},
			email:{
				required : "이메일은 필수 속성입니다.",
				email : "이메일을 확인해주세요."
			}
		},// messages end
		// 에러메세지 위치 지정
		errorPlacement:function(error,element){ 
			$(element).closest("form").find("small[id='"+element.attr("id")+"']").append(error);
		}
	})
})

// 유효성 검증
$.validator.addMethod("validID",function(value){
	const regId = /(?=.*[A-z])(?=.*\d)(?=.*[!@#$%^&*])[A-z\d!@#$%^&*]{6,12}/;
	return regId.test(value);
}, "아이디는 영문자, 숫자, 특수문자의 조합으로 6~12자리 만들어야 합니다.");
$.validator.addMethod("validPWD",function(value){
	const regPwd = /(?=^[A-z])(?=.*\d)(?=.*[!@#$%^&*])[A-z\d!@#$%^&*]{8,15}$/;
	return regPwd.test(value);
}, "비밀번호는 영문자, 숫자, 특수문자의 조합으로 8~15자리 만들어야 합니다.");
$.validator.addMethod("validNAME",function(value){
	const regName = /^[가-힣]{2,4}$/;
	return regName.test(value);
}, "이름은 2~4자리로 입력해주세요.");
