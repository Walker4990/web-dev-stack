package com.kh.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

	// 하나의 필터 역할
	@Autowired
	private JwtAuthenticationFilter jwtFilter;
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// 검색할 때 Spring버전 확인
		return http
				.csrf(csrf -> csrf.disable()) // 웹 보안 토큰 설정(비활성화)
				.httpBasic(basic -> basic.disable()) // HTTP Basic 인증 방식 비활성화 -> JWT 토큰 방식 사용
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))// 세션 설정 -> STATELESS 무상태 방식으로 설정
				// ==> 서버에 사용자 상태를 기억을 못함.
				
				.authorizeHttpRequests(authorize -> authorize
						.requestMatchers("/myPage").authenticated() // authenticated() -> 로그인된 사용자만
						.requestMatchers("/admin").hasRole("ADMIN")
						.anyRequest().permitAll()
						 // -> 어떤 요청이든 전부 수락
				).addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
				.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
