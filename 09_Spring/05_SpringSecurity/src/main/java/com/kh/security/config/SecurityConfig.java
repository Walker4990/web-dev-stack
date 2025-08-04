package com.kh.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	// 하나의 필터 역할
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// 검색할 때 Spring버전 확인
		return http
				.csrf(csrf -> csrf.disable()) // 웹 보안 토큰 설정(비활성화)
				.authorizeHttpRequests(authorize -> authorize
						.requestMatchers("/myPage").authenticated() // authenticated() -> 로그인된 사용자만
						.requestMatchers("/admin").hasRole("ADMIN")
						.anyRequest().permitAll())
						 // -> 어떤 요청이든 전부 수락
				.formLogin(form -> form.loginPage("/login")
						.defaultSuccessUrl("/myPage")
						
				)
				.logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/")
				)
				
				.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
