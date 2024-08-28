package springframe.Initial_spring.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import springframe.Initial_spring.domain.Member;
import springframe.Initial_spring.repository.MemoryMemberRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository storage;

    @BeforeEach
    void setUp() { // 이렇게 했을 때 MemberService 입장에서는 이 방식이 DI 방식이다.
        storage = new MemoryMemberRepository();
        memberService = new MemberService(storage);
    }

    @AfterEach
    void afterEach() {storage.clearStore();}


    @Test
    void 회원가입() {
        // given : 무엇인가 주어졌는데
        Member member = new Member();
        member.setUsername("Hello");

        // when : 이 코드를 실행 했을 때
        Long saveId = memberService.join(member);

        // then : 결과가 이게 나와야 해
        Member findMember = memberService.findMember(saveId).get();
        Assertions.assertThat(member.getUsername()).isEqualTo(findMember.getUsername());
    }

    @Test
    public void 중복_회원_예외(){ // 이전 작성한 예외 처리 잘 되는지 확인
        // given
        Member member1 = new Member();
        member1.setUsername("Spring");

        Member member2 = new Member();
        member2.setUsername("Spring");

        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2)); // asswertThrows에 대해서 정리하기
        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        // then

    }

    @Test
    void findMembers() {
    }

    @Test
    void findMember() {
    }
}