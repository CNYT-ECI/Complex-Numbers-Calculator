package calculator.cnyt.co.edu.escuelaing;

import calculator.cnyt.co.edu.escuelaing.entities.Complex;
import calculator.cnyt.co.edu.escuelaing.entities.ComplexMatrix;
import calculator.cnyt.co.edu.escuelaing.entities.ComplexVector;
import calculator.cnyt.co.edu.escuelaing.services.ComplexCalculator;
import calculator.cnyt.co.edu.escuelaing.services.ComplexException;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class ComplexCalculatorTest {
    private Complex a;
    private Complex b;
    private Complex c;
    private Complex d;
    private ComplexVector vectorA;
    private ComplexVector vectorB;
    public static final String FAIL_MESSAGE = "The exception wasn't throw";

    ComplexCalculatorTest() {
        a = new Complex(4, -5);
        b = new Complex(1, 2);
        c = new Complex(3, -2);
        d = new Complex(-1, -1);
        vectorA = new ComplexVector(Arrays.asList(a, b));
        vectorB = new ComplexVector(Arrays.asList(c, d));
    }

    @org.junit.jupiter.api.Test
    void itShouldAddTwoComplexNumbers() {
        assertEquals(new Complex(5, -3), ComplexCalculator.add(a, b));
    }


    @org.junit.jupiter.api.Test
    void itShouldAddTwoComplexVectors() throws ComplexException {
        assertEquals(new ComplexVector(Arrays.asList(new Complex(7, -7), new Complex(0, 1))), ComplexCalculator.add(vectorA, vectorB));
    }

    @org.junit.jupiter.api.Test
    void itShouldntAddTwoDifferentSizesVectors() {
        try {
            ComplexVector a = new ComplexVector(Collections.singletonList(new Complex(1, 2)));
            ComplexVector b = new ComplexVector(Arrays.asList(new Complex(1, 2), new Complex(2, 3)));
            ComplexCalculator.add(a, b);
            fail(FAIL_MESSAGE);
        } catch (ComplexException e) {
            assertSame(e.getMessage(), ComplexException.INVALID_OPERATION);
        }
    }

    @org.junit.jupiter.api.Test
    void itShouldAddTwoComplexMatrices() throws ComplexException {
        Complex b = new Complex(4, 5);
        Complex d = new Complex(1, 2);

        Complex f = new Complex(2, 3);
        Complex g = new Complex(4, 5);
        ComplexVector x = new ComplexVector(Arrays.asList(b, d));
        ComplexVector y = new ComplexVector(Arrays.asList(f, g));
        ComplexMatrix a = new ComplexMatrix(Arrays.asList(x, y));



        Complex r1 = new Complex(8, 10);
        Complex r2 = new Complex(2, 4);
        Complex r3 = new Complex(4, 6);
        Complex r4 = new Complex(8, 10);

        ComplexVector row1 = new ComplexVector(Arrays.asList(r1, r2));
        ComplexVector row2 = new ComplexVector(Arrays.asList(r3, r4));

        ComplexMatrix result = new ComplexMatrix(Arrays.asList(row1, row2));
        assertEquals(result, ComplexCalculator.add(a, a));
    }

    @org.junit.jupiter.api.Test
    void itShouldntAddInvalidMatrices() {
        Complex b = new Complex(4, 5);

        Complex f = new Complex(2, 3);
        Complex g = new Complex(4, 5);
        ComplexVector x = new ComplexVector(Collections.singletonList(b));
        ComplexVector y = new ComplexVector(Arrays.asList(f, g));
        ComplexMatrix a = new ComplexMatrix(Arrays.asList(x, y));

        try {
            ComplexCalculator.add(a, a);
            fail(FAIL_MESSAGE);
        } catch (ComplexException e) {
            assertSame(e.getMessage(), ComplexException.INVALID_MATRIX);
        }

    }

    @org.junit.jupiter.api.Test
    void itShouldntAddDifferentSizesMatrices() {
        Complex b = new Complex(4, 5);
        Complex d = new Complex(1, 2);

        Complex f = new Complex(2, 3);
        Complex g = new Complex(4, 5);
        ComplexVector x = new ComplexVector(Arrays.asList(b, d));

        ComplexMatrix m1 = new ComplexMatrix(Collections.singletonList(x));


        ComplexVector y = new ComplexVector(Arrays.asList(f, g));

        ComplexMatrix m2 = new ComplexMatrix(Arrays.asList(y, y));

        try {
            ComplexCalculator.add(m1, m2);
            fail(FAIL_MESSAGE);
        } catch (ComplexException e) {
            assertSame(e.getMessage(), ComplexException.INVALID_OPERATION);
        }

    }



    @org.junit.jupiter.api.Test
    void itShouldSubstractTwoComplexNumbers() {
        assertEquals(new Complex(3, -7), ComplexCalculator.substract(a, b));
    }

    @org.junit.jupiter.api.Test
    void itShouldSubstractTwoComplexVectors() throws ComplexException {
        assertEquals(new ComplexVector(Arrays.asList(new Complex(1, -3), new Complex(2, 3))), ComplexCalculator.substract(vectorA, vectorB));
    }

    @org.junit.jupiter.api.Test
    void itShouldntSubstractTwoDifferentSizesVectors() {
        try {
            ComplexVector a = new ComplexVector(Collections.singletonList(new Complex(1, 2)));
            ComplexVector b = new ComplexVector(Arrays.asList(new Complex(1, 2), new Complex(2, 3)));
            ComplexCalculator.substract(a, b);
            fail(FAIL_MESSAGE);
        } catch (ComplexException e) {
            assertSame(e.getMessage(), ComplexException.INVALID_OPERATION);
        }
    }

    @org.junit.jupiter.api.Test
    void itShouldSubstractTwoComplexMatrices() throws ComplexException {
        Complex b = new Complex(4, 5);
        Complex d = new Complex(1, 2);

        Complex f = new Complex(2, 3);
        Complex g = new Complex(4, 5);
        ComplexVector x = new ComplexVector(Arrays.asList(b, d));
        ComplexVector y = new ComplexVector(Arrays.asList(f, g));
        ComplexMatrix a = new ComplexMatrix(Arrays.asList(x, y));



        Complex r1 = new Complex(0, 0);

        ComplexVector row1 = new ComplexVector(Arrays.asList(r1, r1));
        ComplexVector row2 = new ComplexVector(Arrays.asList(r1, r1));

        ComplexMatrix result = new ComplexMatrix(Arrays.asList(row1, row2));
        assertEquals(result, ComplexCalculator.substract(a, a));
    }

    @org.junit.jupiter.api.Test
    void itShouldntSubstractInvalidMatrices() {
        Complex b = new Complex(4, 5);

        Complex f = new Complex(2, 3);
        Complex g = new Complex(4, 5);
        ComplexVector x = new ComplexVector(Collections.singletonList(b));
        ComplexVector y = new ComplexVector(Arrays.asList(f, g));
        ComplexMatrix a = new ComplexMatrix(Arrays.asList(x, y));

        try {
            ComplexCalculator.substract(a, a);
            fail(FAIL_MESSAGE);
        } catch (ComplexException e) {
            assertSame(e.getMessage(), ComplexException.INVALID_MATRIX);
        }

    }

    @org.junit.jupiter.api.Test
    void itShouldntSubstractDifferentSizesMatrices() {
        Complex b = new Complex(4, 5);
        Complex d = new Complex(1, 2);

        Complex f = new Complex(2, 3);
        Complex g = new Complex(4, 5);
        ComplexVector x = new ComplexVector(Arrays.asList(b, d));

        ComplexMatrix m1 = new ComplexMatrix(Collections.singletonList(x));


        ComplexVector y = new ComplexVector(Arrays.asList(f, g));

        ComplexMatrix m2 = new ComplexMatrix(Arrays.asList(y, y));

        try {
            ComplexCalculator.substract(m1, m2);
            fail(FAIL_MESSAGE);
        } catch (ComplexException e) {
            assertSame(e.getMessage(), ComplexException.INVALID_OPERATION);
        }

    }


    @org.junit.jupiter.api.Test
    void itShouldDivideTwoComplexNumbers() throws ComplexException {
        assertEquals(new Complex(-1.2, -2.6), ComplexCalculator.divide(a, b));
    }

    @org.junit.jupiter.api.Test
    void itShouldntDivideByZero() {
        try {
            ComplexCalculator.divide(a, new Complex(0, 0));
            fail(FAIL_MESSAGE);
        } catch (ComplexException e) {
            assertSame(e.getMessage(), ComplexException.DIVIDE_BY_ZERO);
        }
    }


    /*@org.junit.jupiter.api.Test
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
    }*/


    @org.junit.jupiter.api.Test
    void itShouldAddTwoVectors() {
        //TODO
    }

    @org.junit.jupiter.api.Test
    void itShouldntAddDifferentSizeVectors() {
        //TODO
    }


    @org.junit.jupiter.api.Test
    void itShouldSubstractTwoVectors() {
        //TODO
    }

    @org.junit.jupiter.api.Test
    void itShouldntSubstractDifferentSizeVectors() {
        //TODO
    }


    @org.junit.jupiter.api.Test
    void itShouldCalculateTheInverseVector() {
        //TODO
    }

    @org.junit.jupiter.api.Test
    void itShouldCalculateScalarMultiplication() {
        //TODO
    }
}