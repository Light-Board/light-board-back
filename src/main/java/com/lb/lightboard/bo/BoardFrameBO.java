package com.lb.lightboard.bo;

import com.lb.lightboard.model.BoardFrame;
import com.lb.lightboard.model.User;
import com.lb.lightboard.repository.BoardFrameRepository;
import com.lb.lightboard.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BoardFrameBO {
	@Autowired
	BoardFrameRepository boardFrameRepository;

	public String findAllBoardFrames() {
		List<BoardFrame> boardFrames = boardFrameRepository.findAll();
		log.debug("boardFrames : {}", boardFrames);

		// test line
		StringBuilder sb = new StringBuilder();
		for (BoardFrame resultBoardFrame:
			 boardFrames) {
			sb.append(resultBoardFrame);
		}
		return sb.toString();
	}
}