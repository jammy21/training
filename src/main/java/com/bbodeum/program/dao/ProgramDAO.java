package com.bbodeum.program.dao;

import java.util.List;

import com.bbodeum.exception.FindException;
import com.bbodeum.program.vo.Program;

public interface ProgramDAO {
	public List<Program> selectByTrAndKeyAndDy(String trId, int keyId, String dy, int start, int end)
		throws FindException;
}
