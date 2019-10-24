<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!-- <!DOCTYPE html> -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입 화면</title>

<!-- css 파일 분리 -->
<link href='../css/join_style.css' rel='stylesheet' style='text/css' />
<script type="text/JavaScript"
  src="http://code.jquery.com/jquery-3.1.0.min.js"></script>

<script
  src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
  function addr() {
    new daum.Postcode({
      oncomplete : function(data) {
        // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
        // 예제를 참고하여 다양한 활용법을 확인해 보세요.
        document.getElementById("addressCity").value = data.sido;
        document.getElementById("addressSuburb").value = data.sigungu;
      }
    }).open();
  }
</script>

<script>
  $(document).ready(function() {
    setDateBox();
  });

  // select box 연도 , 월 표시
  function setDateBox() {
    var dt = new Date();
    var year = "";
    var com_year = dt.getFullYear();
    // 발행 뿌려주기
    $("#YEAR").append("<option value=''>년도</option>");
    // 올해 기준으로 -1년부터 +5년을 보여준다.
    for (var y = (com_year - 118); y <= (com_year); y++) {
      $("#YEAR").append("<option value='"+ y +"'>" + y + " 년" + "</option>");
    }
    // 월 뿌려주기(1월부터 12월)
    var month;
    $("#MONTH").append("<option value=''>월</option>");
    for (var i = 1; i <= 12; i++) {
      $("#MONTH").append("<option value='"+ i +"'>" + i + " 월" + "</option>");
    }

    var day;
    $("#DAY").append("<option value=''>일</option>");
    for (var i = 1; i <= 31; i++) {
      $("#DAY").append("<option value='"+ i +"'>" + i + " 일" + "</option>");
    }
  }

  // 필수 입력정보인 아이디, 비밀번호가 입력되었는지 확인하는 함수
  function checkValue() {
    if (document.userInfo.memberTypeNo.value == "") {
      alert("회원 구분을 해주세요.");
      return false;
    }

    if (!document.userInfo.id.value) {
      alert("아이디를 입력하세요.");
      return false;
    }

    if (!document.userInfo.password.value) {
      alert("비밀번호를 입력하세요.");
      return false;
    }

    if (!document.userInfo.name.value) {
      alert("이름을 입력하세요.");
      return false;
    }

    if (!document.userInfo.gender.value) {
      alert("성별을 선택하세요.");
      return false;
    }

    // 비밀번호와 비밀번호 확인에 입력된 값이 동일한지 확인
    if (document.userInfo.password.value != document.userInfo.passwordcheck.value) {
      alert("비밀번호를 동일하게 입력하세요.");
      return false;
    }

    if (isNaN(form.birthyy.value)) {
      alert("년도는 숫자만 입력가능합니다.");
      return false;
    }
  }

  // 취소 버튼 클릭시 로그인 화면으로 이동
  function goLoginForm() {
    location.href = "../board/list.jsp";
  }
</script>
<style>
#view_file {
  display: none;
}
</style>
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
          <td><input type="text" name="id" id="id" maxlength="50">
            <div id="id_check"></div></td>
        </tr>

        <tr>
          <td id="title">비밀번호</td>
          <td><input id="pw" type="password" name="password"
            maxlength="50"></td>
        </tr>

        <tr>
          <td id="title">비밀번호 확인</td>
          <td><input type="password" name="okpw" id="okpw"
            maxlength="50">
            <div id="pw_check"></div></td>
        </tr>

        <tr>
          <td id="title">이름</td>
          <td><input type="text" name="name" id="name"
            maxlength="50">
            <div id="name_check"></div></td>
        </tr>

        <tr>
          <td id="title">성별</td>
          <td><input type="radio" name="gender" value="M">남
            <input type="radio" name="gender" value="F">여</td>
        </tr>

        <tr>
          <td id="title">프로필 사진</td>
          <td><input type="file" name="profile"> <img
            id="view_file" src="#" width="400px" height="200px" /></td>
        </tr>

        <tr>
          <td id="title">생년월일</td>
          <td><select name="birthyy" id="YEAR" title="년도"
            class="select w80"></select> <select name="birthmm"
            id="MONTH" title="월" class="select w80"></select> <select
            name="birthdd" id="DAY" title="일" class="select w80"></select>
          </td>
        </tr>

        <!--         <tr>
          <td id="title">이메일</td>
          <td><input type="text" id="email" name="email" maxlength="50">@
            <select name="mail2" id="mail2">
              <option value="">메일 선택</option>
              <option value="naver.com">naver.com</option>
              <option value="daum.net">daum.net</option>
              <option value="gmail.com">gmail.com</option>
              <option value="nate.com">nate.com</option>
          </select>
          <div id="email_check"></div></td>
        </tr> -->
        <div class="form-group">
          <label class="control-label">이메일</label> <input type="text"
            id="email" name="email" placeholder="이메일을 입력하세요"
            class="form-control" />
          <button type="button" class="btn btn-info" id="emailBtn">이메일
            발송</button>
          <button type="button" class="btn btn-info" id="emailAuthBtn">이메일
            인증</button>
        </div>
        <input type="hidden" path="random" id="random"
          value="${random }" />


        <tr>
          <td id="title">휴대전화</td>
          <td><input type="text" name="tel" /></td>
        </tr>
        <tr>
          <td id="title">주소</td>
          <td><input id="addressCity" type="text" size="50"
            name="addressCity" /> <input id="addressSuburb" type="text"
            size="50" name="addressSuburb" /> <input type="button"
            onclick="addr()" value="주소 검색" /></td>
        </tr>

        <!--         <tr>
          <td id="title">주소 상세</td>
          <td><input id="addressSuburb" type="text" size="50" name="addressSuburb" />
          </td>
        </tr> -->
      </table>
      <br>
      <button>가입</button>
      <input id="cancelbtn" type="button" value="취소">

    </form>
  </div>

  <script>
      var cbtn = document.querySelector("#cancelbtn");
      cbtn.addEventListener("click", function() {
        location.href = "../board/list";
      });
    </script>


  <!-- 프로필 사진 -->
  <script>
      $("#filePath").change(function() {
        var input = document.getElementById("filePath");
        if (input.files && input.files[0]) {
          var reader = new FileReader();
          reader.onload = function(e) {
            $('#view_file').attr('src', e.target.result);
          }
          reader.readAsDataURL(input.files[0]);
        }
        var dp = document.getElementById("view_file");
        dp.style.display = "block";
      });
    </script>

  <!-- 아이디 유효성 검사(1 = 중복 / 0 != 중복) -->
  <script>
      $("#id").blur(function() {
        var id = $('#id').val();
        var param = "id=" + id;
        $.ajax({
          url : 'idCheck',
          type : 'get',
          data : param,
          success : function(result) {
            if (result >= 1) {
              $("#id_check").text("사용중인 아이디입니당");
              $("#id_check").css("color", "red");
              $("#id").css("color", "red");
              $("#submit").attr("disabled", true);
            } else {
              if (id) {
                $("#id_check").text("사용 가능한 아이디입니당");
                $("#id_check").css("color", "green");
                $("#id").css("color", "green");
                $("#submit").attr("disabled", false);
              } else if (id == "") {
                $('#id_check').text('아이디를 입력해주세요 :)');
                $('#id_check').css('color', 'red');
                $("#submit").attr("disabled", true);
              }
            }
          },
          error : function() {
            console.log("실패");
          }
        });
      });
    </script>

  <!-- 비밀번호 확인 -->
  <script>
      $("#okpw").blur(function() {
        var pw = document.getElementById("pw").value;
        var okpw = document.getElementById("okpw").value;

        if (pw != okpw) {
          $("#pw_check").text("비밀번호가 틀립니다");
          $("#pw_check").css("color", "red");
          $("#okpw").css("color", "red");
          $("#submit").attr("disabled", true);
        } else if (okpw == "") {
          $('#pw_check').text('비밀번호를 입력해주세요 :)');
          $('#pw_check').css('color', 'red');
          $("#submit").attr("disabled", true);
        } else {
          $("#pw_check").text("비밀번호가 일치합니당");
          $("#pw_check").css("color", "green");
          $("#okpw").css("color", "green");
          $("#submit").attr("disabled", false);
        }
      });
    </script>

  <script>
      $("#name").blur(function() {
        var name = document.getElementById("name").value;
        if (name == "") {
          $('#name_check').text('이름을 입력해주세요 :)');
          $('#name_check').css('color', 'red');
          $("#submit").attr("disabled", true);
        }
      });
    </script>

  <script>
      $("#mail2").change(function() {
        var email = $('#email').val() + "@" + $('#mail2').val();
        var param = "email=" + email;
        $.ajax({
          url : 'emailCheck',
          type : 'get',
          data : param,
          success : function(result) {
            if (result >= 1) {
              $("#email_check").text("사용중인 이메일입니당");
              $("#email_check").css("color", "red");
              $("#email").css("color", "red");
              $("#submit").attr("disabled", true);
            } else {
              if (email) {
                $("#email_check").text("사용 가능한 이메일입니당");
                $("#email_check").css("color", "green");
                $("#email").css("color", "green");
                $("#submit").attr("disabled", false);
              } else if (email == "") {
                $('#email_check').text('이메일을 입력해주세요 :)');
                $('#email_check').css('color', 'red');
                $("#submit").attr("disabled", true);
              }
            }
          },
          error : function() {
            console.log("실패");
          }
        });
      });
    </script>

  <script>
$(function(){
  /*
  이메일 인증 버튼 클릭시 발생하는 이벤트
  */
  $(document).on("click", "#emailBtn", function(){
  /* 이메일 중복 체크 후 메일 발송 비동기 처리 */
  $.ajax({
    beforeSend: function(){
      loadingBarStart();
  },
  type:"get",
  url : "<c:url value='/login/createEmailCheck.do'/>",
  data : "userEmail=" + $("#userEmail").val() + "&random=" + $("#random").val(),
  //data: "userEmail="+encodeURIComponent($('#userEmail').val()),
  /* encodeURIComponent
  예를들어, http://a.com?name=egoing&job=programmer 에서 &job=programmer
  중 '&'는 하나의 파라미터가 끝나고 다음 파라미터가 온다는 의미이다.
  그런데 다음과 같이 job의 값에 &가 포함된다면 시스템은 job의 값을 제대로 인식할수 없게 된다. */
  success : function(data){
  alert("사용가능한 이메일입니다. 인증번호를 입력해주세요.");
  }
  },
  error: function(data){
  alert("에러가 발생했습니다.");
  return false;
  }
  })
  })
  /*
  이메일 인증번호 입력 후 인증 버튼 클릭 이벤트
  */
  $(document).on("click", "#emailAuthBtn", function(){
  $.ajax({
  beforeSend: function(){
  loadingBarStart();
  },
  type:"get",
  url:"<c:url value='/login/emailAuth.do'/>",
  data:"authCode=" + $('#emailAuth').val() + "&random=" + $("#random").val(),
  success:function(data){
  if(data=="complete"){
  alert("인증이 완료되었습니다.");
  }else if(data == "false"){
  alert("인증번호를 잘못 입력하셨습니다.")
  }
  },
  complete: function(){
  loadingBarEnd();
  },
  error:function(data){
  alert("에러가 발생했습니다.");
  }
  });
  });
  });
</script>



</body>
</html>


