package com.its.board.controller;

import com.its.board.dto.BoardDTO;
import com.its.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/board")
//   /board  /member  /comment  등등 컨트롤러의 대표주소를 넣고 그 이하는 /save /update /delete 같이 공동된 이름을 갖는 주소를 넣는다.
public class BoardController {
@Autowired
    BoardService boardService;
    @GetMapping("/board/save")
    public String saveForm(){

        return "boardPages/boardSave";
    }
    @PostMapping("/board/save")
    public String save(@ModelAttribute BoardDTO boardDTO, Model model){
       boardService.save(boardDTO);


        return "redirect:/board/";
    }
    @GetMapping("/board/")
    public String findAll(Model model){
        List<BoardDTO> boardList = boardService.findAll();
        model.addAttribute("boardList", boardList);

        return "boardPages/boardList";
    }
    @GetMapping("/board")
    public String findById(@RequestParam("id") long id, Model model){
        //조회수 증가
                    boardService.updateHits(id);
        //상세내용 가져오기
        BoardDTO boardDTO = boardService.findById(id);

        model.addAttribute("board", boardDTO);

        return "boardPages/boardDetail";
    }

    @GetMapping("/board/update")
    public String updateForm(@RequestParam("id") long id, Model model){
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);

        return "boardPages/boardUpdate";
    }
    @PostMapping("/board/update")
    public String update(@ModelAttribute BoardDTO boardDTO, Model model) {
        boardService.update(boardDTO);
        BoardDTO dto = boardService.findById(boardDTO.getId());
        model.addAttribute("board", dto);


        return "boardPages/boardDetail";
    }

    @GetMapping("/board/delete")
    public String deleteForm(@RequestParam("id") long id, Model model){
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);


      return "/boardPages/boardDelete";
    }
    @PostMapping("/board/delete")
    public String delete(@RequestParam("id") Long id){

            boardService.delete(id);

            return "redirect:/board/";
        }


}
