package com.example.demo.map.dto;

import java.util.List;

import lombok.Data;

@Data
public class MapDto {

	private int seq;
	private String address;
	private String latitude;
	private String longitude;
	private String building_nm;
	
	
	//map Detail
	private int address_no;
	private String shop_nm;
	private String shop_call;
	private String shop_address;
	private String shop_intro;
	private String reg_user_id;
	private String del_user_id;
	private String del_flag;
	
	//map Review
	private int review_seq;
	private String review_title;
	private String review_content;
	private int review_read_cnt;
	
	//image List
	private List<ImageDto> imageDto;
	
	
}
