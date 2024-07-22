package springframe.Initial_spring.repository;

import springframe.Initial_spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    // findById or findByName 값이 null일 때 null을 그대로 반환하는 대신 Optional을 통해서 반환한다.
    Optional<Member> findById(Long id);
    Optional<Member> findByUsername(String username);
    List<Member> findAll(); //지금까지 저장된 모든 회원 리스트를 반환해줍니다.
}
