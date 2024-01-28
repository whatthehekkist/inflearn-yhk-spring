package inflearn.yhk._01;

import inflearn.yhk._01.repository.MemberRepository;
import inflearn.yhk._01.repository.MemoryMemberRepository;
import inflearn.yhk._01.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
