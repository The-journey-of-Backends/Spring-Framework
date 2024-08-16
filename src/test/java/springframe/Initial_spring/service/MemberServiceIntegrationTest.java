package springframe.Initial_spring.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import springframe.Initial_spring.domain.Member;
import springframe.Initial_spring.repository.MemberRepository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest // 스프링 컨테이너와 테스트를 함께 실행한다.
@Transactional // 테스트 케이스에 이 애노테이션이 있으면, 테스트 시작 전에 트랜잭션을 시작하고, 테 스트 완료 후에 항상 롤백한다.
// 이렇게 하면 DB에 데이터가 남지 않으므로 다음 테스트에 영향을 주지 않는다.
public class MemberServiceIntegrationTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception {
        //given : hello라는 값이 주어졌을 떄
        Member member = new Member();
        member.setName("hello");

        //when : join이라는 가입 기능을 실행 했을 때
        Long saveId = memberService.join(member);

        //then : 이름이 일치하는지 결과 확인
        Member findMember = memberRepository.findById(saveId).get();
        assertEquals(member.getName(), findMember.getName());
    }

    @Test
    public void 중복_회원_예외() throws Exception {
        //Given : 동일한 이름을 가진 두 회원 객체를 생성
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //When : 첫 번째 회원을 가입시키고, 두 번째 회원 가입 시 예외 발생을 검증
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> memberService.join(member2)); //예외가 발생해야 한다.

        //Then : 발생한 예외의 메시지를 검증
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
}
