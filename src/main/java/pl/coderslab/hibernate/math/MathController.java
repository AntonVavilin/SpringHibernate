package pl.coderslab.hibernate.math;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/math")
public class MathController {
    private final MathService mathService;

    @GetMapping("/add/{a}/{b}")
    public String add(@PathVariable(name = "a") int a, @PathVariable(name = "b") int b) {
        return String.valueOf(mathService.add(a, b));
    }
    @GetMapping("/substract/{a}/{b}")
    public String substract(@PathVariable int a, @PathVariable int b) {
        return String.valueOf(mathService.subtract(a, b));
    }
    @GetMapping("/multiply/{a}/{b}")
    public String multiply(@PathVariable int a, @PathVariable int b) {
        return String.valueOf(mathService.multiply(a, b));
    }
    @GetMapping("/divide/{a}/{b}")
    public String divide(@PathVariable int a, @PathVariable int b) {
        return String.valueOf(mathService.divide(a, b));
    }
    @GetMapping("/factorial/{n}")
    public String factorial(@PathVariable int n) {
        return String.valueOf(mathService.factorial(n));
    }
}
