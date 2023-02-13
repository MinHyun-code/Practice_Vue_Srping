package com.example.demo.login.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.login.service.LoginService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class JwtFilter extends OncePerRequestFilter {

	private final LoginService loginService;
	private final String secretKey;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
		log.info("authorization : {}", authorization);
		
		// 토큰 안보내면 Block
		if(authorization == null) {
			log.error("authentication이 없습니다.");
			filterChain.doFilter(request, response);
			return;
		} else if(!authorization.startsWith("Bearer ")) {
			log.error("authentication을 잘못 보냈습니다.");
			filterChain.doFilter(request, response);
			return;
		}
		
		// Token 꺼내기
		String token = authorization.split(" ")[1];
		
		// Token Expired 되었는지 여부
		if(JwtUtil.isExpired(token, secretKey)) {
			log.error("Token이 만료되었습니다.");
			filterChain.doFilter(request, response);
			return;
		}
		
		//UserName Token에서 꺼내기
		String user_id =  JwtUtil.getUserId(token, secretKey);
		log.info("user_id: {}", user_id);
		
		//권한 부여
		UsernamePasswordAuthenticationToken authenticationToken = 
				new UsernamePasswordAuthenticationToken(user_id, null, List.of(new SimpleGrantedAuthority("USER")));
		
		authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		filterChain.doFilter(request, response);
		
		
	}


}
