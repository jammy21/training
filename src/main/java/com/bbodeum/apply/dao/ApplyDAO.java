package com.bbodeum.apply.dao;

import com.bbodeum.apply.vo.Apply;
import com.bbodeum.exception.AddException;
import com.bbodeum.exception.ModifyException;

public interface ApplyDAO {
	/**
	 * 신청할 반려견 선택해 등록
	 * @throws AddException
	 */
	public void insert(Apply vo) throws AddException;
	/**
	 * 신청 승인하기
	 * @throws ModifyException
	 */
	public void updateStatus1(int dogId, int progId) throws ModifyException;
	/**
	 * 신청 반려하기
	 * @throws ModifyException
	 */
	public void updateStatus2(int dogId, int progId) throws ModifyException;
	/**
	 * 신청 취소하기
	 * @throws ModifyException
	 */
	public void updateStatus3(int dogId, int progId) throws ModifyException;
}
