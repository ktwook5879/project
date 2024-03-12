package com.bitc.javateam1.service;

import com.bitc.javateam1.dto.BoardDTO;
import com.bitc.javateam1.dto.MemberDTO;
import com.github.pagehelper.Page;

public interface AdminService {

    Page<MemberDTO> userList(int pageNum) throws Exception;

    MemberDTO userDetail(int idx)throws Exception;



    Page<BoardDTO> postList(int pageNum, String cmId)throws Exception;
}
