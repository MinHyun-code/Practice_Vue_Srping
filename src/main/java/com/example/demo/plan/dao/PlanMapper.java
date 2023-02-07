package com.example.demo.plan.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.plan.dto.PlanDto;

@Repository
@Mapper
public interface PlanMapper {
	List<Map<String, Object>> planList(PlanDto planDto);
	void planUpdate(PlanDto planDto);
	void planDelete(PlanDto planDto);
	PlanDto planDetail(int planDto);
	PlanDto planInsert(PlanDto planDto);
}