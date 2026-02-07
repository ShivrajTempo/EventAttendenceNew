package in.at.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users/student")
public class StudentViewController {

    @GetMapping("/dashboard")
    public String dashboard() {
        return "/dashboard.html";
    }
}
