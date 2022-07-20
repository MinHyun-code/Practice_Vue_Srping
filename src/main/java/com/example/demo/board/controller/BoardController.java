package com.example.demo.board.controller;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.board.dto.BoardDto;
import com.example.demo.board.service.BoardServiceImpl;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class BoardController {
	private final BoardServiceImpl boardSerivce;

	// 게시판 조회
	@RequestMapping(method = RequestMethod.GET, value = "/api/board")
    public List<BoardDto> boardList(@RequestParam(required = false) String board_title){
    	BoardDto boardDto = new BoardDto();
    	boardDto.setBoard_title(board_title);
    	List<BoardDto> board_list = boardSerivce.board_list(boardDto);
        return board_list;
    }
    
	// 게시글 등록
    @RequestMapping(method = RequestMethod.POST, value = "/board")
    public void boardInsert(@RequestParam String board_title, @RequestParam String board_content, @RequestParam String reg_id){
    	BoardDto boardDto = new BoardDto();
    	boardDto.setBoard_title(board_title); 
    	boardDto.setBoard_content(board_content);
    	boardDto.setReg_id(reg_id);
    	boardSerivce.board_insert(boardDto);
    }
    
    // 게시글 상세보기
    @RequestMapping(method = RequestMethod.GET, value = "/board/{board_num}")
    public BoardDto boardDetail(@PathVariable int board_num){
    	BoardDto boardDto = new BoardDto();
    	boardDto = boardSerivce.boardDetail(board_num);
    	boardSerivce.boardReadCnt(board_num);
    	return boardDto;
    }
    
    // 게시글 삭제
    @RequestMapping(method = RequestMethod.DELETE, value = "/board/{board_num}")
    public void boardDelete(@PathVariable int board_num){
    	boardSerivce.board_delete(board_num);
    }
}