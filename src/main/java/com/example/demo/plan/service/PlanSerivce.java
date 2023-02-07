package com.example.demo.plan.service;

import java.util.List;
import java.util.Map;

import com.example.demo.plan.dto.PlanDto;

public interface PlanSerivce {
	List<Map<String, Object>> planList(PlanDto planDto);
	void planUpdate(PlanDto planDto);
	void planDelete(PlanDto planDto);
	PlanDto planDetail(int seq);
	PlanDto planInsert(PlanDto planDto);
}