package calculator.cnyt.co.edu.escuelaing.entities;

import java.util.ArrayList;
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

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        ComplexMatrix that = (ComplexMatrix) o;
        return Objects.equals(elements, that.elements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elements);
    }
}