package com.soo.test2.controller;

import java.io.File;
import java.util.UUID;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import com.soo.test2.dao.MemberDao;
import com.soo.test2.domain.Member;

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
  
  @RequestMapping("/member/ohora")
  public String ohora() {
    return "joinForm";
  }
  
  @RequestMapping(path = "/member/register",
      method = RequestMethod.POST)
  public String register(Member testMember, 
      MultipartFile photoFile) throws Exception {
    String filename = UUID.randomUUID().toString();
    photoFile.transferTo(new File(uploadDir + "/" + filename));
    testMember.setPhoto(filename);
    testMemberDao.insert(testMember);
    return "redirect:../board/list";
  }
  
  
}
