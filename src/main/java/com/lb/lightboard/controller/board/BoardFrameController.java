package com.lb.lightboard.controller.board;

import com.lb.lightboard.bo.BoardFrameBO;
import com.lb.lightboard.controller.CrudController;
import com.lb.lightboard.controller.CrudInterface;
import com.lb.lightboard.model.entity.BoardFrame;
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
public class BoardFrameController extends CrudController<BoardFrameApiRequest, BoardFrameApiResponse, BoardFrame> {
	// CRUD 는 모두 추상화 시켜서 깔-끔
}
