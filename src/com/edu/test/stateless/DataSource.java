package com.edu.test.stateless;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {

	private static DataSource dataSource = new DataSource();
	private Connection conn;
	private String driver;
	private String url;
	private String user;
	private String password;
	
	private DataSource() {}
	
	public static DataSource getIncetance() {
		
		return dataSource;
	}
	
	public Connection getConnection() {
		dbConfig(); //환경파일불러 db정보 담는다.
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,password);
			
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return conn;
	}
	
	private void dbConfig() { //환경파일을 불러오는 메소드
		String resource = getClass().getResource("db.properties").getPath();		//파일위치
		System.out.println(resource);  		//실제 물리적 패스 출력
		Properties properties = new Properties();		//properties객체생성
		
		try {
			properties.load(new FileReader(resource));		//환경파일을 Reader객체를 통해 읽음
			driver = properties.getProperty("driver");		//변수에 환경파일의 값을 적용
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}

