package pl.coderslab.hibernate.math;

import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
class MathService {

    public int add(int a, int b) {
        return a + b;
    }
    public int subtract(int a, int b) {
        return a - b;
    }
    public int multiply(int a, int b) {
        return a * b;
    }
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("divide by zero");
        }
        return a / b;
    }
    public BigInteger factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be >= 0");
        BigInteger res = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            res = res.multiply(BigInteger.valueOf(i));
        }
        return res;

    }

}
