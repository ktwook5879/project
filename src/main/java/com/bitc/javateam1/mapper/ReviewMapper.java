package com.bitc.javateam1.mapper;

import com.bitc.javateam1.dto.ReviewDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReviewMapper {

    public void InsertReview(ReviewDTO review)throws Exception;

    List<ReviewDTO> SelectReview(int commIdx)throws Exception;

    void DeleteReview(int rno)throws Exception;

    ReviewDTO SelectReviewRno(@Param("rno") int rno)throws Exception;

    void DeleteallBoard(int cmIdx)throws Exception;


    void DeleteNick(@Param("reNick")String cmNick)throws Exception;
}
