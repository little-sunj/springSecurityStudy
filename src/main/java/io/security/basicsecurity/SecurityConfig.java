package io.security.basicsecurity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Configuration
@EnableWebSecurity //웹 보안 활성화 : 여러 보안설정 클래스를 import하는 어노테이션
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
				.authorizeRequests()
				.anyRequest().authenticated();
		http
				.formLogin();					
//				.loginPage("/loginPage") 								//사용자 정의 로그인 페이지
//				.defaultSuccessUrl("/")									//로그인 성공 후 이동 페이지
//				.failureUrl("/login")									//로그인 실패 후 이동 페이지
//				.usernameParameter("userId")							//아이디 파라미터명 설정
//				.passwordParameter("passwd")							//패스워드 파라미터명 설정
//				.loginProcessingUrl("/login_proc")						//로그인 Form Action Url
//				.successHandler(new AuthenticationSuccessHandler() {	//로그인 성공 후 핸들러
//					@Override
//					public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//							Authentication authentication) throws IOException, ServletException {
//						System.out.println("authentication --" + authentication.getName());
//						response.sendRedirect("/");
//					}
//				})
//				.failureHandler(new AuthenticationFailureHandler() {	//로그인 실패 후 핸들러
//					@Override
//					public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
//							AuthenticationException exception) throws IOException, ServletException {
//						System.out.println("exception --"+exception.getMessage());
//						response.sendRedirect("/login");
//					}
//				})
//				.permitAll() //loginPage는 인증하지 않아도 접근이 가능해야함
	
		http
//				.logout()						//로그아웃처리
//				.logoutUrl("/logout")			//로그아웃 처리 URL
//				.logoutSuccessUrl("/login")		//로그아웃 성공 후 이동페이지
//				.deleteCookies("remember-me")	//로그아웃 후 쿠키 삭제
//				.addLogoutHandler(new LogoutHandler() {		//로그아웃 핸들러
//					
//					@Override
//					public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
//						HttpSession session = request.getSession();
//						session.invalidate();
//					}
//				})
//				.logoutSuccessHandler(new LogoutSuccessHandler() {	//로그아웃 성공 후 핸들러
//					
//					@Override
//					public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
//							throws IOException, ServletException {
//						response.sendRedirect("/login");
//					}
//				})
//			.and()
				.rememberMe()
//				.rememberMeParameter("remember")	//기본 파라미터명 remember-me
//				.tokenValiditySeconds(3600)			//default는 14일
//				.alwaysRemember(true)				//remember me 기능이 활성화되지 않아도 항상 실행
				.userDetailsService(userDetailsService)
				
				;
		
				
				
	}

}
