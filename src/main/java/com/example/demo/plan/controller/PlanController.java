package com.example.demo.plan.controller;

import java.text.SimpleDateFormat;
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
	private final PlanServiceImpl planService;
	
	// 일정 리스트
	@RequestMapping(method = RequestMethod.POST, value = "/api/plan")
    public List<Map<String, Object>> planList(HttpServletRequest request){

		List<Map<String, Object>> mapList = null;

		try {
	    	PlanDto planDto = new PlanDto();
	    	planDto.setPlanStDate(request.getParameter("year") + "-" + request.getParameter("month") + "-01");
	    	planDto.setPlanEdDate(request.getParameter("year") + "-" + String.format("%02d",(Integer.parseInt(request.getParameter("month"))+1)) + "-01");
	    	planDto.setReg_user_id((request.getParameter("regUserId")));
	    	mapList = planService.planList(planDto);
		} catch (Exception e) {
			System.err.println(e);
		}
        return mapList;
    }
	
	// 일정 조회
	@RequestMapping(method = RequestMethod.POST, value = "/api/plan/detail")
    public PlanDto planDetail(HttpServletRequest request){
		
		PlanDto planDto = new PlanDto();
		
		try {
	    	int seq = Integer.parseInt(request.getParameter("seq"));
	    	planDto = planService.planDetail(seq);
		} catch (Exception e) {
		}
        return planDto;
    }
	
	// 일정 변경
	@RequestMapping(method = RequestMethod.POST, value = "/api/plan/update")
    public void planUpdate(HttpServletRequest request){

		try {
	    	PlanDto planDto = new PlanDto();
	    	planDto.setSeq(Integer.parseInt(request.getParameter("seq")));
	    	planDto.setStart((request.getParameter("start")));
	    	planDto.setEnd((request.getParameter("end")));
	    	planService.planUpdate(planDto);
		} catch (Exception e) {
			System.out.print(e);
		}
    }
	
	// 일정 삭제
	@RequestMapping(method = RequestMethod.POST, value = "/api/plan/delete")
    public void planDelete(HttpServletRequest request){

		try {
	    	PlanDto planDto = new PlanDto();
	    	planDto.setSeq(Integer.parseInt(request.getParameter("seq")));
	    	planService.planDelete(planDto);
		} catch (Exception e) {
			System.out.print(e);
		}
    }
	
	// 일정 등록
	@RequestMapping(method = RequestMethod.POST, value = "/api/plan/insert")
    public void planInsert(HttpServletRequest request){

		try {
	    	PlanDto planDto = new PlanDto();
	    	planDto.setPlan_title((request.getParameter("planTitle")));
	    	planDto.setPlan_content((request.getParameter("planContent")));
	    	planDto.setPlan_type((request.getParameter("planType")));
	    	planDto.setStart((request.getParameter("planStart")));
	    	planDto.setEnd((request.getParameter("planEnd")));
	    	planDto.setReg_user_id((request.getParameter("regUserId")));
	    	planService.planInsert(planDto);
		} catch (Exception e) {
			System.out.print(e);
		}
    }


}