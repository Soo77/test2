<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='../css/join_style.css' rel='stylesheet' style='text/css'/>

    <script type="text/javascript">
    
        // 필수 입력정보인 아이디, 비밀번호가 입력되었는지 확인하는 함수
        function checkValue()
        {
            if(!document.userInfo.id.value){
                alert("아이디를 입력하세요.");
                return false;
            }
            
            if(!document.userInfo.password.value){
                alert("비밀번호를 입력하세요.");
                return false;
            }
            
            // 비밀번호와 비밀번호 확인에 입력된 값이 동일한지 확인
            if(document.userInfo.password.value != document.userInfo.passwordcheck.value ){
                alert("비밀번호를 동일하게 입력하세요.");
                return false;
            }
        }
        
        // 취소 버튼 클릭시 로그인 화면으로 이동
        function goLoginForm() {
            location.href="login_form.jsp";
        }
    </script>



</head>
<body>

<form action="register"
      method="post"
      enctype="multipart/form-data">
  <h1>회원가입</h1>
  아이디 : <input type="text" name="id"><br>
  비밀번호 : <input type="text" name="password"><br>
  비밀번호확인 : <input type="text" name="passwordcheck"><br>

  사진 : <input type="file" name="photoFile"><br>
  <button>등록</button>
</form>
</body>
</html>