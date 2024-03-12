package com.bitc.javateam1.service;

import com.bitc.javateam1.dto.MemberDTO;

public interface MemberService {
 public void Register(MemberDTO memberDTO) throws Exception;

 public int isUserInfo(String id, String password) throws Exception;

public MemberDTO getUserInfo(String id) throws Exception;

 int regiCheck(MemberDTO memberDTO)throws Exception;

    void memberDel(String nick)throws Exception;

    MemberDTO myPageInform(String nickName)throws Exception;

    public MemberDTO memberInformation(String id) throws Exception;

    public void dataEdit(MemberDTO dto) throws Exception;

    public boolean selectNickName(String nickName); //중복 nickName 검색
}
