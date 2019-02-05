package calculator.cnyt.co.edu.escuelaing.test;

import calculator.cnyt.co.edu.escuelaing.entities.Complex;
import calculator.cnyt.co.edu.escuelaing.entities.ComplexMatrix;
import calculator.cnyt.co.edu.escuelaing.entities.ComplexVector;
import calculator.cnyt.co.edu.escuelaing.entities.Size;
import calculator.cnyt.co.edu.escuelaing.services.ComplexCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ComplexMatrixTest {

    private Complex a;
    private Complex b;
    private Complex c;
    private Complex d;

    private ComplexVector x;
    private ComplexVector y;

    private ComplexVector xT;
    private ComplexVector yT;


    private ComplexMatrix z;

    public ComplexMatrixTest(){
        a = new Complex(1, 2);
        b = new Complex(3, 4);
        c = new Complex(5, 6);
        d = new Complex(7, 8);

        x = new ComplexVector(Arrays.asList(a, b));
        y = new ComplexVector(Arrays.asList(c, d));


        xT = new ComplexVector(Arrays.asList(a, c));
        yT = new ComplexVector(Arrays.asList(b, d));

        z = new ComplexMatrix(Arrays.asList(x, y));
    }

    @Test
    void itShouldCalculateTheSizeOfItsElements() {
        Assertions.assertEquals(new Size(2, 2), z.size());
    }

    @Test
    void itShouldGetTheTransposeMatrix() {
        assertEquals(new ComplexMatrix(Arrays.asList(xT, yT)), z.getTranspose());
    }
}