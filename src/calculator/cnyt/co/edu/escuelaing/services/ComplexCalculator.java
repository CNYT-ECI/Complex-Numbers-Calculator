package calculator.cnyt.co.edu.escuelaing.services;

import calculator.cnyt.co.edu.escuelaing.entities.Complex;

import java.util.ArrayList;
import java.util.List;

public class ComplexCalculator {

    public static Complex add(Complex first, Complex second) {
        Complex result = new Complex(first.getA() + second.getA(), first.getB() + second.getB());
        return result;
    }

    public static Complex substract(Complex first, Complex second) {
        Complex result = new Complex(first.getA() - second.getA(), first.getB() - second.getB());
        return result;
    }

    public static Complex division(Complex first, Complex second) {
        double firstResult = (first.getA() * second.getA() + first.getB() * second.getB()) / (Math.pow(second.getA(), 2) + (Math.pow(second.getB(), 2)));
        double secondResult = (second.getA() * first.getB() - first.getA() * second.getB()) / (Math.pow(second.getA(), 2) + (Math.pow(second.getB(), 2)));
        Complex result = new Complex(firstResult, secondResult);
        return result;
    }

    public static Complex product(Complex first, Complex second) {
        Complex result = new Complex(first.getA() * second.getA() - first.getB() * second.getB(), first.getA() * second.getB() + first.getB() * second.getA());
        return result;
    }


    public static List<Complex> addVectors(List<Complex> first, List<Complex> second) throws ComplexException {
        if (first.size() != second.size()) throw new ComplexException("This operation is invalid");
        List<Complex> resultVector = new ArrayList<>();
        for (int i = 0; i < first.size(); i++) {
            resultVector.add(ComplexCalculator.add(first.get(i), second.get(i)));
        }
        return resultVector;
    }


    public static List<Complex> substractVectors(List<Complex> first, List<Complex> second) throws ComplexException {
        if (first.size() != second.size()) throw new ComplexException("This operation is invalid");
        List<Complex> resultVector = new ArrayList<>();
        for (int i = 0; i < first.size(); i++) {
            resultVector.add(ComplexCalculator.substract(first.get(i), second.get(i)));
        }
        return resultVector;
    }

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

    public static List<List<Complex>> addMatrices(List<List<Complex>> firstMatrix, List<List<Complex>> secondMatrix) throws ComplexException {
        if (!isValid(firstMatrix)) throw new ComplexException("The matrix is invalid");
        List<List<Complex>> resultMatrix = new ArrayList<>();
        for (int i = 0; i < firstMatrix.size(); i++) {
            resultMatrix.add(ComplexCalculator.addVectors(firstMatrix.get(i), secondMatrix.get(i)));
        }
        return resultMatrix;
    }

    private static boolean isValid(List<List<Complex>> matrix) {
        boolean isValid = true;
        if (matrix.size() > 0) {
            int firsVectorSize = matrix.get(0).size();
            for (int i = 1; i < matrix.size() && isValid; i++) {
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





}
