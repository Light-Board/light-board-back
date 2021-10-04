package com.lb.lightboard.controller.board;

import com.lb.lightboard.controller.CrudController;
import com.lb.lightboard.model.entity.BoardComment;
import com.lb.lightboard.model.network.request.BoardCommentApiRequest;
import com.lb.lightboard.model.network.response.BoardCommentApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/v1/api/board-comment", produces = MediaType.APPLICATION_JSON_VALUE)
public class BoardCommentController extends CrudController<BoardCommentApiRequest, BoardCommentApiResponse, BoardComment> {

}
