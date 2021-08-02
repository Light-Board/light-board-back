package com.lb.lightboard.bo;

import com.lb.lightboard.controller.CrudInterface;
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
import java.util.Optional;

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
		return response(newBoardFrame, "201", "Success: created one board-frame");
	}

	@Override
	public Header<BoardFrameApiResponse> findById(Long id) {

		/*
        // 1. id -> repository getOne or getById
        Optional<BoardFrame> optional = boardFrameRepository.findById(id);

        // 2. BoardFrame -> boardFrameApiResponse return
        return optional
                .map(boardFrame -> response(boardFrame))
                .orElseGet(() -> Header.ERROR("There is no any data")); // 유저가 없다면! 일로온다!
        */

		// 위 코드를 람다식으로 더 편하게 바꿀 수 있다.
		return boardFrameRepository.findById(id)
				.map(boardFrame -> response(boardFrame, "200", "Success: get one board-frame row finding by id"))
				.orElseGet(
						() -> Header.ERROR("There is no any data")
				);
	}

	@Override
	public Header<BoardFrameApiResponse> findAll() {
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
	private Header<BoardFrameApiResponse> response(BoardFrame boardFrame, String resultCode, String description) {

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
		return Header.OK(boardFrameApiResponse, resultCode, description);
	}
}