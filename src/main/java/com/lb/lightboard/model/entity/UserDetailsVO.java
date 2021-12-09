package com.lb.lightboard.model.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserDetailsVO implements UserDetails {

	private final User user;
	private final Collection<? extends GrantedAuthority> authorities;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUserId();
	}

	@Override
	public boolean isAccountNonExpired() {
		return user.getUserStatusType().isActivate();
	}

	@Override
	public boolean isAccountNonLocked() {
		return user.getUserStatusType().isActivate();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return user.getUserStatusType().isActivate();
	}

	@Override
	public boolean isEnabled() {
		return user.getUserStatusType().isActivate();
	}
}
