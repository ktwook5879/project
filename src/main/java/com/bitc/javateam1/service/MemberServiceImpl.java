package com.bitc.javateam1.service;

import com.bitc.javateam1.dto.MemberDTO;
import com.bitc.javateam1.mapper.MemberMapper;
import com.bitc.javateam1.mapper.MypageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private MypageMapper mypageMapper;
	@Override
	public void Register(MemberDTO memberDTO) throws Exception{

		memberMapper.Register(memberDTO);
	}
	@Override
	public int isUserInfo(String id, String password) throws Exception {
		return memberMapper.isUserInfo(id, password);
	}

	@Override
	public MemberDTO getUserInfo(String id) throws Exception {
		return memberMapper.getUserInfo(id);
	}

	@Override
	public int regiCheck(MemberDTO memberDTO)throws Exception {
		return memberMapper.regiCheck(memberDTO);
	}

	@Override
	public void memberDel(String nick) throws Exception {
		memberMapper.memberDel(nick);
	}

	@Override
	public MemberDTO myPageInform(String nickName) throws Exception {
		return mypageMapper.myPageInform(nickName);
	}

	@Override
	public MemberDTO memberInformation(String id) throws Exception {
		return memberMapper.memberInformation(id);
	}

	@Override
	public void dataEdit(MemberDTO dto) throws Exception {
		memberMapper.edit(dto);
	}


	@Override
	public boolean selectNickName(String nickName) {
		int result = memberMapper.selectNickName(nickName);

		if (result > 0) {
			return false;
		}
		else {
			return true;
		}
	}

}
