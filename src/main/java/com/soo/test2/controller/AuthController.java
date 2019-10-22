package com.soo.test2.controller;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.soo.test2.dao.MemberDao;
import com.soo.test2.dao.MemberDao3;

@Controller
public class AuthController {
  
  @Resource
  private MemberDao memberDao;
  @Resource
  private MemberDao3 memberDao3;
  
  @RequestMapping(path = "login_form",
      method = RequestMethod.GET)
  public void login_form() {
  }

  @RequestMapping(path = "login",
  method = RequestMethod.POST)
  public String login(String id, String passsword) throws Exception {
    Map<String, Object> params = new HashMap<>();
    params.put("id", id);
    params.put("password", passsword);
    
    memberDao.logincheck(params);
    return "redirect:../app/board/list";
  }

  @RequestMapping(path = "findId",
      method = RequestMethod.GET)
  public void findId() {
  }

  @RequestMapping(path = "findID",
  method = RequestMethod.POST)
  public String findID(HttpSession session, String email, Model model) throws Exception {
    String id = memberDao3.findingID(email);
    System.out.println("test" + id);
    session.setAttribute("ohoraid", id);
    return "redirect:../app/resultId";
  }
  
  @RequestMapping(path = "resultId",
      method = RequestMethod.GET)
  public void resultId() {
  }
  
  
}
