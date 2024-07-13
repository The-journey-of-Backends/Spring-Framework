package springframe.Initial_spring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) { //@RequestParam은 Http 요청 파리미터 값을 편리하게 사용하게 해주는 기능입니다.
        model.addAttribute("name", name);
        return "hello-template";
    }

    // ResponseBody 문자 반환
    @GetMapping("hello-spring")
    @ResponseBody
    //@ResponseBody //를 사용하변 뷰 리졸버를 사용하지 않음// 여기서 뷰 리졸버란 helloMVC 객체를 View 영역으로 전달하기 위 알맞은 View의 정보를 설정하는 역할을 합니다.
    public String helloSpring(@RequestParam("name") String name) {
        return "hello " + name;
    }

    // ResponseBody 객체 반환
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    // Getter는 속성 값을 반환하는 메소드이며, Setter는 객체의 속성 값을 설정, 변하는 메서드라고 보면 된다.
    static class Hello {
        private String name;
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
