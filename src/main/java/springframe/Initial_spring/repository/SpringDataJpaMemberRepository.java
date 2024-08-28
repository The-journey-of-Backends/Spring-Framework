package springframe.Initial_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springframe.Initial_spring.domain.Member;
import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    // JPQL select m from Member m where m.name = ?
    // 스프링 데이터 JPA는 인터페이스를 통한 기본적인 CRUD, findByName(), findByEmail() 처럼 메서드 이름만으로
    // 조회 기능을 제공해준다.
    Optional<Member> findByUsername(String username);
}
