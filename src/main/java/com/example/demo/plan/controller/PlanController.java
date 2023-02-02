package com.example.demo.plan.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.plan.dto.PlanDto;
import com.example.demo.plan.service.PlanServiceImpl;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PlanController {
	private final PlanServiceImpl planSerivce;
	
	// 일정 조회
	@RequestMapping(method = RequestMethod.POST, value = "/api/plan")
    public List<Map<String, Object>> boardList(HttpServletRequest request){

		List<Map<String, Object>> mapList = null;

		try {
	    	PlanDto planDto = new PlanDto();
	    	mapList = planSerivce.planList(planDto);
		} catch (Exception e) {
		}
        return mapList;
    }


}