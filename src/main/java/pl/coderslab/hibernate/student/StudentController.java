package pl.coderslab.hibernate.student;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;
    @GetMapping
    public List<StudentDTO> findAll() {
        return studentService.findAll()
                .stream()
                .map(s -> StudentDTO.builder()
                        .id(s.getId())
                        .firstName(s.getFirstName())
                        .lastName(s.getLastName())
                        .indexNumber(s.getIndexNumber())
                        .averageGrade(s.getAverageGrade())
                        .build()
                ).collect(Collectors.toList());
    }

}
