package com.bbodeum.program.vo;

import java.util.List;

import com.bbodeum.apply.vo.Apply;
import com.bbodeum.keyword.vo.Keyword;
import com.bbodeum.trainer.vo.Trainer;

public class Program {
	private int progId;
//	private String progTrId;
	private Trainer trainer;
//	private int progKeyId;
	private Keyword keyword;
	private String progTitle;
	
	private List<Apply> apply;
}
