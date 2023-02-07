package com.example.demo.plan.dto;

import lombok.Data;

@Data
public class PlanDto {

	private int seq;
	private String start;
	private String end;
	private String reg_user_id;
	private String plan_title;
	private String plan_content;
	private int plan_type;
	
	private String planStDate;
	private String planEdDate;
	
}
