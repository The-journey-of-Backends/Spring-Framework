package springframe.Initial_spring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springframe.Initial_spring.domain.Member;
import springframe.Initial_spring.repository.MemberRepository;
import springframe.Initial_spring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

//@Service
@Transactional // jpa를 사용하려면 항상 있어야 된다.
public class MemberService {

    // 서비스 repository는 비지니스에 가까운 용어를 작성해야 한다.

    private final MemberRepository memberRepository;

//    @Autowired
    // MemberRepository를 외부에서 넣어줄 수 있게 바꿔줌
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 회원가입
    public Long join(Member member) {
            //같은 이름이 있는 중복 회원x
            validateDuplicateMember(member); //중복 회원 검증
            memberRepository.save(member);
            return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByUsername(member.getUsername()) //findByUsername을 빼주고 이 값은 Optional이기 때문에
            .ifPresent(member1 -> { // 바로 ifPresent에 반환
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    /**
     *전체 회원 조회 */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findMember(Long id) {
        return memberRepository.findById(id);
    }


}
