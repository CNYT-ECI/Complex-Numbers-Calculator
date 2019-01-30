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
        if(!(first.isValid() && second.isValid())) throw new ComplexException(ComplexException.INVALID_MATRIX);
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
        if(!(first.isValid() && second.isValid())) throw new ComplexException(ComplexException.INVALID_MATRIX);
        if (!(first.size().equals(second.size()))) throw new ComplexException(ComplexException.INVALID_OPERATION);
        ComplexMatrix resultMatrix = new ComplexMatrix();
        for (int i = 0; i < first.size().getRows(); i++) {
            resultMatrix.add(ComplexCalculator.substract(first.get(i), second.get(i)));
        }
        return resultMatrix;
    }


    public static Complex divide(Complex first, Complex second) throws ComplexException{
        if(second.getA() == 0 && second.getB() == 0) throw new ComplexException(ComplexException.DIVIDE_BY_ZERO);
        double firstResult = (first.getA() * second.getA() + first.getB() * second.getB()) / (Math.pow(second.getA(), 2) + (Math.pow(second.getB(), 2)));
        double secondResult = (second.getA() * first.getB() - first.getA() * second.getB()) / (Math.pow(second.getA(), 2) + (Math.pow(second.getB(), 2)));
        return new Complex(firstResult, secondResult);
    }


    public static Complex product(Complex first, Complex second) {
        return new Complex(first.getA() * second.getA() - first.getB() * second.getB(), first.getA() * second.getB() + first.getB() * second.getA());
    }

    



/*


    public static List<Complex> inverseVector(List<Complex> vector) {
        List<Complex> resultVector = new ArrayList<>();
        for (Complex c : vector) {
            resultVector.add(new Complex(-c.getA(), -c.getB()));
        }
        return resultVector;
    }

    public static List<Complex> vectorScalarProduct(Complex scalar, List<Complex> vector) {
        List<Complex> resultVector = new ArrayList<>();
        for (Complex c : vector) {
            resultVector.add(ComplexCalculator.product(scalar, c));
        }
        return resultVector;
    }



    private static boolean isValid(ComplexMatrix matrix) {
        boolean isValid = true;
        if (matrix.size().getRows() > 0) {
            int firsVectorSize = matrix.get(0).size();
            for (int i = 1; i < matrix.size().getRows() && isValid; i++) {
                if (matrix.get(i).size() != firsVectorSize) {
                    isValid = false;
                }
            }
        }
        return isValid;
    }

    public static List<List<Complex>> substractMatrices(List<List<Complex>> firstMatrix, List<List<Complex>> secondMatrix) throws ComplexException {
        if (!isValid(firstMatrix)) throw new ComplexException("The matrix is invalid");
        List<List<Complex>> resultMatrix = new ArrayList<>();
        for (int i = 0; i < firstMatrix.size(); i++) {
            resultMatrix.add(ComplexCalculator.substractVectors(firstMatrix.get(i), secondMatrix.get(i)));
        }
        return resultMatrix;
    }

    public static List<List<Complex>> inverseMatrix(List<List<Complex>> matrix) throws ComplexException {
        if (!isValid(matrix)) throw new ComplexException("The matrix is invalid");
        List<List<Complex>> resultMatrix = new ArrayList<>();
        for (List<Complex> vector: matrix){
            resultMatrix.add(ComplexCalculator.inverseVector(vector));
        }
        return resultMatrix;
    }

    public static List<List<Complex>> MatrixScalarProduct(Complex scalar, List<List<Complex>> matrix) throws ComplexException {
        if (!isValid(matrix)) throw new ComplexException("The matrix is invalid");
        List<List<Complex>> resultMatrix = new ArrayList<>();
        for(List<Complex> vector: matrix){
            resultMatrix.add(ComplexCalculator.vectorScalarProduct(scalar, vector));
        }
        return resultMatrix;
    }




    public static List<List<Complex>> matrixTranspose(List<List<Complex>> matrix) throws ComplexException {
        if (!isValid(matrix)) throw new ComplexException("The matrix is invalid");
        List<List<Complex>> resultMatrix = new ArrayList<>();
        for(int i = 0; i < matrix.size(); i++){
            resultMatrix.add(new ArrayList<>());
            for(int j = 0; j < matrix.get(i).size(); i++){
                resultMatrix.get(i).add(matrix.get(j).get(i));
            }
        }
        return resultMatrix;
    }


    public static List<List<Complex>> matrixConjugate(List<List<Complex>> matrix) throws ComplexException {
        if (!isValid(matrix)) throw new ComplexException("The matrix is invalid");
        List<List<Complex>> resultMatrix = new ArrayList<>();
        for(List<Complex> vector: matrix){
            resultMatrix.add(ComplexCalculator.vectorConjugate(vector));
        }
        return resultMatrix;
    }

    public static List<Complex> vectorConjugate(List<Complex> vector) {
        List<Complex> resultVector = new ArrayList<>();
        for(Complex c: vector){
            resultVector.add(c.getConjugated());
        }
        return resultVector;
    }

    public static List<List<Complex>> adjoint(List<List<Complex>> matrix) throws ComplexException {
        return ComplexCalculator.matrixTranspose(ComplexCalculator.matrixConjugate(matrix));
    }
*/
    /*public static ComplexMatrix matrixMultiplication(ComplexMatrix firstMatrix, ComplexMatrix secondMatrix) throws ComplexException {
        if(firstMatrix.getColumnsNumber() != secondMatrix.getRowsNumber()) throw new ComplexException("Invalid operation");
        ComplexMatrix resultMatrix = new ComplexMatrix();
        for(int i = 0; i < firstMatrix.getRowsNumber(); i++){
            resultMatrix.addElement(new ComplexVector());
            for(int j = 0; j < secondMatrix.getColumnsNumber(); i++){
                resultMatrix.getElement(i).addElement(ComplexCalculator.addAndMultiply(firstMatrix.getElement(i), secondMatrix.getTranspose().getElement(i)));
            }

        }
        return resultMatrix;
    }

    private static Complex addAndMultiply(ComplexVector firstVector, ComplexVector secondVector) {
        Complex result = new Complex(0,0);
        ComplexVector multiplicationVector = new ComplexVector();
        for(int i = 0; i < firstVector.size(); i++){
            multiplicationVector.addElement(ComplexCalculator.product(firstVector.getElement(i), secondVector.getElement(i)));
        }
        for(int k = 0; k < multiplicationVector.size(); k++){
            result = ComplexCalculator.add(result, multiplicationVector.getElement(k));
        }
        return result;
    }*/


}
