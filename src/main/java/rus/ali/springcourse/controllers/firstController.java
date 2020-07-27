package rus.ali.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class firstController {
    @GetMapping("/hello")
    //передаем ключ нэйм и значение положим в стринг нэйм strng will took from URL and put to string name
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {
        //System.out.println("Hello " + name + " " + surname);

        model.addAttribute("message", "Hello " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage(HttpServletRequest request) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        System.out.println("Hello " + name + " " + surname);
        return "first/goodbye";
    }

    @GetMapping("/calc")
    public String calculator(@RequestParam("a") int a,
                             @RequestParam("b") int b,
                             @RequestParam("action") String action, Model model) {
        double result;

        switch (action) {
            case "mult":
                result = a * b;
                break;

            case "div":
                result = a / (double) b;
                break;

            case "plus":
                result = a + b;
                break;

            case "minus":
                result = a - b;
                break;

            default:
                result = 0;
                break;
        }

        model.addAttribute("result", result);

        return "";
    }

    @GetMapping("/mainpage")
    public String toMain() {
        return "first/mainPage";
    }
}
