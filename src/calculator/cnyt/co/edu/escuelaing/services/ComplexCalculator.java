package calculator.cnyt.co.edu.escuelaing.services;

import calculator.cnyt.co.edu.escuelaing.entities.Complex;
import calculator.cnyt.co.edu.escuelaing.entities.ComplexMatrix;
import calculator.cnyt.co.edu.escuelaing.entities.ComplexVector;

import java.util.ArrayList;
import java.util.List;

public class ComplexCalculator {

    public static Complex add(Complex first, Complex second) {
        return new Complex(first.getA() + second.getA(), first.getB() + second.getB());
    }

    public static ComplexVector add(ComplexVector first, ComplexVector second) throws ComplexException {
        if (first.size() != second.size()) throw new ComplexException(ComplexException.INVALID_OPERATION);
        ComplexVector resultVector = new ComplexVector();
        for (int i = 0; i < first.size(); i++) {
            resultVector.add(ComplexCalculator.add(first.get(i), second.get(i)));
        }
        return resultVector;
    }

    public static ComplexMatrix add(ComplexMatrix first, ComplexMatrix second) throws ComplexException {
        if (!(first.isValid() && second.isValid())) throw new ComplexException(ComplexException.INVALID_MATRIX);
        if (!(first.size().equals(second.size()))) throw new ComplexException(ComplexException.INVALID_OPERATION);
        ComplexMatrix resultMatrix = new ComplexMatrix();
        for (int i = 0; i < first.size().getRows(); i++) {
            resultMatrix.add(ComplexCalculator.add(first.get(i), second.get(i)));
        }
        return resultMatrix;
    }


    public static Complex substract(Complex first, Complex second) {
        return new Complex(first.getA() - second.getA(), first.getB() - second.getB());
    }

    public static ComplexVector substract(ComplexVector first, ComplexVector second) throws ComplexException {
        if (first.size() != second.size()) throw new ComplexException(ComplexException.INVALID_OPERATION);
        ComplexVector resultVector = new ComplexVector();
        for (int i = 0; i < first.size(); i++) {
            resultVector.add(ComplexCalculator.substract(first.get(i), second.get(i)));
        }
        return resultVector;
    }

    public static ComplexMatrix substract(ComplexMatrix first, ComplexMatrix second) throws ComplexException {
        if (!(first.isValid() && second.isValid())) throw new ComplexException(ComplexException.INVALID_MATRIX);
        if (!(first.size().equals(second.size()))) throw new ComplexException(ComplexException.INVALID_OPERATION);
        ComplexMatrix resultMatrix = new ComplexMatrix();
        for (int i = 0; i < first.size().getRows(); i++) {
            resultMatrix.add(ComplexCalculator.substract(first.get(i), second.get(i)));
        }
        return resultMatrix;
    }


    public static Complex divide(Complex first, Complex second) throws ComplexException {
        if (second.getA() == 0 && second.getB() == 0) throw new ComplexException(ComplexException.DIVIDE_BY_ZERO);
        double firstResult = (first.getA() * second.getA() + first.getB() * second.getB()) / (Math.pow(second.getA(), 2) + (Math.pow(second.getB(), 2)));
        double secondResult = (second.getA() * first.getB() - first.getA() * second.getB()) / (Math.pow(second.getA(), 2) + (Math.pow(second.getB(), 2)));
        return new Complex(firstResult, secondResult);
    }


    public static Complex product(Complex first, Complex second) {
        return new Complex(first.getA() * second.getA() - first.getB() * second.getB(), first.getA() * second.getB() + first.getB() * second.getA());
    }

    public static Complex innerProduct(ComplexVector first, ComplexVector second) throws ComplexException {
        if (first.size() != second.size()) throw new ComplexException(ComplexException.INVALID_OPERATION);
        Complex result = new Complex(0, 0);
        for (int i = 0; i < first.size(); i++) {
            Complex product = ComplexCalculator.product(first.get(i), second.get(i));
            result = ComplexCalculator.add(result, product);
        }
        return result;
    }


    public static ComplexMatrix crossProduct(ComplexMatrix first, ComplexMatrix second) throws ComplexException {
        ComplexMatrix secondTranspose = second.getTranspose();
        ComplexMatrix result = new ComplexMatrix();
        for (int i = 0; i < first.size().getRows(); i++) {
            result.add(new ComplexVector());
            for (int j = 0; j < secondTranspose.size().getRows(); j++) {
                result.get(i).add(ComplexCalculator.innerProduct(first.get(i), secondTranspose.get(j)));
            }
        }
        return result;
    }


    public static ComplexVector productByScalar(Complex scalar, ComplexVector vector) {
        ComplexVector result = new ComplexVector();

        for (int i = 0; i < vector.size(); i++) {
            result.add(ComplexCalculator.product(scalar, vector.get(i)));
        }

        return result;
    }

    public static ComplexMatrix productByScalar(Complex scalar, ComplexMatrix matrix) {
        ComplexMatrix result = new ComplexMatrix();

        for (int i = 0; i < matrix.size().getRows(); i++) {
            result.add(new ComplexVector());
            for (int j = 0; j < matrix.size().getColumns(); j++) {
                result.get(i).add(ComplexCalculator.product(scalar, matrix.get(i).get(j)));
            }
        }

        return result;
    }

    public static Complex vectorNorm (ComplexVector vector) throws ComplexException {
        return new Complex(ComplexCalculator.innerProduct(vector, vector).getA(), ComplexCalculator.innerProduct(vector, vector).getB(), true);
    }

    public static Complex distance (ComplexVector first, ComplexVector second) throws ComplexException {
        Complex operation = ComplexCalculator.innerProduct(ComplexCalculator.substract(first, second), ComplexCalculator.substract(first, second));
        return new Complex(operation.getA(), operation.getB(), true);
    }

    public static ComplexMatrix tensorProduct (ComplexMatrix first, ComplexMatrix second){
        ComplexMatrix result = new ComplexMatrix();
        /*for(int i = 0; i < first.size().getRows(); i++){
            for(int j = 0; j < second.size().getRows(); j++){
                result.add(new ComplexVector());
                result.get(i)
            }
        }*/
        return result
    }



}
