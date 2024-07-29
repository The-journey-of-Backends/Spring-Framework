package springframe.Initial_spring.domain;

import lombok.Getter;
import lombok.Setter;

// lombok을 사용해서 Getter Setter 적용
@Getter
@Setter
public class Member {
    private Long id;
    private String name;
}
