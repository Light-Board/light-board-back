package com.lb.lightboard.provider;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.lb.lightboard.model.entity.UserDetailsVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

	private final UserDetailsService userDetailsService;
	private final BCryptPasswordEncoder passwordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication; // AuthenticaionFilter에서 생성된 토큰으로부터 아이디와 비밀번호를 조회함 String userEmail = token.getName();

		String userId = token.getName();
		String password = (String) token.getCredentials();

		UserDetailsVO userDetailsVO = (UserDetailsVO) userDetailsService.loadUserByUsername(userId);

		if (!passwordEncoder.matches(password, userDetailsVO.getPassword())) {
			throw new BadCredentialsException(userDetailsVO.getUsername() + "Invalid password");
		}

		return new UsernamePasswordAuthenticationToken(userDetailsVO, password, userDetailsVO.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
