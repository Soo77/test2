<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>회원가입 화면</title>

<!-- css 파일 분리 -->
<link href='../css/join_style.css' rel='stylesheet' style='text/css' />

<script type="text/javascript">
    
        // 필수 입력정보인 아이디, 비밀번호가 입력되었는지 확인하는 함수
        function checkValue()
        {
            if(document.userInfo.memberTypeNo.value == ""){
              alert("회원 구분을 해주세요.");
              return false;
            }
          
            if(!document.userInfo.id.value){
                alert("아이디를 입력하세요.");
                return false;
            }
            
            if(!document.userInfo.password.value){
                alert("비밀번호를 입력하세요.");
                return false;
            }
            
            if(!document.userInfo.name.value){
              alert("이름을 입력하세요.");
              return false;
            }
            
            if(!document.userInfo.gender.value){
              alert("성별을 선택하세요.");
              return false;
            }
            
            // 비밀번호와 비밀번호 확인에 입력된 값이 동일한지 확인
            if(document.userInfo.password.value != document.userInfo.passwordcheck.value ){
                alert("비밀번호를 동일하게 입력하세요.");
                return false;
            }
            
            if(isNaN(form.birthyy.value)) {
              alert("년도는 숫자만 입력가능합니다.");
              return false;
            }
        }
        
        // 취소 버튼 클릭시 로그인 화면으로 이동
        function goLoginForm() {
            location.href="../board/list.jsp";
        }
    </script>

</head>
<body>
  <!-- div 왼쪽, 오른쪽 바깥여백을 auto로 주면 중앙정렬된다.  -->
  <div id="wrap">
    <br> <br> <b><font size="6" color="gray">회원가입</font></b> <br>
    <br> <br>


    <!-- 입력한 값을 전송하기 위해 form 태그를 사용한다 -->
    <!-- 값(파라미터) 전송은 POST 방식, 전송할 페이지는 JoinPro.jsp -->
    <form method="post" action="register2" name="userInfo"
      enctype="multipart/form-data" onsubmit="return checkValue()">
      <table>

        <tr>
          <td id="title">회원구분</td>
          <td><select name="memberTypeNo">
              <option value="">회원구분</option>
              <option value="1">student</option>
              <option value="2">parents</option>
              <option value="3">teacher</option>
              <option value="4">admin</option>
          </select>
        </tr>


        <tr>
          <td id="title">아이디</td>
          <td><input type="text" name="id" maxlength="50"
            onkeydown="inputIdChk()"> <input type="button"
            value="중복확인" onclick="openIdChk()"> <input
            type="hidden" name="idDuplication" value="idUncheck">
          </td>
        </tr>

        <tr>
          <td id="title">비밀번호</td>
          <td><input type="password" name="password" maxlength="50">
          </td>
        </tr>

        <tr>
          <td id="title">비밀번호 확인</td>
          <td><input type="password" name="passwordcheck"
            maxlength="50"></td>
        </tr>

        <tr>
          <td id="title">이름</td>
          <td><input type="text" name="name" maxlength="50">
          </td>
        </tr>

        <tr>
          <td id="title">성별</td>
          <td><input type="radio" name="gender" value="M">남
            <input type="radio" name="gender" value="F">여</td>
        </tr>

        <tr>
          <td id="title">프로필 사진</td>
          <td><input type="file" name="profile"></td>
        </tr>

        <tr>
          <td id="title">생일</td>
          <td><input type="text" name="birthyy" maxlength="4"
            placeholder="년(4자)" size="6"> <select name="birthmm">
              <option value="">월</option>
              <option value="01">1</option>
              <option value="02">2</option>
              <option value="03">3</option>
              <option value="04">4</option>
              <option value="05">5</option>
              <option value="06">6</option>
              <option value="07">7</option>
              <option value="08">8</option>
              <option value="09">9</option>
              <option value="10">10</option>
              <option value="11">11</option>
              <option value="12">12</option>
          </select> <input type="text" name="birthdd" maxlength="2"
            placeholder="일" size="4"></td>
        </tr>

        <tr>
          <td id="title">이메일</td>
          <td><input type="text" name="email" maxlength="50">@
            <select name="mail2">
              <option value="naver.com">naver.com</option>
              <option value="daum.net">daum.net</option>
              <option value="gmail.com">gmail.com</option>
              <option value="nate.com">nate.com</option>
          </select></td>
        </tr>

        <tr>
          <td id="title">휴대전화</td>
          <td><input type="text" name="tel" /></td>
        </tr>
        <tr>
          <td id="title">주소 대강</td>
          <td><input type="text" size="50" name="addressCity" /></td>
        </tr>

        <tr>
          <td id="title">주소 상세</td>
          <td><input type="text" size="50" name="addressSuburb" />
          </td>
        </tr>
      </table>
      <br>
      <button>가입</button>
      <input id="cancelbtn" type="button" value="취소">

    </form>
  </div>

  <script>
    var cbtn = document.querySelector("#cancelbtn");
    cbtn.addEventListener("click", function(){
      location.href = "../board/list";
    });
    
  </script>
</body>
</html>


