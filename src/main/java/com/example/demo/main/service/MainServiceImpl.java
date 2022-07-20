package com.example.demo.main.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.main.dao.MainMapper;
import com.example.demo.main.dto.MainDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MainServiceImpl implements MainSerivce {
    private final MainMapper mainMapper;

	@Override
	public List<MainDto> menuList() {
		return mainMapper.menuList();
	}

}