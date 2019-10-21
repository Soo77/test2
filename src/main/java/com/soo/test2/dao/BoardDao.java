package com.soo.test2.dao;

import java.util.List;
import com.soo.test2.domain.Board;

// DAO 사용 규칙을 정의한다.
public interface BoardDao {
  List<Board> findAll() throws Exception;
  int insert(Board board) throws Exception;
  Board findBy(int no) throws Exception;
  int update(Board board) throws Exception;
  int delete(int no) throws Exception;
  int increaseViewCount(int no) throws Exception;
}








