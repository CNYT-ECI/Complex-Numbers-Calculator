package calculator.cnyt.co.edu.escuelaing.Entities;

public class Complex {
    private double a;
    private double b;

    public Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return a  + " + (" + b + ")i";
    }

    @Override
    public boolean equals(Object o) {
        Complex other = (Complex) o;
        boolean isEqual = (this.a == other.a && this.b == other.b)? true:false;
        return isEqual;
    }

}

