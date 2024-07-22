package springframe.Initial_spring.service;

import springframe.Initial_spring.domain.Member;
import springframe.Initial_spring.repository.MemberRepository;
import springframe.Initial_spring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    // 서비스 repository는 비지니스에 가까운 용어를 작성해야 한다.

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    // 회원가입
    public Long join(Member member) {

        //같은 이름이 있는 중복 회원x
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByUsername(member.getName()) //findByUsername을 빼주고 이 값은 Optional이기 때문에
            .ifPresent(member1 -> { // 바로 ifPresent에 반환
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    // 전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findMember(Long id) {
        return memberRepository.findById(id);
    }


}
