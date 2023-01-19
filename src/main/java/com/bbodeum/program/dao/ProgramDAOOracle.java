package com.bbodeum.program.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.bbodeum.apply.vo.Apply;
import com.bbodeum.exception.FindException;
import com.bbodeum.program.vo.Program;

import resource.Factory;

public class ProgramDAOOracle implements ProgramDAO {
	private SqlSessionFactory sqlSessionFactory;

	public ProgramDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}

	@Override
	public List<Program> selectByTrAndKeyAndDy(String trId, int keyId, String dy, int start, int end)
			throws FindException {
		SqlSession session = null;
		try{
			session = sqlSessionFactory.openSession();
//			session.getConfiguration().get
			//2. 구현체 객체 받아옴
//			ProductMapper mapper = (ProductMapper) session.getMapper(ProductMapper.class);

			//3. 구현체 메소드 호출하여 db작업 실행

//			List<Program> list = mapper.selectTest();
//			List<Program> list = mapper.selectByTrAndKeyAndDy(trId, keyId, dy, start, end);
			Map<String, Object> map = new HashMap<>();
			map.put("trId", trId);
			map.put("keyId", keyId);
			map.put("dy", dy);
			map.put("start", start);
			map.put("end", end);
			
			
			List<Program> list = session.selectList("com.bbodeum.program.dao.ProgramMapper.selectByTrAndKeyAndDy", map);
			//System.out.println(list);
			for(Program p: list) {
				for(Apply a: p.getApply()) {
					System.out.println(a);
				}
			}
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
		ProgramDAOOracle dao = new ProgramDAOOracle();
		System.out.println(dao.selectByTrAndKeyAndDy("T0001", 200, "금", 1, 5));
//		System.out.println(dao.test1());

	}

}
