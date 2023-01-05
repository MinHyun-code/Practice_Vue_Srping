package com.example.demo.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.example.demo.board.dao.BoardMapper;
import com.example.demo.board.dto.BoardDto;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardSerivce {
    private final BoardMapper boardMapper;

	@Override
	public List<Map<String, Object>> board_list(BoardDto boardDto) {
		return boardMapper.board_list(boardDto);
	}

	@Override
	public void board_insert(BoardDto boardDto) {
		boardMapper.board_insert(boardDto);
	}

	@Override
	public BoardDto boardDetail(int board_num) {
		return boardMapper.boardDetail(board_num);
	}

	@Override
	public void board_delete(int board_num) {
		boardMapper.board_delete(board_num);
	}

	@Override
	public void boardReadCnt(int board_num) {
		boardMapper.boardReadCnt(board_num);		
	}

	@Override
	public int board_cnt(BoardDto boardDto) {
		return boardMapper.board_cnt(boardDto);
	}

}