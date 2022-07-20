package com.example.demo.login.service;

import org.springframework.stereotype.Service;

import com.example.demo.login.dao.LoginMapper;
import com.example.demo.login.dto.UserDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final LoginMapper loginMapper;

	@Override
	public void joinAction(UserDto join) {
		loginMapper.joinAction(join);		
	}

	@Override
	public String selectPw(String id) {
		return loginMapper.selectPw(id);	
	}

	@Override
	public UserDto mypageInfo(String id) {
		return loginMapper.mypageInfo(id);
	}

	@Override
	public void myInfoUpdate(UserDto myInfo) {
		loginMapper.myInfoUpdate(myInfo);
	}

}