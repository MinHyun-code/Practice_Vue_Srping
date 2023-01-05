package com.example.demo.board.service;

import java.util.List;
import java.util.Map;

import com.example.demo.board.dto.BoardDto;

public interface BoardSerivce {
    List<Map<String, Object>> board_list(BoardDto boardDto);
	int board_cnt(BoardDto boardDto);
    void board_insert(BoardDto boardDto);
    BoardDto boardDetail(int board_num);
    void board_delete(int board_num);
    void boardReadCnt(int board_num);
}