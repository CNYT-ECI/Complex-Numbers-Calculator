package calculator.cnyt.co.edu.escuelaing.test;

import calculator.cnyt.co.edu.escuelaing.entities.Complex;
import calculator.cnyt.co.edu.escuelaing.entities.ComplexMatrix;
import calculator.cnyt.co.edu.escuelaing.entities.ComplexVector;
import calculator.cnyt.co.edu.escuelaing.services.ComplexCalculator;
import calculator.cnyt.co.edu.escuelaing.services.ComplexException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class ComplexCalculatorTest {
    private Complex c1;
    private Complex c2;
    private Complex c3;
    private Complex c4;
    private Complex c5;
    private Complex c6;

    private ComplexVector x;
    private ComplexVector y;

    private ComplexMatrix z;

    private ComplexMatrix matrixA;


    private ComplexVector x1;
    private ComplexVector y1;

    private ComplexMatrix z1;

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

        matrixA = new ComplexMatrix(Arrays.asList(vectorA, vectorB));


        c1 = new Complex(1, 2);
        c2 = new Complex(3, 4);
        c3 = new Complex(5, 6);
        c4 = new Complex(7, 8);
        c5 = new Complex(9, 10);
        c6 = new Complex(11, 12);

        x = new ComplexVector(Arrays.asList(c1, c2));
        y = new ComplexVector(Arrays.asList(c3, c4));

        z = new ComplexMatrix(Arrays.asList(x, y));

        x1 = new ComplexVector(Arrays.asList(c1, c2, c3));
        y1 = new ComplexVector(Arrays.asList(c4, c5, c6));

        z1 = new ComplexMatrix(Arrays.asList(x1, y1));
    }

    @Test
    void itShouldAddTwoComplexNumbers() {
        assertEquals(new Complex(5, -3), ComplexCalculator.add(a, b));
    }


    @Test
    void itShouldAddTwoComplexVectors() throws ComplexException {
        assertEquals(new ComplexVector(Arrays.asList(new Complex(7, -7), new Complex(0, 1))), ComplexCalculator.add(vectorA, vectorB));
    }

    @Test
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

    @Test
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

    @Test
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

    @Test
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


    @Test
    void itShouldSubstractTwoComplexNumbers() {
        assertEquals(new Complex(3, -7), ComplexCalculator.substract(a, b));
    }

    @Test
    void itShouldSubstractTwoComplexVectors() throws ComplexException {
        assertEquals(new ComplexVector(Arrays.asList(new Complex(1, -3), new Complex(2, 3))), ComplexCalculator.substract(vectorA, vectorB));
    }

    @Test
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

    @Test
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

    @Test
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

    @Test
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


    @Test
    void itShouldDivideTwoComplexNumbers() throws ComplexException {
        assertEquals(new Complex(-1.2, -2.6), ComplexCalculator.divide(a, b));
    }

    @Test
    void itShouldntDivideByZero() {
        try {
            ComplexCalculator.divide(a, new Complex(0, 0));
            fail(FAIL_MESSAGE);
        } catch (ComplexException e) {
            assertSame(e.getMessage(), ComplexException.DIVIDE_BY_ZERO);
        }
    }

    @Test
    void itShouldCalculateTheProductOfTwoComplexNumbers() {
        Complex a = new Complex(2, 3);
        Complex b = new Complex(-3, 5);
        assertEquals(new Complex(-21, 1), ComplexCalculator.product(a, b));
    }

    @Test
    void itShouldCalculateTheInnerProductOfTwoVectors() throws ComplexException {
        Complex b = new Complex(4, 5);
        Complex d = new Complex(1, 2);

        Complex f = new Complex(2, 3);
        Complex g = new Complex(4, 5);
        ComplexVector x = new ComplexVector(Arrays.asList(b, d));
        ComplexVector y = new ComplexVector(Arrays.asList(f, g));

        assertEquals(new Complex(-13, 35), ComplexCalculator.innerProduct(x, y));
    }


    @Test
    void itShouldntCalculateTheInnerProductOfDifferentLengthVectors() {
        Complex b = new Complex(4, 5);
        Complex d = new Complex(1, 2);

        Complex f = new Complex(2, 3);
        Complex g = new Complex(4, 5);
        ComplexVector x = new ComplexVector(Arrays.asList(b, d));
        ComplexVector y = new ComplexVector(Arrays.asList(f));

        try {
            ComplexCalculator.innerProduct(x, y);
            fail(FAIL_MESSAGE);
        } catch (ComplexException e) {
            assertSame(e.getMessage(), ComplexException.INVALID_OPERATION);
        }
    }

    @Test
    void itShouldCalculateTheCrossProductOfTwoMatrices() throws ComplexException {
        assertEquals(new ComplexMatrix(Arrays.asList(new ComplexVector(Arrays.asList(new Complex(-14, 56), new Complex(-18, 76), new Complex(-22, 96))), new ComplexVector(Arrays.asList(new Complex(-22, 128), new Complex(-26, 180), new Complex(-30, 232))))), ComplexCalculator.crossProduct(z, z1));
    }

    @Test
    void itShouldntCalculateTheCrossProductWhenTheOperationIsInvalid() throws  ComplexException{
        Complex b = new Complex(4, 5);
        Complex d = new Complex(1, 2);

        Complex f = new Complex(2, 3);
        Complex g = new Complex(4, 5);
        ComplexVector x = new ComplexVector(Arrays.asList(b, d));
        ComplexVector y = new ComplexVector(Arrays.asList(f, f));


        ComplexVector z1 = new ComplexVector(Arrays.asList(b, d));
        ComplexVector z2 = new ComplexVector(Arrays.asList(b, d));
        ComplexVector z3 = new ComplexVector(Arrays.asList(f, f));

        try {
            ComplexCalculator.crossProduct(new ComplexMatrix(Arrays.asList(x, y)), new ComplexMatrix(Arrays.asList(z1, z2, z3)));
            fail(FAIL_MESSAGE);
        } catch (ComplexException e) {
            assertSame(e.getMessage(), ComplexException.INVALID_OPERATION);
        }
    }


    @Test
    void itShouldntCalculateTheCrossProductWhenTheMatricesAreInvalid() throws  ComplexException{
        Complex b = new Complex(4, 5);
        Complex d = new Complex(1, 2);

        Complex f = new Complex(2, 3);
        Complex g = new Complex(4, 5);
        ComplexVector x = new ComplexVector(Arrays.asList(b, d));
        ComplexVector y = new ComplexVector(Arrays.asList(f));


        ComplexVector z1 = new ComplexVector(Arrays.asList(b, d));
        ComplexVector z2 = new ComplexVector(Arrays.asList(b, d));
        ComplexVector z3 = new ComplexVector(Arrays.asList(f, f));

        try {
            ComplexCalculator.crossProduct(new ComplexMatrix(Arrays.asList(x, y)), new ComplexMatrix(Arrays.asList(z1, z2)));
            fail(FAIL_MESSAGE);
        } catch (ComplexException e) {
            assertSame(e.getMessage(), ComplexException.INVALID_MATRIX);
        }
    }


    @Test
    void itShouldGetTheVectorProductByScalar(){
        assertEquals(new ComplexVector(Arrays.asList(new Complex(-9,-40), new Complex(14, 3))), ComplexCalculator.productByScalar(a, vectorA));
    }

    @Test
    void itShouldGetTheMatrixProductByScalar() throws ComplexException {
        assertEquals(new ComplexMatrix(Arrays.asList(new ComplexVector(Arrays.asList(new Complex(14, 3), new Complex(-3, 4))), new ComplexVector(Arrays.asList(new Complex(-1, 4), new Complex(1, -3))))), ComplexCalculator.productByScalar(b, matrixA));
    }

    @Test
    void itShouldntGetTheMatrixProductByScalarIfTheMatrixIsInvalid() {
        Complex b = new Complex(4, 5);
        Complex d = new Complex(1, 2);

        Complex f = new Complex(2, 3);
        ComplexVector x = new ComplexVector(Arrays.asList(b, d));
        ComplexVector y = new ComplexVector(Arrays.asList(f));

        try {
            ComplexCalculator.productByScalar(b, new ComplexMatrix(Arrays.asList(x, y)));
            fail(FAIL_MESSAGE);
        } catch (ComplexException e) {
            assertSame(e.getMessage(), ComplexException.INVALID_MATRIX);
        }
    }

    @Test
    void itShouldGetTheNormOfAVector() throws ComplexException {
        Complex f = new Complex(2, 3);
        ComplexVector y = new ComplexVector(Arrays.asList(f));

        assertEquals(new Complex(-5, 12, true), ComplexCalculator.vectorNorm(y));

    }

    @Test
    void itShouldGetTheDistanceBetweenTwoVectors() throws ComplexException {
        Complex f = new Complex(2, 3);
        ComplexVector y = new ComplexVector(Arrays.asList(f));

        assertEquals(new Complex(0, 0, true), ComplexCalculator.distance(y, y));
    }

    @Test
    void itShouldGetTheTensorProductOfTwoMatrices(){}

    @Test
    void itShouldntGetTheTensorProductOfInvalidMatrices(){}
}