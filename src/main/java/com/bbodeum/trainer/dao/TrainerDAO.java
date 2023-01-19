package com.bbodeum.trainer.dao;

import java.util.List;

import com.bbodeum.exception.AddException;
import com.bbodeum.exception.FindException;
import com.bbodeum.exception.ModifyException;
import com.bbodeum.trainer.vo.Trainer;

public interface TrainerDAO {
	/**
	 * 관리자 트레이너 등록
	 * @throws AddException
	 */
	public void insert(Trainer vo) throws AddException;
	
	/**
	 * 트레이너 내정보 수정
	 * @throws ModifyException
	 */
	public void update(Trainer vo) throws ModifyException;
	/**
	 * 트레이너 탈퇴(수정)
	 * @throws ModifyException
	 */
	public void updateStatus(String trId) throws ModifyException;
	/**
	 * 트레이너 내정보 상세
	 * @throws FindException
	 */
	public Trainer selectByTrId(String trId) throws FindException;
	/**
	 * 트레이너 목록(관리자)
	 * @throws FindException
	 */
	List<Trainer> selectAll(int start, int end) throws FindException;
}
