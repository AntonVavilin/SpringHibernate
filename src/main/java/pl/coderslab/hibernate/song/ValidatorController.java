package pl.coderslab.hibernate.song;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.hibernate.publishers.Publisher;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class ValidatorController {
    private final Validator validator;
    public ValidatorController(Validator validator) {
        this.validator = validator;
    }

    @GetMapping("/validate")
    public String validateSong(){
        Song song = new Song();
        song.setTitle("aa");
        song.setPages(3);
        song.setRating(5);
        song.setPublisher(new Publisher());

        Set<ConstraintViolation<Song>> constraintViolations = validator.validate(song);

        if (constraintViolations.isEmpty()){
            return "ok";
        }else{
            String errors = constraintViolations.stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.joining(","));
            return "fail: " + errors;
        }

    }
}

