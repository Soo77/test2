package com.soo.test2.controller;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.soo.test2.dao.MemberDao;

@Controller
public class AuthController {
  
  @Resource
  private MemberDao memberDao;
  
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


  
}
