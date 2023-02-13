package com.example.demo.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.example.demo.login.controller.JwtUtil;
import com.example.demo.login.dao.LoginMapper;
import com.example.demo.login.dto.UserDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final LoginMapper loginMapper;

    @Autowired
    @Value("${jwt.secret}")
    private String secretKey;
    
    private Long expiredMs = 1000 * 60 * 60l;
    
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
	
	@Override
	public String login(String user_id, String password) {
		return JwtUtil.createJwt(user_id, secretKey, expiredMs);
	}

}