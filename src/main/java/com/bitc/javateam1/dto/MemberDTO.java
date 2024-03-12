package com.bitc.javateam1.dto;

import lombok.Data;

@Data
public class MemberDTO {
	private int idx;
	private String id;
	private String password;
	private String nickName;
	private String name;
	private String regidate;
	private int grade;
	private int reCount;
	private int commCount;
}