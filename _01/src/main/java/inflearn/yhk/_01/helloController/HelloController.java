package inflearn.yhk._01.helloController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        String s = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.";
        model.addAttribute("data", s); // key, value
        return "hello";
    }
}
