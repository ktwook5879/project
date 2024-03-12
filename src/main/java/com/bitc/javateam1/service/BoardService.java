package com.bitc.javateam1.service;

import com.bitc.javateam1.dto.BoardDTO;
import com.github.pagehelper.Page;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

public interface BoardService {

    Page<BoardDTO> selectPageList(int pageNum)throws Exception;
    BoardDTO selectBoardDetail(int cmIdx)throws Exception;

    void deleteBoard(int cmIdx)throws Exception;



    void insertBoard(BoardDTO board, MultipartHttpServletRequest multipart)throws Exception;

    Page<BoardDTO> mateList(int pageNum) throws Exception;

    void updatePost(BoardDTO board)throws Exception;

    void updatePostImg(BoardDTO board, MultipartHttpServletRequest multipart)throws Exception;

    void MemberDelImg(String cmNick)throws Exception;

    void MemberDelComm(String cmNick)throws Exception;
}
