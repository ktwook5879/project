package com.bitc.javateam1.controller;

import com.bitc.javateam1.Utils.JSFunction;
import com.bitc.javateam1.dto.BoardDTO;
import com.bitc.javateam1.dto.ParkDTO;
import com.bitc.javateam1.service.BoardService;
import com.bitc.javateam1.service.ReviewService;
import com.github.pagehelper.PageInfo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class BoardController {

    @Autowired
    private BoardService boardService;
    @Autowired
    private ReviewService reviewService;

    //글 목록
    @GetMapping("board")
    public ModelAndView selectBoardPagingList(@RequestParam(required = false, defaultValue = "1", value = "pageNum") int pageNum) throws Exception {
        ModelAndView mv = new ModelAndView("board/shotboard/shotBoardList");

        PageInfo<BoardDTO> PageList = new PageInfo<>(boardService.selectPageList(pageNum), 5);

        mv.addObject("PageList", PageList);

        return mv;
    }

    //글 상세
    @GetMapping("board/{cmIdx}")
    public ModelAndView boardDetail(@PathVariable("cmIdx") int cmIdx) throws Exception {
        ModelAndView mv = new ModelAndView("board/shotboard/shotBoardDetail");

        BoardDTO board = boardService.selectBoardDetail(cmIdx);
        mv.addObject("board", board);

        return mv;
    }


    //메이트게시판 목록
    @GetMapping("mate")
    public ModelAndView selectMatePagingList(@RequestParam(required = false, defaultValue = "1", value = "pageNum") int pageNum) throws Exception {
        ModelAndView mv = new ModelAndView("board/mateBoard/mateBoardList");

        PageInfo<BoardDTO> PageList = new PageInfo<>(boardService.mateList(pageNum), 5);

        mv.addObject("PageList", PageList);

        return mv;
    }

    //글 입력 폼
    @GetMapping("board/insert")
    public String boardInsertView() throws Exception {
        return "board/shotboard/shotBoardInsert";
    }

    //글 입력
    @PostMapping("board/insert")
    public String boardInsertProcess(BoardDTO board,  MultipartHttpServletRequest multipart) throws Exception {

        boardService.insertBoard(board, multipart);
       int result = board.getCmNum();
       if(result==0) {
           return "redirect:/board";
       }else{
           return "redirect:/mate";
       }
       }

    //글 수정 폼
    @GetMapping("board/update/{cmIdx}")
    public ModelAndView selectBoardUpdate(@PathVariable("cmIdx") int cmIdx) throws Exception {
        ModelAndView mv = new ModelAndView("board/shotboard/shotBoardUpdate");

        BoardDTO board = boardService.selectBoardDetail(cmIdx);
        mv.addObject("board", board);

        return mv;
    }

    @PostMapping("board/update")
    public void boardUpdateProcess(BoardDTO board, HttpServletRequest req, HttpServletResponse res) throws Exception {



                if(board.getCmNum()==0) {
                    boardService.updatePost(board);
                    JSFunction.alertLocation("게시글 수정이 완료되었습니다","/board",res);
                }else{
                    boardService.updatePost(board);
                    JSFunction.alertLocation("게시글 수정이 완료되었습니다","/mate",res);

        }


    }

    @PostMapping("/board/image/update")
    public void boardImageUpdateProcess(BoardDTO board, MultipartHttpServletRequest multipart, HttpServletRequest req, HttpServletResponse res) throws Exception {



        if(board.getCmNum()==0) {

            boardService.updatePostImg(board,multipart);
            JSFunction.alertLocation("게시글 수정이 완료되었습니다","/board",res);
        }else{
            boardService.updatePostImg(board,multipart);
            JSFunction.alertLocation("게시글 수정이 완료되었습니다","/mate",res);

        }


    }

    //게시글 삭제
    @RequestMapping("/board/deleteBoard.do")
    public String deleteBoard(@RequestParam("cmIdx") int cmIdx) throws Exception {
        reviewService.DeleteallBoard(cmIdx);

        boardService.deleteBoard(cmIdx);

        return "redirect:/board";
    }

    //  관리자 게시글 삭제하기
    @GetMapping("board/deleteBoard/{cmIdx}")
    public void AdCommDel(@PathVariable("cmIdx") int cmIdx,HttpServletRequest req, HttpServletResponse res) throws Exception {
        reviewService.DeleteallBoard(cmIdx);

        boardService.deleteBoard(cmIdx);


        JSFunction.alertLocation("삭제가 완료되었습니다","/admin", res);
    }


}
