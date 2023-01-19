package resource;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Factory {
	private static SqlSessionFactory sqlSessionFactory;
	// 초기화 블록:멤버 변수 초기화하는 블록
	static {
		try {
			String resource = "resource/config.xml";
			//프로그램이 사용할 수 있는 자원 파일 resource
			Reader reader = Resources.getResourceAsReader(resource);
			//파일 생성할 수 있는 reader 객체

			if (sqlSessionFactory == null) {
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
				//사용할 sql session factory 객체 생성
				//bulder로 끝나는거: 원하는 설정 내용을 넣어서 객체를 생성해주는 클래스
				//그러니까 객체가 생성된 게 아니라... 몰라 ㅅㅂ
				//Builder: 객체 생성에 필요한 설정이 가능하고 설정한 내용으로 객체를 생성해줌
				//이렇게 해놓고 config로 환경설정을 셋팅을 하는 거래
				//build(): config.xml의 내용을 설정에 활용허요 설정함
				
				Class[] mapper = { com.bbodeum.program.dao.ProductMapper.class };
//				//구현할 맵퍼 등록
//				//클래스 타입의 배열! 맵퍼 여러개를 담을 배열
				for (Class m : mapper) {
					sqlSessionFactory.getConfiguration().addMapper(m);
//					//구현체를 만들어줄 sqlSessionFactory 객체에 Mapper를 등록
//					//구현체를 가지고 db 작업을 한대
				}
			}
		} catch (FileNotFoundException fileNotFoundException) {
			fileNotFoundException.printStackTrace();
		} catch (IOException iOException) {
			iOException.printStackTrace();
		}
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
