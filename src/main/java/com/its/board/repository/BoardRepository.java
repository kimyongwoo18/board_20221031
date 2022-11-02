package com.its.board.repository;

import com.its.board.dto.BoardDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardRepository {
    @Autowired
    SqlSessionTemplate sql;

    public void save(BoardDTO boardDTO) {
        sql.insert("board.save", boardDTO);

    }

    public List<BoardDTO> findAll() {
        return sql.selectList("board.findAll");
    }

    public BoardDTO findById(long id) {
        return sql.selectOne("board.findById", id);
    }

    public void updateHits(long id) {
        sql.update("board.updateHits",id);
    }

    public void update(BoardDTO boardDTO) {
        sql.update("board.update", boardDTO);
    }

    public void delete(Long id) {
        sql.delete("board.delete", id);
    }
}
