package com.its.board.controller;

import com.its.board.dto.BoardDTO;
import com.its.board.dto.CommentDTO;
import com.its.board.dto.PageDTO;
import com.its.board.service.BoardService;
import com.its.board.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
//@RequestMapping("/board")
//   /board  /member  /comment  등등 컨트롤러의 대표주소를 넣고 그 이하는 /save /update /delete 같이 공동된 이름을 갖는 주소를 넣는다.
public class BoardController {
    @Autowired
    private BoardService boardService;
    @Autowired
    private CommentService commentService;
    @GetMapping("/board/save")
    public String saveForm(){

        return "boardPages/boardSave";
    }
    @PostMapping("/board/save")
    public String save(@ModelAttribute BoardDTO boardDTO, Model model) throws IOException {
       boardService.save(boardDTO);
        return "redirect:/board/";
    }
    @GetMapping("/board/")
    public String findAll(Model model){
        List<BoardDTO> boardList = boardService.findAll();
        model.addAttribute("boardList", boardList);

        return "boardPages/boardList";
    }
    //페이징 목록
    @GetMapping("/board/paging")
    public String paging(Model model,
                         @RequestParam(value= "page", required = false, defaultValue = "1") int page){
//                                       파라미터 이름은 page 필수정보는 아니고 기본값은 1이다.

        //해당 페이지에서 보여줄 글 목록
        List<BoardDTO> pagingList = boardService.pagingList(page);
        // 하단 페이지 번호 표현을 위한 데이터
        PageDTO pageDTO = boardService.pagingParam(page);
        model.addAttribute("boardList", pagingList);
        model.addAttribute("paging", pageDTO);
        return"boardPages/boardPaging";
    }
    @GetMapping("/board")
    public String findById(@RequestParam("id") long id, Model model,
                           @RequestParam(value= "page", required = false, defaultValue = "1") int page){
        //조회수 증가
                    boardService.updateHits(id);
        //상세내용 가져오기
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);
        model.addAttribute("page",page);
        System.out.println("조회 : boardDTO = " + boardDTO);
        List<CommentDTO> commentDTOList = commentService.findAll(id);
        model.addAttribute("commentList", commentDTOList);
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

    @GetMapping("/board/search")
    public String search(@RequestParam("q") String q,
                         @RequestParam("type") String type, Model model){

        List<BoardDTO> searchList = boardService.search(type,q);
        model.addAttribute("boardList", searchList);

        return "boardPages/boardList";
    }
}