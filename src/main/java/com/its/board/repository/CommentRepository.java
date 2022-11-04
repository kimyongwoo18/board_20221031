package com.its.board.repository;

import com.its.board.dto.CommentDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentRepository {
    @Autowired

    private SqlSessionTemplate sql;

    public void save(CommentDTO commentDTO) {
        sql.selectList("comment.save", commentDTO);
    }

    public List<CommentDTO> findAll(Long boardId) {
        return sql.selectList("comment.findAll", boardId);
    }
}
