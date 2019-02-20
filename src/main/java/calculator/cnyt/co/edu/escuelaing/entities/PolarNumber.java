package calculator.cnyt.co.edu.escuelaing.entities;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PolarNumber that = (PolarNumber) o;
        return Double.compare(that.modulus, modulus) == 0 &&
                Double.compare(that.phase, phase) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(modulus, phase);
    }

    @Override
    public String toString() {
        return "(" +
                modulus +
                ", " + phase +
                ')';
    }
}
