package calculator.cnyt.co.edu.escuelaing.entities;

import calculator.cnyt.co.edu.escuelaing.services.ComplexCalculator;
import calculator.cnyt.co.edu.escuelaing.services.ComplexException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ComplexMatrix {
    private List<ComplexVector> elements;

    public ComplexMatrix() {
        elements = new ArrayList<>();
    }

    public ComplexMatrix(List<ComplexVector> elements) {
        this.elements = elements;
    }

    public ComplexMatrix(int rows, int columns) {
        elements = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            elements.add(new ComplexVector(columns));
        }
    }

    public List<ComplexVector> getElements() {
        return elements;
    }

    public void setElements(List<ComplexVector> elements) {
        this.elements = elements;
    }

    public ComplexVector get(int index) {
        return this.elements.get(index);
    }

    public void add(ComplexVector element) {
        this.elements.add(element);
    }

    private int getColumnsNumber() {
        if (this.elements.size() > 0) {
            return get(0).size();
        } else {
            return 0;
        }
    }

    public Size size() {
        return new Size(elements.size(), getColumnsNumber());
    }

    public boolean isValid() {
        boolean isValid = true;
        if (this.size().getRows() > 0) {
            int firsVectorSize = this.get(0).size();
            for (int i = 1; i < this.size().getRows() && isValid; i++) {
                if (this.get(i).size() != firsVectorSize) {
                    isValid = false;
                }
            }
        }
        return isValid;
    }

    public ComplexMatrix adjoint() {
        return getConjugated().getTranspose();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ComplexMatrix that = (ComplexMatrix) o;
        return Objects.equals(elements, that.elements);
    }

    @Override
    public int hashCode() {

        return Objects.hash(elements);
    }

    public ComplexMatrix getTranspose() {
        ComplexMatrix transpose = new ComplexMatrix();
        for (int i = 0; i < this.size().getColumns(); i++) {
            transpose.add(new ComplexVector());
            for (int j = 0; j < this.size().getRows(); j++) {
                transpose.get(i).add(this.get(j).get(i));
            }
        }
        return transpose;
    }

    public ComplexMatrix getConjugated() {
        ComplexMatrix conjugated = new ComplexMatrix();
        for (int i = 0; i < size().getRows(); i++) {
            conjugated.add(new ComplexVector());
            for (int j = 0; j < size().getRows(); j++) {
                conjugated.get(i).add(get(i).get(j).getConjugated());
            }
        }
        return conjugated;
    }

    public ComplexMatrix getInverse() {
        ComplexMatrix inverse = new ComplexMatrix();
        for (int i = 0; i < size().getRows(); i++) {
            inverse.add(new ComplexVector());
            for (int j = 0; j < size().getRows(); j++) {
                inverse.get(i).add(get(i).get(j).getInverse());
            }
        }
        return inverse;
    }

    public boolean isHermitian() {
        return convertToInt(this).equals(convertToInt(this.adjoint()));
    }

    public boolean isUnitary() throws ComplexException {
        ComplexMatrix a = convertToInt(ComplexCalculator.crossProduct(this, adjoint()));
        ComplexMatrix b = convertToInt(ComplexCalculator.crossProduct(adjoint(), this));
        // System.out.println(a.equals(identity(size().getColumns())));
        // System.out.println(b);
        return a.equals(b) && a.equals(identity(size().getColumns()));
    }

    private ComplexMatrix convertToInt(ComplexMatrix complexMatrix) {
        ComplexMatrix result = new ComplexMatrix();

        for (int i = 0; i < complexMatrix.size().getRows(); i++) {
            result.add(new ComplexVector());
            for (int j = 0; j < complexMatrix.size().getColumns(); j++) {
                Complex element = complexMatrix.get(i).get(j);
                result.get(i).add(new Complex(Math.round(element.getA()), Math.round(element.getB())));
            }
        }

        return result;
    }

    public static ComplexMatrix identity(int n) {
        ComplexMatrix result = new ComplexMatrix();
        for (int i = 0; i < n; i++) {
            result.add(new ComplexVector());
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    result.get(i).add(new Complex(1, 0));
                } else {
                    result.get(i).add(new Complex(0, 0));
                }

            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "ComplexMatrix{" + "elements=" + elements + '}';
    }

    public void set(int i, int j, Complex element) {
        elements.get(i).setElement(j, element);
    }

    public static ComplexVector toVector(ComplexMatrix matrix) {
        ComplexVector vector = new ComplexVector();
        for (int i = 0; i < matrix.size().getRows(); i++) {
            vector.add(matrix.get(i).get(0));
        }

        return vector;

    }
}