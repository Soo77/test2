package com.soo.test2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class EmailConfig {
  
  @Bean
  public JavaMailSender mailSender() {
    
    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    mailSender.setHost("smtp.naver.com");
    mailSender.setUsername("yimsb02");
    mailSender.setPassword("bitcamp1111");
    mailSender.setPort(554);
    
    return mailSender;
  }
}
