package springframe.Initial_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springframe.Initial_spring.domain.Member;
import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    Optional<Member> findByName(String name);
}
