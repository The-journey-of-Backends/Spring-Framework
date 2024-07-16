package springframe.Initial_spring.Repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import springframe.Initial_spring.domain.Member;
import springframe.Initial_spring.repository.MemoryMemberRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();

    // Test 케이스는 순서와 상관이 없기 때문에 항상 이렇게 clear 하는 기능을 만들어 주어야 한다.
    @AfterEach
    public void afterEatch(){
        memoryMemberRepository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("yuchan");

        memoryMemberRepository.save(member);

        Member result = memoryMemberRepository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findById(){
        Member member1 = new Member();
        member1.setName("yuchan1");
        memoryMemberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("yuchan2");
        memoryMemberRepository.save(member2);

        Member result = memoryMemberRepository.findByUsername("yuchan2").get();
        assertThat(result).isEqualTo(member2);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("yuchan1");
        memoryMemberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("yuchan2");
        memoryMemberRepository.save(member2);

        List<Member> members = memoryMemberRepository.findAll();
        assertThat(members).hasSize(2);
    }
}
