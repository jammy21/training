package com.bbodeum.dog.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.bbodeum.dog.vo.Dog;
import com.bbodeum.exception.FindException;
import com.bbodeum.member.vo.Member;

import resource.Factory;

public class DogDAOOracle implements DogDAO {

	private SqlSessionFactory sqlSessionFactory;

	public DogDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}

	@Override
	public void insert(Dog dog) throws FindException {

		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
//		         session.getConfiguration().get
			// 2. 구현체 객체 받아옴
//		         ProductMapper mapper = (ProductMapper) session.getMapper(ProductMapper.class);

			// 3. 구현체 메소드 호출하여 db작업 실행

//		         List<Program> list = mapper.selectTest();
//		         List<Program> list = mapper.selectByTrAndKeyAndDy(trId, keyId, dy, start, end);

			Map<String, Object> map = new HashMap<>();
			map.put("dogId", dog.getDogId());
			map.put("member", dog.getMember().getMemId());
			map.put("dogName", dog.getDogName());
			map.put("dogBreed", dog.getDogBreed());
			map.put("dogBirth", dog.getDogBirth());
			map.put("dogWeight", dog.getDogWeight());
			map.put("dogRemark", dog.getDogRemark());
//		         map.put("dogStatus", dog.getDogStatus());

			// "insert into dog values(#{dog_id}, #{dog_mem_id}, #{dog_name}, #{dog_breed},
			// #{dog_birthday}, #{dog_weight}, #{dog_remark}, 1)” - 완료

			session.selectList("com.bbodeum.dog.dao.DogMapper.insert", map);

		} catch (Exception e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	@Override
	public void update(Dog dog) throws FindException {

		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
//			session.getConfiguration().get
			// 2. 구현체 객체 받아옴
//			ProductMapper mapper = (ProductMapper) session.getMapper(ProductMapper.class);

			// 3. 구현체 메소드 호출하여 db작업 실행

//			List<Program> list = mapper.selectTest();
//			List<Program> list = mapper.selectByTrAndKeyAndDy(trId, keyId, dy, start, end);

			Map<String, Object> map = new HashMap<>();
			map.put("dogoId", dog.getDogId());
			map.put("memId", dog.getMember());
			map.put("dogName", dog.getDogName());
			map.put("dogBreed", dog.getDogBreed());
			map.put("dogBirth", dog.getDogBirth());
			map.put("dogWeight", dog.getDogWeight());
			map.put("dogStatus", dog.getDogStatus());

			// "insert into dog values(#{dog_id}, #{dog_mem_id}, #{dog_name}, #{dog_breed},
			// #{dog_birthday}, #{dog_weight}, #{dog_remark}, 1)” - 완료

			session.selectList("com.bbodeum.dog.dao.DogMapper.editDog", map);

		} catch (Exception e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public void delete(int dogId, int dogStatus) throws FindException {

		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
//		session.getConfiguration().get
			// 2. 구현체 객체 받아옴
//		ProductMapper mapper = (ProductMapper) session.getMapper(ProductMapper.class);

			// 3. 구현체 메소드 호출하여 db작업 실행

//		List<Program> list = mapper.selectTest();
//		List<Program> list = mapper.selectByTrAndKeyAndDy(trId, keyId, dy, start, end);

			Map<String, Object> map = new HashMap<>();
			map.put("dogId", dogId);
			map.put("dogStatus", dogStatus);

			// "insert into dog values(#{dog_id}, #{dog_mem_id}, #{dog_name}, #{dog_breed},
			// #{dog_birthday}, #{dog_weight}, #{dog_remark}, 1)” - 완료

			session.selectList("com.bbodeum.dog.dao.DogMapper.editStatusDog", map);

		} catch (Exception e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public List<Dog> selectByMemId(String memId) throws FindException {

		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
//			session.getConfiguration().get
			// 2. 구현체 객체 받아옴
//			ProductMapper mapper = (ProductMapper) session.getMapper(ProductMapper.class);

			// 3. 구현체 메소드 호출하여 db작업 실행

//			List<Program> list = mapper.selectTest();
//			List<Program> list = mapper.selectByTrAndKeyAndDy(trId, keyId, dy, start, end);
			Map<String, Object> map = new HashMap<>();
			map.put("memId", memId);

			List<Dog> list = session.selectList("com.bbodeum.dog.dao.DogMapper.selectByMemId", map);
			// System.out.println(list);
			for (Dog p : list) {
				System.out.println(p);
			}

			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public static void main(String[] args) throws FindException {
		 DogDAOOracle dao = new DogDAOOracle();
		 Date d = new Date(2020, 5, 1, 20, 0, 0);
		 Member m = new Member();
		 m.setMemId("joe123");
		 Dog dog = new Dog(14, m, "망고", "말티즈", d ,8,"없음",1);
		 dao.insert(dog);
	}
}
