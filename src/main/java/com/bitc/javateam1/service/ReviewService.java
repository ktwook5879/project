package com.bitc.javateam1.service;

import com.bitc.javateam1.dto.ReviewDTO;

import java.util.List;

public interface ReviewService {
    void InsertView(ReviewDTO review)throws Exception;

    List<ReviewDTO> SelectReview(int commIdx)throws Exception;

    void DeleteReview(int rno)throws Exception;

    ReviewDTO SelectReviewRno(int rno)throws Exception;

    void DeleteallBoard(int cmIdx)throws Exception;

    void DeleteNick(String cmNick)throws Exception;
}
