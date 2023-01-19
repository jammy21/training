package com.bbodeum.apply.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.bbodeum.apply.vo.Apply;
import com.bbodeum.dog.vo.Dog;
import com.bbodeum.exception.AddException;
import com.bbodeum.exception.ModifyException;
import com.bbodeum.program.vo.Program;

import resource.Factory;

public class ApplyDAOOracle implements ApplyDAO {
	private SqlSessionFactory sqlSessionFactory;

	public ApplyDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}
	
	@Override
	public void insert(Apply vo) throws AddException {
		SqlSession session = null;
		try{
			session = sqlSessionFactory.openSession();

			Map<String, Object> map = new HashMap<>();
			map.put("dogId", vo.getDog().getDogId());
			map.put("progId", vo.getProgram().getProgId());

//			int rowcnt = session.insert("com.bbodeum.apply.dao.ApplyMapper.addApply", map);
			session.insert("com.bbodeum.apply.dao.ApplyMapper.addApply", map);
//			System.out.println("추가된 건수: " + rowcnt);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
			throw new AddException(e.getMessage());
		}finally {
			if(session != null) {
				session.close();
			}
		}
	}
	
	@Override
	public void updateStatus1(int dogId, int progId) throws ModifyException {
		SqlSession session = null;
		try{
			session = sqlSessionFactory.openSession();

			Map<String, Object> map = new HashMap<>();
			map.put("dogId", dogId);
			map.put("progId", progId);

//			int rowcnt = session.insert("com.bbodeum.apply.dao.ApplyMapper.addApply", map);
			session.update("com.bbodeum.apply.dao.ApplyMapper.editStatusApply1", map);
//			System.out.println("추가된 건수: " + rowcnt);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
			throw new ModifyException(e.getMessage());
		}finally {
			if(session != null) {
				session.close();
			}
		}
	}
	
	@Override
	public void updateStatus2(int dogId, int progId) throws ModifyException {
		SqlSession session = null;
		try{
			session = sqlSessionFactory.openSession();

			Map<String, Object> map = new HashMap<>();
			map.put("dogId", dogId);
			map.put("progId", progId);

//			int rowcnt = session.insert("com.bbodeum.apply.dao.ApplyMapper.addApply", map);
			session.update("com.bbodeum.apply.dao.ApplyMapper.editStatusApply2", map);
//			System.out.println("추가된 건수: " + rowcnt);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
			throw new ModifyException(e.getMessage());
		}finally {
			if(session != null) {
				session.close();
			}
		}
	}
	
	@Override
	public void updateStatus3(int dogId, int progId) throws ModifyException {
		SqlSession session = null;
		try{
			session = sqlSessionFactory.openSession();

			Map<String, Object> map = new HashMap<>();
			map.put("dogId", dogId);
			map.put("progId", progId);

//			int rowcnt = session.insert("com.bbodeum.apply.dao.ApplyMapper.addApply", map);
			session.update("com.bbodeum.apply.dao.ApplyMapper.editStatusApply3", map);
//			System.out.println("추가된 건수: " + rowcnt);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
			throw new ModifyException(e.getMessage());
		}finally {
			if(session != null) {
				session.close();
			}
		}
	}
	
	
	
	public static void main(String[] args) throws ModifyException {
		/*
		ApplyDAOOracle dao = new ApplyDAOOracle();
		
		Dog d = new Dog();
		d.setDogId(13);
		
		Program p = new Program();
		p.setProgId(5);
		
		Apply vo = new Apply(d, p, 0, null, null);
		dao.insert(vo);
		*/
		/*
		ApplyDAOOracle dao = new ApplyDAOOracle();
		dao.updateStatus1(13, 5);
		*/
		/*
		ApplyDAOOracle dao = new ApplyDAOOracle();
		dao.updateStatus2(13, 4);
		*/
		/*
		ApplyDAOOracle dao = new ApplyDAOOracle();
		dao.updateStatus3(13, 1);
		*/
	}
}
