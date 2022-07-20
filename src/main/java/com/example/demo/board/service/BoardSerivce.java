package com.example.demo.board.service;

import java.util.List;
import com.example.demo.board.dto.BoardDto;

public interface BoardSerivce {
    public List<BoardDto> board_list(BoardDto boardDto);
    void board_insert(BoardDto boardDto);
    BoardDto boardDetail(int board_num);
    void board_delete(int board_num);
    void boardReadCnt(int board_num);
}