package com.example.demo.login.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.login.dto.UserDto;
import com.example.demo.login.service.LoginService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class LoginController {
	private final LoginService loginService;
    private final PasswordEncoder passwordEncoder;
    
//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody UserDto dto) {
//    	return ResponseEntity.ok().body(loginService.login(dto.getUser_id(), ""));
//    }
//    
    @PostMapping("/reviews")
    public ResponseEntity<String> reviews(Authentication authentication) {
    	return ResponseEntity.ok().body(authentication.getName() + "님의 리뷰 등록이 완료되었습니다.");
    }
    
    
    // 로그인
//    @RequestMapping(method = RequestMethod.POST, value = "/login")
//    public ResponseEntity<UserDto> login(@RequestBody UserDto dto){
//
//    	UserDto login = new UserDto();
//    	try {
//        	String dbPw = loginService.selectPw(dto.getUser_id());
//        	if(passwordEncoder.matches(dto.getUser_pw(), dbPw)) {
//        		login = loginService.mypageInfo(dto.getUser_id());
//        		login.setLogin_tf(true);
//        		login.setMessage("로그인 되었습니다.");
//            	loginService.login(dto.getUser_id(), dto.getUser_pw());
//        	} else {
//        		login.setMessage("아이디 혹은 비밀번호가 틀렸습니다.");
//        	}
//    	}
//    	catch (Exception e) {
//    		System.out.println(e);
//		} 
//    	return ResponseEntity.ok().body(login);
//    }
    
    // 로그인
    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public ResponseEntity<String> login(@RequestParam String user_id, @RequestParam String user_pw){

    	String jwtToken = "";
    	try {
        	String dbPw = loginService.selectPw(user_id);
        	if(passwordEncoder.matches(user_pw, dbPw)) {
        		jwtToken = loginService.login(user_id, user_pw);
        	}
    	}
    	catch (Exception e) {
    		System.err.println(e);
		}
    	System.out.println(jwtToken);
    	return ResponseEntity.ok().body(jwtToken);
    }
    
    
    // 회원가입
    @RequestMapping(method = RequestMethod.POST, value = "/join")
    public void join(@RequestParam String user_id, @RequestParam String user_pw){
    	UserDto join = new UserDto();
    	join.setUser_id(user_id);
    	join.setUser_pw(passwordEncoder.encode(user_pw));
    	loginService.joinAction(join);
    }
    
    // 개인정보 조회
    @RequestMapping(method = RequestMethod.GET, value = "/mypage")
    public UserDto myInfo(@RequestParam String user_id) {
    	UserDto myInfo = new UserDto();
    	myInfo = loginService.mypageInfo(user_id);
    	return myInfo;
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/mypage")
    public void myInfoUpdate(@RequestParam String id, @RequestParam String birth, @RequestParam String name, @RequestParam String pw){
    	UserDto myInfo = new UserDto();
    	myInfo.setUser_id(id);
    	myInfo.setUser_name(name);
    	myInfo.setUser_birth(birth);
    	myInfo.setUser_pw(passwordEncoder.encode(pw));
    	loginService.myInfoUpdate(myInfo);
    }
    
}