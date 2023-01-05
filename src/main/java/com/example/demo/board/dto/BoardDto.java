package com.example.demo.board.dto;

import lombok.Data;

@Data
public class BoardDto {

	private String board_num;
	private String board_title;
	private String board_content;
	private int row_num;
	private String board_date;
	private String reg_id;
	private int board_read_cnt;
	
	private int start;
	private int pageSize;
	private int limit;
}
