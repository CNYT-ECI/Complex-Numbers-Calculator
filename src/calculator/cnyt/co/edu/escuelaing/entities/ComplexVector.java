package calculator.cnyt.co.edu.escuelaing.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ComplexVector {
    private List<Complex> elements;

    public ComplexVector(){
        elements = new ArrayList<>();
    }

    public ComplexVector(List<Complex> elements) {
        this.elements = elements;
    }

    public List<Complex> getElements() {
        return elements;
    }


    public void setElements(List<Complex> elements) {
        this.elements = elements;
    }

    public Complex getElement(int index){
        return elements.get(index);
    }

    public void addElement(Complex element){
        this.elements.add(element);
    }

    public ComplexVector getConjugated(){
        ComplexVector conjugated = new ComplexVector();
        for(Complex c: this.elements){
            conjugated.addElement(c.getConjugated());
        }

        return conjugated;
    }

    public ComplexMatrix getTranspose(){
        ComplexMatrix transposed = new ComplexMatrix();
        for(Complex c: this.elements){
            transposed.addElement(new ComplexVector(Arrays.asList(c)));
        }
        return transposed;
    }

    public ComplexVector getInverse(){
        ComplexVector inverse = new ComplexVector();
        for (Complex c: this.elements){
            inverse.addElement(c.getInverse());
        }
        return inverse;
    }

    public int size(){
        return this.elements.size();
    }


}
