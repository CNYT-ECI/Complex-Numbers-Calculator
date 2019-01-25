package calculator.cnyt.co.edu.escuelaing.entities;

public class PolarNumber {
    private double modulus;
    private double phase;


    public PolarNumber(double modulus, double phase) {
        this.modulus = modulus;
        this.phase = phase;
    }

    public double getModulus() {
        return modulus;
    }

    public void setModulus(double modulus) {
        this.modulus = modulus;
    }

    public double getPhase() {
        return phase;
    }

    public void setPhase(double phase) {
        this.phase = phase;
    }

    @Override
    public String toString() {
        return "(" +
                modulus +
                ", " + phase +
                ')';
    }
}
