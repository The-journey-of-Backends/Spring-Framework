package springframe.Initial_spring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    @ResponseBody //를 사용하변 뷰 리졸버를 사용하지 않음
    // 여기서 뷰 리졸버란 helloMVC 객체를 View 영역으로 전달하기 위 알맞은 View의 정보를 설정하는 역할을 한다.
    public String helloMvc(@RequestParam("name") String name){ //@RequestParam은 Http 요청 파리미터 값을 편리하게 사용하게 해주는 기능입니다.
        return "hello-mvc" + name;
    }
}
