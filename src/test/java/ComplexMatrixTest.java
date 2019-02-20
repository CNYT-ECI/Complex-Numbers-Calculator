package test.java;

import calculator.cnyt.co.edu.escuelaing.entities.Complex;
import calculator.cnyt.co.edu.escuelaing.entities.ComplexMatrix;
import calculator.cnyt.co.edu.escuelaing.entities.ComplexVector;
import calculator.cnyt.co.edu.escuelaing.entities.Size;
import calculator.cnyt.co.edu.escuelaing.services.ComplexCalculator;
import calculator.cnyt.co.edu.escuelaing.services.ComplexException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


class ComplexMatrixTest {

    private Complex a;
    private Complex b;
    private Complex c;
    private Complex d;


    private Complex e;
    private Complex f;
    private Complex g;
    private Complex h;

    private Complex i;
    private Complex j;
    private Complex k;
    private Complex l;


    private ComplexVector x;
    private ComplexVector y;

    private ComplexVector xT;
    private ComplexVector yT;


    private ComplexVector xC;
    private ComplexVector yC;

    private ComplexVector xI;
    private ComplexVector yI;

    private ComplexMatrix herm;
    private ComplexMatrix unit;


    private ComplexMatrix z;

    public ComplexMatrixTest(){
        a = new Complex(1, 2);
        b = new Complex(3, 4);
        c = new Complex(5, 6);
        d = new Complex(7, 8);


        Complex e1 = new Complex(7, 0);
        Complex e2 = new Complex(6, 5);

        Complex e3 = new Complex(6, -5);
        Complex e4 = new Complex(-3, 0);

        e = a.getConjugated();
        f = b.getConjugated();
        g = c.getConjugated();
        h = d.getConjugated();


        i = a.getInverse();
        j = b.getInverse();
        k = c.getInverse();
        l = d.getInverse();

        x = new ComplexVector(Arrays.asList(a, b));
        y = new ComplexVector(Arrays.asList(c, d));


        xT = new ComplexVector(Arrays.asList(a, c));
        yT = new ComplexVector(Arrays.asList(b, d));


        xC = new ComplexVector(Arrays.asList(e, f));
        yC = new ComplexVector(Arrays.asList(g, h));


        xI = new ComplexVector(Arrays.asList(i, j));
        yI = new ComplexVector(Arrays.asList(k, l));

        ComplexVector xH = new ComplexVector(Arrays.asList(e1, e2));
        ComplexVector yH = new ComplexVector(Arrays.asList(e3, e4));

        herm = new ComplexMatrix(Arrays.asList(xH,yH));

        z = new ComplexMatrix(Arrays.asList(x, y));




        Complex u00 = new Complex(0.5,0.5);
        Complex u01 = new Complex(0,1/Math.sqrt(3));
        Complex u02 = new Complex(3/(2*Math.sqrt(15)),1/(2*Math.sqrt(15)));
        Complex u10 = new Complex(-0.5, 0);
        Complex u11 = new Complex(1/Math.sqrt(3), 0);
        Complex u12 = new Complex(4/(2*Math.sqrt(15)), 3/(2*Math.sqrt(15)));
        Complex u20 = new Complex(0.5, 0);
        Complex u21 = new Complex(0, -1/Math.sqrt(3));
        Complex u22 = new Complex(0, 5/(2*Math.sqrt(15)));


        ComplexVector xU = new ComplexVector(Arrays.asList(u00, u01, u02));
        ComplexVector yU = new ComplexVector(Arrays.asList(u10, u11, u12));
        ComplexVector zU = new ComplexVector(Arrays.asList(u20, u21, u22));

        unit = new ComplexMatrix(Arrays.asList(xU, yU, zU));
    }

    @Test
    void itShouldCalculateTheSizeOfItsElements() {
        assertEquals(new Size(2, 2), z.size());
    }

    @Test
    void itShouldGetTheTransposeMatrix() {
        assertEquals(new ComplexMatrix(Arrays.asList(xT, yT)), z.getTranspose());
    }

    @Test
    void itShouldGetTheAdjointOfTheMatrix(){
        assertEquals(z.getConjugated().getTranspose(), z.adjoint());
    }

    @Test
    void itShouldGetTheConjugatedMatrix(){
        assertEquals(new ComplexMatrix(Arrays.asList(xC, yC)), z.getConjugated());
    }

    @Test
    void itShouldGetTheInverseMatrix(){
        assertEquals(new ComplexMatrix(Arrays.asList(xI, yI)), z.getInverse());
    }


    @Test
    void itShouldKnowIfAMatrixIsHermitian(){
        assertTrue(herm.isHermitian());
    }

    @Test
    void itShouldKnowIfAMatrixIsNotHermitian(){
        assertFalse(z.isHermitian());
    }


    @Test
    void itShouldKnowIfAMatrixIsUnitary() throws ComplexException {
        assertTrue(unit.isUnitary());
    }

    @Test
    void itShouldKnowIfAMatrixIsNotUnitary() throws ComplexException {
        assertFalse(z.isUnitary());
    }

    @Test
    void itShouldGetTheIdentityOfAGivenSizeMatrix(){
        assertEquals(new ComplexMatrix(Arrays.asList(new ComplexVector(Arrays.asList(new Complex(1, 0), new Complex(0, 0))), new ComplexVector(Arrays.asList(new Complex(0, 0), new Complex(1, 0))))), ComplexMatrix.identity(2));
    }


}