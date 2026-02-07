package in.at.main.controller;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.at.main.entity.EventAttendance;
import in.at.main.entity.NormalAttendance;
import in.at.main.repository.EventAttendanceRepository;
import in.at.main.repository.NormalAttendanceRepository;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/student")

public class StudentController {

    private final NormalAttendanceRepository normalRepo;
    private final EventAttendanceRepository eventRepo;

    public StudentController(NormalAttendanceRepository normalRepo, EventAttendanceRepository eventRepo) {
        this.normalRepo = normalRepo;
        this.eventRepo = eventRepo;
    }
    
    @GetMapping("/{rollNo}/normal")
    public List<NormalAttendance> getNormal(@PathVariable String rollNo) {
        return normalRepo.findByIdRollNo(rollNo);
    }

    @GetMapping("/{rollNo}/event")
    public List<EventAttendance> getEventAttendance(@PathVariable String rollNo) {
        return eventRepo.findAll()
                .stream()
                .filter(a -> a.getId().getRollNo().equals(rollNo))
                .toList();
    }

}
