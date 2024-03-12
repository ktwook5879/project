package com.bitc.javateam1.mapper;

import com.bitc.javateam1.dto.BoardDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {
    //public List<BoardDTO> selectBoardList() throws Exception;

    BoardDTO selectBoardDetail(int cmIdx)throws Exception;

    void insertBoard(BoardDTO board)throws Exception;



    void deleteBoard(int cmIdx)throws Exception;

    Page<BoardDTO> selectPageList()throws Exception;

    Page<BoardDTO> postList(int pageNum, String cmId)throws Exception;

    public void insertBoardFileList(List<BoardDTO> fileList) throws Exception;

    public void updateHitCount(@Param("cmIdx") int cmIdx) throws Exception;

    Page<BoardDTO> mateList() throws Exception;

    void updatePost(BoardDTO board)throws Exception;

    void  deleteFile(int cmIdx)throws Exception;

    void deleteImg(int cmIdx)throws Exception;

    void MemberDelImg(@Param("cmNick")String cmNick)throws Exception;

    void MemberDelComm(@Param("cmNick")String cmNick)throws Exception;
}
