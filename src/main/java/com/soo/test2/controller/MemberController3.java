package com.soo.test2.controller;

import java.io.File;
import java.util.UUID;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import com.soo.test2.dao.MemberDao3;
import com.soo.test2.domain.Member3;
import com.soo.test2.domain.MemberType;

@Controller
public class MemberController3 {
  
  @Autowired
  MemberDao3 testMemberDao;
  
  String uploadDir;
  
  public MemberController3(ServletContext sc) {
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
  public String register(Member3 testMember, 
      /* MultipartFile photoFile, */
      MemberType memberType) throws Exception {
    testMember.setMemberType(memberType);
//    String filename = UUID.randomUUID().toString();
//    photoFile.transferTo(new File(uploadDir + "/" + filename));
//    testMember.setProfilePhoto(filename);
    testMemberDao.insert(testMember);
    return "redirect:../board/list";
  }
  
}
