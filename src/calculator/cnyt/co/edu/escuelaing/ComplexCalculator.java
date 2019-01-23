package calculator.cnyt.co.edu.escuelaing;

import calculator.cnyt.co.edu.escuelaing.Entities.Complex;

public class ComplexCalculator {

    public Complex add (Complex first, Complex second){
        Complex result = new Complex(first.getA() + second.getA(), first.getB() + second.getB());
        return result;
    }

    public Complex substract (Complex first, Complex second){
        Complex result = new Complex(first.getA() - second.getA(), first.getB() - second.getB());
        return result;
    }

    public Complex division (Complex first, Complex second){
        double firstResult = (first.getA() * first.getB() + second.getA() * second.getB()) / (Math.pow(first.getB(), 2) + (Math.pow(second.getB(), 2)));
        double secondResult = (first.getB() * second.getA() - first.getB() * second.getB()) / (Math.pow(first.getB(), 2) + (Math.pow(second.getB(), 2)));
        Complex result = new Complex(firstResult, secondResult);
        return result;
    }

    public Complex product (Complex first, Complex second){
        Complex result = new Complex(first.getA() * second.getA() - first.getB() * second.getB(), first.getA() * second.getB() + first.getB() * second.getA());
        return result;
    }
}
