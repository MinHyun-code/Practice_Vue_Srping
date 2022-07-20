package com.example.demo.map.dto;

import lombok.Data;

@Data
public class ImageDto {

	private int id;
	private int seq;
	private int address_no;
	private String mimetype;
    private String original_name;
    private String data;
    private String created;
}
