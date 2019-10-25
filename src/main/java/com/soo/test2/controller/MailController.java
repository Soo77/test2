package com.soo.test2.controller;

import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MailController {
  
  @Autowired
  private JavaMailSender mailSender;
  
  private String from = "bitcamppr@fastmail.com";
  private String subject = "메일제목 (생략가능)";
  
  @RequestMapping("/mail")
  public String mail(String text) {
    return "mail_test";
  }

  @RequestMapping("/mail/send")
  public String sendMail(String text) {
    try {
      System.out.println("test" + text);
      MimeMessage message = mailSender.createMimeMessage();
      MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
      messageHelper.setTo("yimsb05@gmail.com");
      messageHelper.setText(text);
      messageHelper.setFrom(from);
      messageHelper.setSubject(subject);
      
      mailSender.send(message);
    } catch (Exception e) {
      System.out.println(e);
    }
    
    return "success";
  }
}
