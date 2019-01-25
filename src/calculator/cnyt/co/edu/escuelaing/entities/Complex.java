package calculator.cnyt.co.edu.escuelaing.entities;

public class Complex {
    private double a;
    private double b;

    public Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Complex(PolarNumber polar){
        this.a = polar.getModulus() * Math.sin(polar.getPhase());
        this.b = polar.getModulus() * Math.cos(polar.getPhase());
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

    public Double phase(){
        return Math.atan(this.b / this.a);
    }

    public Double modulus(){
        return Math.sqrt(Math.pow(this.a, 2) + Math.pow(this.b, 2));
    }

    public PolarNumber getAsPolar(){
        return new PolarNumber(modulus(), phase());
    }

    public Complex getConjugated(){
        return new Complex(this.a, -1 * this.b);
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

