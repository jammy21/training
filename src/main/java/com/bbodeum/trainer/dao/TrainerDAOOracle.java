package com.bbodeum.trainer.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.bbodeum.exception.AddException;
import com.bbodeum.exception.FindException;
import com.bbodeum.exception.ModifyException;
import com.bbodeum.trainer.vo.Trainer;

import resource.Factory;

public class TrainerDAOOracle implements TrainerDAO {
	private SqlSessionFactory sqlSessionFactory;

	public TrainerDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}
	
	@Override
	public void insert(Trainer vo) throws AddException {
		SqlSession session = null;
		try{
			session = sqlSessionFactory.openSession();

			Map<String, Object> map = new HashMap<>();
			map.put("trId", vo.getTrId());
			map.put("trPwd", vo.getTrPwd());
			map.put("trName", vo.getTrName());
			map.put("trTel", vo.getTrTel());
			map.put("trEmail", vo.getTrEmail());
			map.put("trCareer", vo.getTrCareer());
			map.put("trLicense", vo.getTrLicense());

			session.insert("com.bbodeum.trainer.dao.TrainerMapper.addTrainer", map);
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
	public void update(Trainer vo) throws ModifyException {
		SqlSession session = null;
		try{
			session = sqlSessionFactory.openSession();

			Map<String, Object> map = new HashMap<>();
			map.put("trId", vo.getTrId());
			map.put("trPwd", vo.getTrPwd());
			map.put("trName", vo.getTrName());
			map.put("trTel", vo.getTrTel());
			map.put("trEmail", vo.getTrEmail());
			map.put("trCareer", vo.getTrCareer());
			map.put("trLicense", vo.getTrLicense());
			
			session.update("com.bbodeum.trainer.dao.TrainerMapper.editTrainer", map);
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
	public void updateStatus(String trId) throws ModifyException {
		SqlSession session = null;
		try{
			session = sqlSessionFactory.openSession();

			Map<String, Object> map = new HashMap<>();
			map.put("trId", trId);
			
			session.update("com.bbodeum.trainer.dao.TrainerMapper.editStatusTrainer", map);
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
	public Trainer selectByTrId(String trId) throws FindException {
		SqlSession session = null;
		try{
			session = sqlSessionFactory.openSession();

			Map<String, Object> map = new HashMap<>();
			map.put("trId", trId);
			
			Trainer list = session.selectOne("com.bbodeum.trainer.dao.TrainerMapper.selectByTrId", map);

			return list;
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		}finally {
			if(session != null) {
				session.close();
			}
		}
	}
	
	@Override
	public List<Trainer> selectAll(int start, int end) throws FindException{
		SqlSession session = null;
		try{
			session = sqlSessionFactory.openSession();

			Map<String, Object> map = new HashMap<>();
			map.put("start", start);
			map.put("end", end);
			
			
			List<Trainer> list = session.selectList("com.bbodeum.trainer.dao.TrainerMapper.selectAll", map);

			return list;
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		}finally {
			if(session != null) {
				session.close();
			}
		}
	}

	public static void main(String[] args) throws FindException {
		/*
		TrainerDAOOracle dao = new TrainerDAOOracle();
		Trainer vo = new Trainer("T0011", "9981", "이기제", "01012345678", "lkj@gmail.com", "트레이너 경력 2년", "강아지 훈련사 2급", 1);
		dao.insert(vo);
		*/
		/*
		TrainerDAOOracle dao = new TrainerDAOOracle();
		Trainer vo = new Trainer("T0009", "6653", "장호익", "01023456789", "jhi@gmail.com", "트레이너 경력 3년", "강아지 훈련사 3급", 1);
		dao.update(vo);
		*/
		/*
		TrainerDAOOracle dao = new TrainerDAOOracle();
		dao.updateStatus("T0009");
		*/
		/*
		TrainerDAOOracle dao = new TrainerDAOOracle();
		System.out.println(dao.selectByTrId("T0001"));
		*/
		/*
		TrainerDAOOracle dao = new TrainerDAOOracle();
		System.out.println(dao.selectAll(1, 3));
		*/
	}
}
