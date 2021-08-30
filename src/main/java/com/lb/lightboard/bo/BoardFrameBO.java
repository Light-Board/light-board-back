package com.lb.lightboard.bo;

import com.lb.lightboard.model.entity.BoardFrame;
import com.lb.lightboard.model.network.Header;
import com.lb.lightboard.model.network.Pagination;
import com.lb.lightboard.model.network.request.BoardFrameApiRequest;
import com.lb.lightboard.model.network.response.BoardFrameApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BoardFrameBO extends BaseBO<BoardFrameApiRequest, BoardFrameApiResponse, BoardFrame> {

//	@Autowired
//	BoardFrameRepository boardFrameRepository;

	@Override
	public Header<BoardFrameApiResponse> create(Header<BoardFrameApiRequest> request) {

		// 1. request data 가져오기
		BoardFrameApiRequest boardFrameApiRequest = request.getData();

		log.info("{}", boardFrameApiRequest.toString());

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

		BoardFrame newBoardFrame = baseRepository.save(boardFrame);

		// 3. 생성된 데이터 -> boardFrameResponse return
		return response(newBoardFrame, "201", "Success: created one board-frame");
	}

	@Override
	public Header<BoardFrameApiResponse> read(Long id) {

		/*
        // 1. id -> repository getOne or getById
        Optional<BoardFrame> optional = boardFrameRepository.findById(id);

        // 2. BoardFrame -> boardFrameApiResponse return
        return optional
                .map(boardFrame -> response(boardFrame))
                .orElseGet(() -> Header.ERROR("There is no any data")); // 유저가 없다면! 일로온다!
        */

		// 위 코드를 람다식으로 더 편하게 바꿀 수 있다.
		return baseRepository.findById(id)
//				.map(boardFrame -> response(boardFrame))
				.map(boardFrame -> response(boardFrame, "200", "Success: get one board-frame row finding by id"))
				.orElseGet(
						() -> Header.ERROR("There is no any data")
				);
	}

	@Override
	public Header<List<BoardFrameApiResponse>> search(Pageable pageable) {
		Page<BoardFrame> boardFrames = this.baseRepository.findAll(pageable);

		List<BoardFrameApiResponse> boardFrameApiResponseList = boardFrames.stream()
				.map(boardFrame -> response(boardFrame).getData())
				.collect(Collectors.toList());

		// pagination 부분 이용하기!
		Pagination pagination = Pagination.builder()
				.totalPages(boardFrames.getTotalPages())
				.totalElements(boardFrames.getTotalElements())
				.currentPage(boardFrames.getNumber())
				.currentElements(boardFrames.getNumberOfElements())
				.build();

		return Header.OK(boardFrameApiResponseList, "200", "description", pagination);

		// List<UserApiResponse> 로 이뤄져 있음 -> Header붙여줘야함!
		// return Header.OK(userApiResponseList);
	}

	@Override
	public Header<BoardFrameApiResponse> update(Header<BoardFrameApiRequest> request) {
		return null;
	}

	@Override
	public Header<BoardFrameApiResponse> delete(Long id) {
		return null;
	}

	private Header<BoardFrameApiResponse> response(BoardFrame boardFrame) {

		// BoardFrame -> boardFrameApiResponse 만들어줘서 리턴하기
		BoardFrameApiResponse resBody = BoardFrameApiResponse.builder()
				.boardFrameId(boardFrame.getBoardFrameId())
				.boardFrameName(boardFrame.getBoardFrameName())
				.childBoardFrameId(boardFrame.getChildBoardFrameId())
				.createdUserNo(boardFrame.getCreatedUserNo())
				.createdAt(boardFrame.getCreatedAt())
				.updatedUserNo(boardFrame.getUpdatedUserNo())
				.updatedAt(boardFrame.getUpdatedAt())
				.build();

		// Header + data -> return
		return Header.OK(resBody);
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