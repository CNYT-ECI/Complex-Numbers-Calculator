package calculator.cnyt.co.edu.escuelaing.services;

import calculator.cnyt.co.edu.escuelaing.entities.Complex;

public class ComplexCalculator {

    public static Complex add (Complex first, Complex second){
        Complex result = new Complex(first.getA() + second.getA(), first.getB() + second.getB());
        return result;
    }

    public static Complex substract (Complex first, Complex second){
        Complex result = new Complex(first.getA() - second.getA(), first.getB() - second.getB());
        return result;
    }

    public static Complex division (Complex first, Complex second){
        double firstResult = (first.getA() * second.getA() + first.getB() * second.getB()) / (Math.pow(second.getA(), 2) + (Math.pow(second.getB(), 2)));
        double secondResult = (second.getA() * first.getB() - first.getA() * second.getB()) / (Math.pow(second.getA(), 2) + (Math.pow(second.getB(), 2)));
        Complex result = new Complex(firstResult, secondResult);
        return result;
    }

    public static Complex product (Complex first, Complex second){
        Complex result = new Complex(first.getA() * second.getA() - first.getB() * second.getB(), first.getA() * second.getB() + first.getB() * second.getA());
        return result;
    }
}
