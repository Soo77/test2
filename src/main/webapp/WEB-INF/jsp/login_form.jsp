<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>로그인 폼</title>

<script type="text/javascript">
  function checkValue() {
    inputForm = eval("document.loginInfo");
    if (!inputForm.id.value) {
      alert("아이디를 입력하세요");
      inputForm.id.focus();
      return false;
    }
    if (!inputForm.password.value) {
      alert("비밀번호를 입력하세요");
      inputForm.password.focus();
      return false;
    }
  }

  // 회원가입 버튼 클릭시 회원가입 화면으로 이동
  function goJoinForm() {
    location.href = "JoinForm.jsp";
  }
</script>

<style>
#login {
  margin-left: 20px;
}
</style>
</head>
<body>
  <div id='content'>
    <h1>로그인 폼</h1>
    <form name="loginInfo" action='login' method='post' 
    onsubmit="return checkValue()">
      아이디 : <input type='text' name='id'><br> 비밀번호 : <input
        type='text' name='password'>
      <button id="login">로그인</button>
      <br>
      <br> <input id="findIdBtn" type="button" value="아이디 찾기">
    </form>
  </div>

  <script>
      var cbtn = document.querySelector("#findIdBtn");
      cbtn.addEventListener("click", function() {
        location.href = "../app/findId";
      });
    </script>

</body>
</html>