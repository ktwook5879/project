package com.bitc.javateam1.mapper;


import com.bitc.javateam1.dto.MemberDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberMapper {
	public void Register(MemberDTO memberDTO)throws Exception;

	int isUserInfo(@Param("id") String id, @Param("password") String password) throws Exception;

	MemberDTO getUserInfo(@Param("id") String id) throws  Exception;


	Page<MemberDTO> userList()throws Exception;

	MemberDTO userDetail(int idx)throws Exception;

	int regiCheck(MemberDTO memberDTO)throws Exception;

	void memberDel(@Param("nickName") String nick)throws Exception;

	MemberDTO memberInformation(String id) throws Exception;

	public void edit(MemberDTO dto) throws Exception;

	public int selectNickName(String nickName); //중복 nickName 검색

}
