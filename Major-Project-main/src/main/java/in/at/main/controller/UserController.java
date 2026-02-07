package in.at.main.controller;

import in.at.main.entity.Faculty;
import in.at.main.entity.Student;
import in.at.main.repository.FacultyRepository;
import in.at.main.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.OptionalInt;

@Controller
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private FacultyRepository facultyRepository;

    @PostMapping("/login")
    public String userLogin(@RequestParam String userId,
                            @RequestParam String role,
                            @RequestParam String password, Model model) {
        log.info("user coming");
        if (userId == null || password == null || role == null) {
            return "login";
        }
        if("STUDENT".equals(role)){
            log.info("inside student login");
            Optional<Student> student=studentRepository.findById(userId);
            if(student.isPresent()){
                log.info(" student present");
                model.addAttribute("student", student.get());
                model.addAttribute("attendanceList", new ArrayList<>());
                return "redirect:/users/student/dashboard";
            }
            else{
                return "ID does not exist";
            }
        }
        else if("FACULTY".equals(role)){
            Optional<Faculty> faculty=facultyRepository.findById(userId);
            if(faculty.isPresent()){
                return "faculty";
            }
            else{
                return "ID does not exist";
            }
        }



        return "login";
    }

}
