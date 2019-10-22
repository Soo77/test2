package com.soo.test2.dao;

import java.sql.Date;
import com.soo.test2.domain.Member;
import com.soo.test2.domain.Member3;

// DAO 사용 규칙을 정의한다.
public interface MemberDao3 {
  int insert(Member3 member) throws Exception;
  //Member logincheck(Map<String, Object> params)throws Exception;
  public Date stringToDate(Member member) throws Exception;
  //public int loginCheck(String id, String pw) throws Exception;
  public String findingID(String email) throws Exception;
}








