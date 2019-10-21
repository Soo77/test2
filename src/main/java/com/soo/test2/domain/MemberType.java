package com.soo.test2.domain;

public class MemberType {
  private int memberTypeNo;
  private String memberTypeName;
  
  @Override
  public String toString() {
    return "MemberType [memberTypeNo=" + memberTypeNo + ", memberTypeName=" + memberTypeName + "]";
  }
  public int getMemberTypeNo() {
    return memberTypeNo;
  }
  public void setMemberTypeNo(int memberTypeNo) {
    this.memberTypeNo = memberTypeNo;
  }
  public String getMemberTypeName() {
    return memberTypeName;
  }
  public void setMemberTypeName(String memberTypeName) {
    this.memberTypeName = memberTypeName;
  }
}
