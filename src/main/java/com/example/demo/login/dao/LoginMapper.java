package com.example.demo.login.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.login.dto.UserDto;

@Repository
@Mapper
public interface LoginMapper {
	void joinAction(UserDto join);
	String selectPw(String id);
	UserDto mypageInfo(String id);
	void myInfoUpdate(UserDto myInfo);
}