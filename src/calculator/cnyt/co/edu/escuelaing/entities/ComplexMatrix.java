package calculator.cnyt.co.edu.escuelaing.entities;

import java.util.ArrayList;
import java.util.List;

public class ComplexMatrix {
    private List<ComplexVector> elements;

    public ComplexMatrix(){
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

    public ComplexVector getElement(int index){
        return this.elements.get(index);
    }

    public void addElement(ComplexVector element){
        this.elements.add(element);
    }

    public int getColumnsNumber() {
        if(this.elements.size() > 0){
            return getElement(0).size();
        }
        else{
            return 0;
        }
    }

    public int getRowsNumber(){
        return this.elements.size();
    }

    public ComplexMatrix getTranspose() {
        ComplexMatrix result = new ComplexMatrix();
        for(int i = 0; i < getColumnsNumber(); i++){
            result.addElement(new ComplexVector());
            for(int j = 0; j < getRowsNumber(); j++){
                result.getElement(i).addElement(getElement(j).getElement(i));
            }
        }
        return result;
    }
}
