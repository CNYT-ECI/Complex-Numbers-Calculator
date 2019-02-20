package test.java;

import calculator.cnyt.co.edu.escuelaing.entities.Complex;
import calculator.cnyt.co.edu.escuelaing.entities.ComplexMatrix;
import calculator.cnyt.co.edu.escuelaing.entities.ComplexVector;
import calculator.cnyt.co.edu.escuelaing.entities.Size;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ComplexVectorTest {

    ComplexVector v;

    public ComplexVectorTest(){
        v = new ComplexVector(Arrays.asList(new Complex(1, 2),new Complex(3, 4)));
    }

    @Test
    void itShouldGetTheConjugatedOfAVector() {
        assertEquals(new ComplexVector(Arrays.asList(new Complex(1, -2),new Complex(3, -4))), v.getConjugated());
    }

    @Test
    void getTranspose() {
        assertEquals(new ComplexMatrix(Arrays.asList(new ComplexVector(Arrays.asList(new Complex(1,2))), new ComplexVector(Arrays.asList(new Complex(3, 4))))), v.getTranspose());
    }

    @Test
    void itShouldGetTheInverseOfAVector() {
        assertEquals(new ComplexVector(Arrays.asList(new Complex(-1, -2),new Complex(-3, -4))), v.getInverse());
    }

    @Test
    void itShouldGetTheSizeOfAVector() {
        assertEquals(2, v.size());
    }
}