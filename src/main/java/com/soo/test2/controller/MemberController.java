package com.soo.test2.controller;

import java.io.File;
import java.sql.Date;
import java.util.UUID;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
  
//  @RequestMapping("/member/ohora")
//  public String ohora() {
//    return "reg_member";
//  }
  
  @RequestMapping("/member/ohora2")
  public String ohora2() {
    return "joinForm";
  }
  
  @RequestMapping(path = "/member/register2",
      method = RequestMethod.POST)
  public String register(Member testMember, 
      MultipartFile profile,
      MemberType memberType,
      String birthyy,
      String birthmm,
      String birthdd,
      String mail2) throws Exception {
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
    testMemberDao.insert(testMember);
    return "redirect:../board/list";
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
}
