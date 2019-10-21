package com.soo.test2.domain;

import java.io.Serializable;

public class Member implements Serializable  {
  private static final long serialVersionUID = 1L;
  
  int memberNo;
  String id;
  String password;
  String photo;
  public int getMemberNo() {
    return memberNo;
  }
  public void setMemberNo(int memberNo) {
    this.memberNo = memberNo;
  }
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getPhoto() {
    return photo;
  }
  public void setPhoto(String photo) {
    this.photo = photo;
  }
  public static long getSerialversionuid() {
    return serialVersionUID;
  }

}
