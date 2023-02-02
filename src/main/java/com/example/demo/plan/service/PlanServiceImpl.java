package com.example.demo.plan.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.example.demo.plan.dao.PlanMapper;
import com.example.demo.plan.dto.PlanDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlanServiceImpl implements PlanSerivce {
    private final PlanMapper planMapper;

	@Override
	public List<Map<String, Object>> planList(PlanDto planDto) {
		return planMapper.planList(planDto);
	}


}