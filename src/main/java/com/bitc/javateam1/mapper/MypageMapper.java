package com.bitc.javateam1.mapper;

import com.bitc.javateam1.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MypageMapper {
    MemberDTO myPageInform(String nickName)throws Exception;
}
