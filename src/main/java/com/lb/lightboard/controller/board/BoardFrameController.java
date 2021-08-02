package com.lb.lightboard.controller.board;

import com.lb.lightboard.bo.BoardFrameBO;
import com.lb.lightboard.controller.CrudInterface;
import com.lb.lightboard.model.network.Header;
import com.lb.lightboard.model.network.request.BoardFrameApiRequest;
import com.lb.lightboard.model.network.response.BoardFrameApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/v1/api/board-frame", produces = MediaType.APPLICATION_JSON_VALUE)
public class BoardFrameController implements CrudInterface<BoardFrameApiRequest, BoardFrameApiResponse> {
	@Autowired
	BoardFrameBO boardFrameBO;

	@Override
	@PostMapping("")
	public Header<BoardFrameApiResponse> create(@RequestBody Header<BoardFrameApiRequest> request) {
		log.info("{}", request); // Lombok 제공
		return boardFrameBO.create(request);
	}

	@Override
	@GetMapping("{board-frame-id}")
	public Header<BoardFrameApiResponse> findById(@PathVariable(name = "board-frame-id") Long id) {
		log.info("read id: {}", id);
		return boardFrameBO.findById(id);
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

//	@PostMapping(method = RequestMethod.POST, path = "/postMethod")
//	public
}
