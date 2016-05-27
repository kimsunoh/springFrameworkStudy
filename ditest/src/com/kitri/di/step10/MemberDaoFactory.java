package com.kitri.di.step10;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration //설정파일 대신 이 클래스를 사용하겠다. 스프링이 관리하므로 자동으로 싱글톤 패턴이 적용된다.
public class MemberDaoFactory { 
	private MemberDao memberDao;
	
	@Bean(name={"mdao","memberDao"}) //외부에서 가져다 쓰는 녀석이므로 반드시 Bean표시 해줘야함
//	@Scope(value="prototype")
	public MemberDao getMemberDao(){ //initMethod > 이 Bean이 호출되고 생성된후 실행되는 Method를 지정하는 것
		memberDao = new MemberDao();
		memberDao.setDataSource(getDataSource());
		return memberDao;
	}
	
	private DataSource getDataSource(){
		SimpleDriverDataSource datasource = new SimpleDriverDataSource();
		datasource.setDriverClass(oracle.jdbc.driver.OracleDriver.class);
		datasource.setUrl("jdbc:oracle:thin:@192.168.12.100:1521:orcl");
		datasource.setUsername("kitri");
		datasource.setPassword("kitri");
		return datasource;
	}
}
