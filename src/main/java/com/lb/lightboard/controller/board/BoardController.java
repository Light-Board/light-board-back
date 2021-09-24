package com.lb.lightboard.controller.board;

import com.lb.lightboard.controller.CrudController;
import com.lb.lightboard.model.entity.Board;
import com.lb.lightboard.model.network.request.BoardApiRequest;
import com.lb.lightboard.model.network.response.BoardApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/v1/api/board", produces = MediaType.APPLICATION_JSON_VALUE)
public class BoardController extends CrudController<BoardApiRequest, BoardApiResponse, Board> {

}
