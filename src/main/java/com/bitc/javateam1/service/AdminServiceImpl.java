package com.bitc.javateam1.service;

import com.bitc.javateam1.dto.BoardDTO;
import com.bitc.javateam1.dto.MemberDTO;
import com.bitc.javateam1.mapper.BoardMapper;
import com.bitc.javateam1.mapper.MemberMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    MemberMapper memberMapper;
    @Autowired
    BoardMapper boardMapper;
    @Override
    public Page<MemberDTO> userList(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 10);
        return memberMapper.userList();
    }

    @Override
    public MemberDTO userDetail(int idx) throws Exception{
        return memberMapper.userDetail(idx);
    }


    @Override
    public Page<BoardDTO> postList(int pageNum, String cmId)throws Exception {
        PageHelper.startPage(pageNum, 10);
        return boardMapper.postList(pageNum, cmId);
    }

}
