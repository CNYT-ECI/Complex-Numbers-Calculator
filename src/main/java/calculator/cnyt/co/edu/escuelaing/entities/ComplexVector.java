package calculator.cnyt.co.edu.escuelaing.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ComplexVector {
    private List<Complex> elements;

    public ComplexVector(){
        elements = new ArrayList<Complex>();
    }

    public ComplexVector(List<Complex> elements) {
        this.elements = elements;
    }

    public ComplexVector(int elementsNumber){
        elements = new ArrayList<>();
        for(int i = 0; i < elementsNumber; i++){
            elements.add(new Complex(0, 0));
        }
    }

    public List<Complex> getElements() {
        return elements;
    }


    public void setElements(List<Complex> elements) {
        this.elements = elements;
    }

    public Complex get(int index){
        return elements.get(index);
    }

    public void add(Complex element){
        this.elements.add(element);
    }

    public ComplexVector getConjugated(){
        ComplexVector conjugated = new ComplexVector();
        for(Complex c: this.elements){
            conjugated.add(c.getConjugated());
        }

        return conjugated;
    }

    public ComplexMatrix getTranspose(){
        ComplexMatrix transposed = new ComplexMatrix();
        for(Complex c: this.elements){
            transposed.add(new ComplexVector(Arrays.asList(c)));
        }
        return transposed;
    }

    public ComplexVector getInverse(){
        ComplexVector inverse = new ComplexVector();
        for (Complex c: this.elements){
            inverse.add(c.getInverse());
        }
        return inverse;
    }

    public int size(){
        return this.elements.size();
    }


    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        ComplexVector that = (ComplexVector) o;
        return Objects.equals(elements, that.elements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elements);
    }

    @Override
    public String toString() {
        return "ComplexVector{" +
                "elements=" + elements +
                '}';
    }

    public void setElement(int i, Complex element) {
        elements.set(i, element);
    }
}
