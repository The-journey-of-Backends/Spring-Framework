package springframe.Initial_spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import springframe.Initial_spring.service.MemberService;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired // 의존 관계 주입(DI)를 할 때 사용하는 어노테이션(Annotation)이며, 의존 객체의 타입에 해당하는 빈(Bean)을 찾아 주입해주는 역할을 합니다.
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
