package com.example.demo.main.controller;


import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.main.dto.MainDto;
import com.example.demo.main.service.MainServiceImpl;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class MainController {
	private final MainServiceImpl mainSerivce;

	// 게시판 조회
	@RequestMapping(method = RequestMethod.GET, value = "/api/menuList")
    public List<MainDto> menuList(){
    	List<MainDto> menuList = mainSerivce.menuList();
        return menuList;
    }
}