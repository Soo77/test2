package com.soo.test2.controller;

import java.io.File;
import java.sql.Date;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.soo.test2.dao.MemberDao;
import com.soo.test2.domain.Member;
import com.soo.test2.domain.MemberType;

@Controller
public class MemberController {
  
  @Autowired
  MemberDao testMemberDao;
  
  String uploadDir;
  
  public MemberController(ServletContext sc) {
    uploadDir = sc.getRealPath("/upload");
  }
  
  @RequestMapping("/member/ohora2")
  public String ohora2() {
    return "joinForm";
  }
  
  @RequestMapping(path = "/member/register2",
      method = RequestMethod.POST)
  public String register(Member testMember, 
      MultipartFile profile,
      MemberType memberType,
      String id,
      String birthyy,
      String birthmm,
      String birthdd,
      String mail2,
      HttpSession httpSession) throws Exception {
    System.out.println(birthyy + " " + birthmm + " " + birthdd);
    String emailAddress = testMember.getEmail() + "@" + mail2;
    String dob = birthyy + "-" + birthmm + "-" + birthdd;
    Date testdob = Date.valueOf(dob);
    testMember.setEmail(emailAddress);
    testMember.setDateOfBirth(testdob);
    testMember.setMemberType(memberType);
    
    if (!profile.isEmpty()) {
    String filename = UUID.randomUUID().toString();
    profile.transferTo(new File(uploadDir + "/" + filename));
    testMember.setProfilePhoto(filename);
    }
    String key = new TempKey().getKey(50, false);
    testMember.setActivationKey(key);
    testMemberDao.insert(testMember);
    //System.out.println(whatmail + "왓멜");
    System.out.println(emailAddress + "이멜");
    
    String host = "smtp.fastmail.com"; 
    // 네이버일 경우 네이버 계정, gmail경우 gmail 계정
    String user = "bitcamppr@fastmail.com"; 
    // 패스워드
    String password = "ENCRJ3GAJV56WZG9";      

    // SMTP 서버 정보를 설정한다. 
    Properties props = new Properties(); 
    props.put("mail.smtp.host", host); 
    props.put("mail.smtp.port", 465); 
    props.put("mail.smtp.auth", "true"); 
    props.put("mail.smtp.ssl.enable", "true"); 
    props.put("mail.smtp.ssl.trust", host);

    Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() { 
      protected PasswordAuthentication getPasswordAuthentication() { 
        return new PasswordAuthentication(user, password); 
      } 
    });
    
    try { 
      MimeMessage message = new MimeMessage(session);
      message.setFrom(new InternetAddress(user));
      message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailAddress)); 

      System.out.println(key);

      message.setSubject("[이메일 인증]");

      String htmlStr = "<h2>안녕하세요 엄과외입니다!</h2><br><br>" 
        + "<h3>" + id + "님</h3>" + "<p>인증하기 버튼을 누르시면 로그인을 하실 수 있습니다 : " 
        + "<a href='http://localhost:8888/app/emailConfirm?key="+key+"'>인증하기</a></p>"
        + "(혹시 잘못 전달된 메일이라면 이 이메일을 무시하셔도 됩니다)";
      message.setText(htmlStr, "utf-8", "html");
      
      Transport.send(message); 
    } catch (MessagingException e) { 
      e.printStackTrace(); 
    }

    return "/view/checkplease";
    //return "redirect:../board/list";
  }
  
  @GetMapping("/member/idCheck")
  @ResponseBody
  public int idCheck(String id) {
    return testMemberDao.checkOverId(id);
  }
  
  @GetMapping("/member/emailCheck")
  @ResponseBody
  public int emailCheck(String email) {
    return testMemberDao.checkOverEmail(email);
  }
  
  
  
  
public class TempKey {
    
    private boolean lowerCheck;
    private int size;
    
    public String getKey(int size, boolean lowerCheck) {
        this.size = size;
        this.lowerCheck = lowerCheck;
        return init();
    }
    
    private String init() {
        Random ran = new Random();
        StringBuffer sb = new StringBuffer();
        int num = 0;
        do {
            num = ran.nextInt(75)+48;
            if((num>=48 && num<=57) || (num>=65 && num<=90) || (num>=97 && num<=122)) {
                sb.append((char)num);
            }else {
                continue;
            }
        } while (sb.length() < size);
        if(lowerCheck) {
            return sb.toString().toLowerCase();
        }
        return sb.toString();
    }
    
}
  
  @RequestMapping(value="emailConfirm", method=RequestMethod.GET)
  public String emailConfirm(String key, Model model) {
    testMemberDao.updateCheck(key);
    System.out.println(key);
    return "/view/welcome";
  }
  
}
