package springframe.Initial_spring.config;

import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springframe.Initial_spring.repository.*;
import springframe.Initial_spring.service.MemberService;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    // DataSource는 데이터베이스 커넥션을 획득할 때 사용하는 객체입니다.
    // 스프링 부트는 데이터베이스 커넥션 정보를 바탕으로 DataSource를 생성하고 스프링 빈으로 만들어둡니다.
    // 그래서 DI를 받을 수 있습니다.
    private final DataSource dataSource;
    private EntityManager em;

    public SpringConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
}
