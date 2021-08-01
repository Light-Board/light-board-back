package com.lb.lightboard.bo;

import com.lb.lightboard.controller.api.CrudInterface;
import com.lb.lightboard.model.entity.BoardFrame;
import com.lb.lightboard.model.network.Header;
import com.lb.lightboard.model.network.request.BoardFrameApiRequest;
import com.lb.lightboard.model.network.response.BoardFrameApiResponse;
import com.lb.lightboard.repository.BoardFrameRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class BoardFrameBO implements CrudInterface<BoardFrameApiRequest, BoardFrameApiResponse> {

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

	@Override
	public Header<BoardFrameApiResponse> create(Header<BoardFrameApiRequest> request) {

		// 1. request data 가져오기
		BoardFrameApiRequest boardFrameApiRequest = request.getData();

		// 2. boardFrame 생성 by client data
		BoardFrame boardFrame = BoardFrame.builder()
				.boardFrameId(boardFrameApiRequest.getBoardFrameId())
				.boardFrameName(boardFrameApiRequest.getBoardFrameName())
				.childBoardFrameId(boardFrameApiRequest.getChildBoardFrameId())
				.accessLevel(boardFrameApiRequest.getAccessLevel())
				.createdUserNo(boardFrameApiRequest.getCreatedUserNo())
				.createdAt(LocalDateTime.now())
				.updatedUserNo(boardFrameApiRequest.getUpdatedUserNo())
				.updatedAt(LocalDateTime.now())
				.build();

		BoardFrame newBoardFrame = boardFrameRepository.save(boardFrame);

		// 3. 생성된 데이터 -> boardFrameResponse return
		return response(newBoardFrame);
	}

	@Override
	public Header<BoardFrameApiResponse> read(Long id) {
		return null;
	}

	@Override
	public Header<BoardFrameApiResponse> update(Header<BoardFrameApiRequest> request) {
		return null;
	}

	@Override
	public Header<BoardFrameApiResponse> delete(Long id) {
		return null;
	}

	// return ApiResponse -> method response
	private Header<BoardFrameApiResponse> response(BoardFrame boardFrame) {

		// BoardFrame -> boardFrameApiResponse 만들어줘서 리턴하기
		BoardFrameApiResponse boardFrameApiResponse = BoardFrameApiResponse.builder()
				.boardFrameId(boardFrame.getBoardFrameId())
				.boardFrameName(boardFrame.getBoardFrameName())
				.childBoardFrameId(boardFrame.getChildBoardFrameId())
				.createdUserNo(boardFrame.getCreatedUserNo())
				.createdAt(boardFrame.getCreatedAt())
				.updatedUserNo(boardFrame.getUpdatedUserNo())
				.updatedAt(boardFrame.getUpdatedAt())
				.build();

		// Header + data -> return
		return Header.OK(boardFrameApiResponse);
	}
}