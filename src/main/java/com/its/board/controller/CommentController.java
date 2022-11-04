package com.its.board.controller;

import com.its.board.dto.BoardDTO;
import com.its.board.dto.CommentDTO;
import com.its.board.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping("/comment/save")
    public @ResponseBody List<CommentDTO> Save(@ModelAttribute CommentDTO commentDTO){

        commentService.save(commentDTO);
        List<CommentDTO> commentList = commentService.findAll(commentDTO.getBoardId());
        return commentList;
    }
}
