package com.example.demo.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.board.dto.BoardDto;

@Repository
@Mapper
public interface BoardMapper {
	List<Map<String, Object>> board_list(BoardDto boardDto);
	int board_cnt(BoardDto boardDto);
	void board_insert(BoardDto boardDto);
	BoardDto boardDetail(int board_num);
	void board_delete(int board_num);
	void boardReadCnt(int board_num);
}