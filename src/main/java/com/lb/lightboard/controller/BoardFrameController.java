package com.lb.lightboard.controller;

import com.lb.lightboard.bo.BoardFrameBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/api/board_frame", produces = MediaType.APPLICATION_JSON_VALUE)
public class BoardFrameController {
	@Autowired
	BoardFrameBO boardFrameBO;

	@GetMapping()
	public String findAllBoardFrames() {
		StringBuilder sb = new StringBuilder();
		return boardFrameBO.findAllBoardFrames();
	}
}
