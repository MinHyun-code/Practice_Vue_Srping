package com.example.demo.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.board.dto.BoardDto;

@Repository
@Mapper
public interface BoardMapper {
	List<BoardDto> board_list(BoardDto boardDto);
	void board_insert(BoardDto boardDto);
	BoardDto boardDetail(int board_num);
	void board_delete(int board_num);
	void boardReadCnt(int board_num);
}