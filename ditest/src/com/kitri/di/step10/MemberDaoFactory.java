package com.kitri.di.step10;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration //�������� ��� �� Ŭ������ ����ϰڴ�. �������� �����ϹǷ� �ڵ����� �̱��� ������ ����ȴ�.
public class MemberDaoFactory { 
	private MemberDao memberDao;
	
	@Bean(name={"mdao","memberDao"}) //�ܺο��� ������ ���� �༮�̹Ƿ� �ݵ�� Beanǥ�� �������
//	@Scope(value="prototype")
	public MemberDao getMemberDao(){ //initMethod > �� Bean�� ȣ��ǰ� �������� ����Ǵ� Method�� �����ϴ� ��
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