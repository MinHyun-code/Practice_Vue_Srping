package com.example.demo.main.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.main.dto.MainDto;

@Repository
@Mapper
public interface MainMapper {
	List<MainDto> menuList();
}