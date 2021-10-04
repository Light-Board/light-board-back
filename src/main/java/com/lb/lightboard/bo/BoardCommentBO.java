package com.lb.lightboard.bo;

import com.lb.lightboard.model.entity.BoardComment;
import com.lb.lightboard.model.network.Header;
import com.lb.lightboard.model.network.Pagination;
import com.lb.lightboard.model.network.request.BoardCommentApiRequest;
import com.lb.lightboard.model.network.response.BoardCommentApiResponse;
import com.lb.lightboard.model.network.status.ApiResponseStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BoardCommentBO extends BaseBO<BoardCommentApiRequest, BoardCommentApiResponse, BoardComment> {
	
	@Transactional
	@Override
	public Header<BoardCommentApiResponse> create(Header<BoardCommentApiRequest> request) {
		BoardCommentApiRequest boardCommentApiRequest = request.getData();
		
		BoardComment boardComment = new BoardComment(boardCommentApiRequest);
		BoardComment newBoardComment = baseRepository.save(boardComment);
		
		log.info("[Create BoardComment] BoardComment : {}", newBoardComment);
		
		return new Header<>(new BoardCommentApiResponse(newBoardComment), ApiResponseStatus.CREATE_DATA, "BoardComment");
	}
	
	@Override
	public Header<BoardCommentApiResponse> read(long id) {
		Optional<BoardComment> optional = baseRepository.findById(id);
		return optional.map(boardComment -> {
			log.info("[Read BoardComment] BoardComment : {}", boardComment);
			return boardComment;
		})
				.map(boardComment -> new Header<>(new BoardCommentApiResponse(boardComment), ApiResponseStatus.READ_DATA, "BoardComment"))
				.orElseGet(() -> Header.ERROR("There is no any data for id [BoardComment]"));
	}
	
	@Override
	public Header<List<BoardCommentApiResponse>> search(Pageable pageable) {

		Page<BoardComment> boardComments = this.baseRepository.findAll(pageable);

		List<BoardCommentApiResponse> boardCommentApiResponseList = boardComments.stream()
				.map(boardCommentResponse -> new BoardCommentApiResponse(boardCommentResponse))
				.collect(Collectors.toList());

		// pagination 부분 이용
		Pagination pagination = new Pagination(boardComments);

		// return header setting
		Header<List<BoardCommentApiResponse>> returnHeader = new Header<>(boardCommentApiResponseList, ApiResponseStatus.SEARCH_DATA, "BoardComment");
		returnHeader.setPagination(pagination);

		return returnHeader;

	}

	@Override
	public Header<BoardCommentApiResponse> update(Header<BoardCommentApiRequest> request) {

		// 1. request data 가져오기
		BoardCommentApiRequest boardCommentApiRequest = request.getData();

		// 2. id -> user data find
		Optional<BoardComment> optional = baseRepository.findById(boardCommentApiRequest.getBoardId());

		return optional.map(boardComment -> {

			// 3. if not null -> update
			baseRepository.save(boardComment);
			log.info("[Update BoardComment] BoardComment : {}", boardComment);

			return boardComment;
		})
				.map(boardComment -> baseRepository.save(boardComment)) // 실제 업데이트 일어난 곳
				.map(boardComment -> new Header<>(new BoardCommentApiResponse(boardComment), ApiResponseStatus.UPDATE_DATA, "BoardComment"))
				.orElseGet(() -> Header.ERROR("There is no any data for id [BoardComment]"));
	}
	
	@Override
	public Header<BoardCommentApiResponse> delete(long id) {
		// 1. id -> repository -> user
		Optional<BoardComment> optional = baseRepository.findById(id);

		// 2. repo -> delete
		return optional.map(boardComment -> {
			log.info("[Delete BoardComment] BoardComment : {}", boardComment);
			baseRepository.delete(boardComment);
			return new Header<>(new BoardCommentApiResponse(boardComment), ApiResponseStatus.DELETE_DATA, "BoardComment");
		})
				.orElseGet(() -> Header.ERROR("There is no any data for id [BoardComment]"));
	}
}
