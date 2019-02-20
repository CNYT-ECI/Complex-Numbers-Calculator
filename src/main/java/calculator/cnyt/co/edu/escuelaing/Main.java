package calculator.cnyt.co.edu.escuelaing;

import calculator.cnyt.co.edu.escuelaing.entities.Complex;
import calculator.cnyt.co.edu.escuelaing.entities.ComplexMatrix;
import calculator.cnyt.co.edu.escuelaing.entities.ComplexVector;
import calculator.cnyt.co.edu.escuelaing.services.ComplexCalculator;

import java.util.Arrays;

public class Main {

    public static void main(String[] args){
        Complex a00 = new Complex(1, 2);
        Complex a01 = new Complex(3, 4);
        Complex a10 = new Complex(5, 6);
        Complex a11 = new Complex( 7, 8);


        Complex b00 = new Complex(9, 10);
        Complex b01 = new Complex(11, 12);
        Complex b02 = new Complex(13, 14);
        Complex b10 = new Complex(15, 16);
        Complex b11 = new Complex(17, 18);
        Complex b12 = new Complex(19, 20);
        Complex b20 = new Complex(21, 22);
        Complex b21 = new Complex(22, 23);
        Complex b22 = new Complex(24, 25);

        ComplexVector va1 = new ComplexVector(Arrays.asList(a00, a01));
        ComplexVector va2 = new ComplexVector(Arrays.asList(a10, a11));

        ComplexVector vb1 = new ComplexVector(Arrays.asList(b00, b01, b02));
        ComplexVector vb2 = new ComplexVector(Arrays.asList(b10, b11, b12));
        ComplexVector vb3 = new ComplexVector(Arrays.asList(b20, b21, b22));

        ComplexMatrix first = new ComplexMatrix(Arrays.asList(va1, va2));
        ComplexMatrix second = new ComplexMatrix(Arrays.asList(vb1, vb2, vb3));

        System.out.println(ComplexCalculator.tensorProduct(first, second));
    }
}
