package com.bitc.javateam1.dto;

import lombok.Data;

@Data
public class BoardDTO {
    private int cmIdx;
    private String cmId;
    private String cmNick;
    private String title;
    private String content;
    private String postdate;
    private int visitCount;
    private int cmNum;
    private String imgName;
    private String imgUrl;
    private String level;

    private int reviewCount;
}
