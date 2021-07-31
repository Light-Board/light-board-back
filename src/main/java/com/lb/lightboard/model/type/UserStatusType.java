package com.lb.lightboard.model.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserStatusType {
	NORMAL("N"),
	ADMIN("A");
	
	String dbCode;
	
	public static UserStatusType find(String dbCode) {
		for (UserStatusType value : UserStatusType.values()) {
			if (value.getDbCode().equals(dbCode)) {
				return  value;
			}
		}
		return null;
	}
}
