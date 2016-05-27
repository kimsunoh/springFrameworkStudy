package com.kitri.di.step08;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration //설정파일 대신 이 클래스를 사용하겠다. 스프링이 관리하므로 자동으로 싱글톤 패턴이 적용된다.
public class MemberDaoFactory { 
	private MemberDao memberDao;
	
	@Bean(name={"mdao","memberDao"},initMethod="init") //외부에서 가져다 쓰는 녀석이므로 반드시 Bean표시 해줘야함
	@Scope(value="prototype")
	public MemberDao getMemberDao(){ //initMethod > 이 Bean이 호출되고 생성된후 실행되는 Method를 지정하는 것
		memberDao = new MemberDao(getOraDBConnection());
		return memberDao;
	}
	
	private DBConnection getOraDBConnection(){
		//private면 외부에서 가져다 쓸수 없으므로 @Bean을 설정해 주면 안된다.
		//Bean은 외부에서 가져다 쓴다는 의미이므로
		return new OraDBConnection();
	}

	private DBConnection getMSDBConnection(){
		return new MsDBConnetion();
	}
}
