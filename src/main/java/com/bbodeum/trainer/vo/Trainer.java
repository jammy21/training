package com.bbodeum.trainer.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Trainer {
	private String trId;
	private String trPwd;
	private String trName;
	private String trTel;
	private String trEmail;
	private String trCareer;
	private String trLicense;
	private int trStatus;
}
