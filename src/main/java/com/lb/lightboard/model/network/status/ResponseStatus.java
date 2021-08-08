package com.lb.lightboard.model.network.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum ResponseStatus {
	BOOLEAN_SUCCESS("200", "get boolean value");
	
	String result;
	String description;
	
	@AllArgsConstructor
	@Getter
	public enum BoardFrame {
		SUCCESS("200", "get one board-frame row finding by id");
		
		String result;
		String description;
	}
}
