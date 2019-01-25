package calculator.cnyt.co.edu.escuelaing;

import calculator.cnyt.co.edu.escuelaing.entities.Complex;
import calculator.cnyt.co.edu.escuelaing.services.ComplexCalculator;

import static org.junit.jupiter.api.Assertions.*;

class ComplexCalculatorTest {
    private Complex a;
    private Complex b;

    ComplexCalculatorTest(){
        a = new Complex(4, -5);
        b = new Complex(1, 2);
    }

    @org.junit.jupiter.api.Test
    void itShouldAddTwoComplexNumbers() {
        assertEquals(new Complex(5, -3), ComplexCalculator.add(a, b));
    }

    @org.junit.jupiter.api.Test
    void itShouldSubstractTwoComplexNumbers() {
        assertEquals(new Complex(3, -7), ComplexCalculator.substract(a, b));
    }

    @org.junit.jupiter.api.Test
    void itShouldDivideTwoComplexNumbers() {
        System.out.print(ComplexCalculator.division(a, b));
        assertEquals(new Complex(-1.2,-2.6), ComplexCalculator.division(a, b));
    }

    @org.junit.jupiter.api.Test
    void itShouldReturnTheProductOfTwoComplexNumbers() {
        assertEquals(new Complex(14, 3), ComplexCalculator.product(a, b));
    }
}