package com.example.demo.plan.dto;

import java.util.Date;

import lombok.Data;

@Data
public class PlanDto {

	private int seq;
	private Date plan_start_date;
	private Date plan_end_date;
	private String reg_user_id;
	private String plan_title;
	private int plan_type;
	
}
