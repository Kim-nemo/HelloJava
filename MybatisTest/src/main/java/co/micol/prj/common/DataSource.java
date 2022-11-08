package co.micol.prj.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
// DAO = DataSource
public class DataSource { // 싱글톤 클래스의 기본형
	private static SqlSessionFactory sqlSessionFactory; // Mybatis사용(그래서 싱글톤사용)
	
	private DataSource() {} // 남들이 생성하지 못하도록 생성자를 자기자신이 생성한다
	
	public static SqlSessionFactory getInstance() {
		String resource = "config/mybatis-config.xml"; 
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			System.out.println("DB 연결성공");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("DB 연결실패!!");
		}
		return sqlSessionFactory;
	}
}
