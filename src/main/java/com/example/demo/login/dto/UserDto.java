package com.example.demo.login.dto;

import lombok.Data;

@Data
public class UserDto {

	private boolean login_tf = false;
	private String user_id;
	private String user_pw;
	private String user_name;
	private String user_birth;
	private String user_reg_date;
	private String user_type;
	private String message;
}
