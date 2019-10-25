package com.soo.test2.service;

public interface MailService {
  public boolean send(String subject, String text, String from, String to, String filePath);
}

