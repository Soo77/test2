package com.soo.test2.dao;

import java.sql.Date;
import java.util.Map;
import com.soo.test2.domain.Member;

// DAO 사용 규칙을 정의한다.
public interface MemberDao {
  int insert(Member member) throws Exception;
  //Member logincheck(Map<String, Object> params)throws Exception;
  public Date stringToDate(Member member) throws Exception;
  public int logincheck(String id, String pw) throws Exception;
  public String findingID(String email) throws Exception;
  int checkOverId(String id);
  int checkOverEmail(String email);
  int updateCheck(String key);
}








