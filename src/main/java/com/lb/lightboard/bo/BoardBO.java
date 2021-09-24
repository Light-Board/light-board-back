package com.lb.lightboard.bo;

import com.lb.lightboard.model.entity.Board;
import com.lb.lightboard.model.network.Header;
import com.lb.lightboard.model.network.request.BoardApiRequest;
import com.lb.lightboard.model.network.response.BoardApiResponse;
import com.lb.lightboard.model.network.status.ApiResponseStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BoardBO extends BaseBO<BoardApiRequest, BoardApiResponse, Board> {
	
	@Transactional
	@Override
	public Header<BoardApiResponse> create(Header<BoardApiRequest> request) {
		BoardApiRequest boardApiRequest = request.getData();
		
		Board board = new Board(boardApiRequest);
		Board newBoard = baseRepository.save(board);
		
		log.info("[Create Board] Board : {}", newBoard);
		
		return new Header<>(new BoardApiResponse(newBoard), ApiResponseStatus.CREATE_DATA, "Board");
	}
	
	@Override
	public Header<BoardApiResponse> read(long id) {
		Optional<Board> optional = baseRepository.findById(id);
		return optional.map(board -> {
			log.info("[Update Board] Board : {}", board);
			return board;
		})
				.map(board -> new Header<>(new BoardApiResponse(board), ApiResponseStatus.UPDATE_DATA, "Board"))
				.orElseGet(() -> Header.ERROR("There is no any data for id"));
	}
	
	@Override
	public Header<List<BoardApiResponse>> search(Pageable pageable) {
		return null;
	}

	@Override
	public Header<BoardApiResponse> update(Header<BoardApiRequest> request) {

		// 1. request data 가져오기
		BoardApiRequest boardApiRequest = request.getData();

		// 2. id -> user data find
		Optional<Board> optional = baseRepository.findById(boardApiRequest.getBoardId());

		return optional.map(board -> {

			// 3. if not null -> update
			baseRepository.save(board);
			log.info("[Update Board] Board : {}", board);

			return board;
		})
				.map(board -> baseRepository.save(board)) // 실제 업데이트 일어난 곳
				.map(board -> new Header<>(new BoardApiResponse(board), ApiResponseStatus.UPDATE_DATA, "Board"))
				.orElseGet(() -> Header.ERROR("There is no any data for id"));
	}
	
	@Override
	public Header<BoardApiResponse> delete(long id) {
		// 1. id -> repository -> user
		Optional<Board> optional = baseRepository.findById(id);

		// 2. repo -> delete
		return optional.map(board -> {
			log.info("[Delete Board] Board : {}", board);
			baseRepository.delete(board);
			return new Header<>(new BoardApiResponse(board), ApiResponseStatus.DELETE_DATA, "Board");
		})
				.orElseGet(() -> Header.ERROR("There is no any data for id"));
	}
}
