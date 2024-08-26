package springframe.Initial_spring.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

// lombok을 사용해서 Getter Setter 적용
@Getter
@Setter

// JPA는 객체와 ORM이라는 기술입니다.
// 즉, ORM 객체의 object와 relational 데이터베이스의 table을 m mapping 한다는 뜻입니다.
@Entity
public class Member {
    // DB가 자동으로 ID 값을 넣어주는 것을 IDENTITY 전략이라고 합니다.
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
