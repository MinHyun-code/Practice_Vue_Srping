package com.example.demo.login.service;

import com.example.demo.login.dto.UserDto;

public interface LoginService {
	void joinAction(UserDto join);
	String selectPw(String id);
	UserDto mypageInfo(String id);
	void myInfoUpdate(UserDto myInfo);
}