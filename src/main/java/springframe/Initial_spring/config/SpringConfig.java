package springframe.Initial_spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springframe.Initial_spring.repository.MemberRepository;
import springframe.Initial_spring.repository.MemoryMemberRepository;
import springframe.Initial_spring.service.MemberService;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
