package com.soo.test2.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.soo.test2.dao.BoardDao;
import com.soo.test2.domain.Board;

@Controller
public class BoardController {
  
  @Autowired
  BoardDao boardDao;

  @RequestMapping("/board/form")
  public String form(Model model) throws Exception {
    return "form";
  }
  
  @RequestMapping("/board/add")
  public String add(String ta) throws Exception {
    Board board = new Board();
    board.setContents(ta);
    boardDao.insert(board);
    
    return "redirect:list";
  }
  
  @RequestMapping("/board/list")
  public String list(Model model) throws Exception {
    List<Board> boards = boardDao.findAll();
    
    model.addAttribute("boards", boards);
    
    return "list";
  }
  
  @RequestMapping("/board/detail")
  public String detail(Model model, int no) throws Exception {
    Board board = boardDao.findBy(no);
    model.addAttribute("board", board);
    return "detail";
  }
  
  @RequestMapping("/board/update")
  public String update(Board board) throws Exception {
    boardDao.update(board);
    
    return "redirect:list";
  }
  
  @RequestMapping("/board/delete")
  public String update(int no) throws Exception {
    boardDao.delete(no);
    
    return "redirect:list";
  }
}
