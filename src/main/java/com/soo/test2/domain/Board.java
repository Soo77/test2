package com.soo.test2.domain;

import java.io.Serializable;

public class Board implements Serializable {
  private static final long serialVersionUID = 1L;
  
  private int no;
  
  private String contents;
  
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getContents() {
    return contents;
  }
  public void setContents(String contents) {
    this.contents = contents;
  }
 
}
