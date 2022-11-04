package com.its.board.repository;

import com.its.board.dto.BoardDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BoardRepository {
    @Autowired
    SqlSessionTemplate sql;

    public BoardDTO save(BoardDTO boardDTO) {
        System.out.println("insert 전 boardDTO = " + boardDTO);
        sql.insert("board.save", boardDTO);
        System.out.println("insert 후 boardDTO = " + boardDTO);
        return boardDTO;

    }

    public void saveFileName(BoardDTO boardDTO) {
        sql.insert("board.saveFile", boardDTO);
    }

    public List<BoardDTO> findAll() {
        return sql.selectList("board.findAll");
    }

    public BoardDTO findById(Long id) {

        BoardDTO boardDTO = sql.selectOne("board.findById", id);
        if (boardDTO.getFileAttached() == 1) {
            return sql.selectOne("board.findByIdFile", id);
        } else {
            return boardDTO;
        }
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

    public List<BoardDTO> pagingList(Map<String, Integer> pagingParams) {
        return sql.selectList("board.pagingList", pagingParams);
    }

    public int boardCount() {
        return sql.selectOne("board.boardCount");
    }

    public List<BoardDTO> search(Map<String, String> searchParams) {
        return sql.selectList("board.search", searchParams);
    }
}
