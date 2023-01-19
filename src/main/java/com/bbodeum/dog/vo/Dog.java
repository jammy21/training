package com.bbodeum.dog.vo;


import java.util.Date;

import com.bbodeum.member.vo.Member;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Dog {
	private int dogId;
	private Member member;
	private String dogName;
	private String dogBreed;
	@JsonFormat(timezone = "Asia/Seoul", pattern = "yy-MM-dd")
	private Date dogBirth;
	private int dogWeight;
	private String dogRemark;
	private int dogStatus;
	
}

