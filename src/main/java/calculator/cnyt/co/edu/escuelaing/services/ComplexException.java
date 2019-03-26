package calculator.cnyt.co.edu.escuelaing.services;

public class ComplexException extends Exception {
    public static final String INVALID_OPERATION = "This operation is invalid";
    public static final String INVALID_MATRIX = "The matrix is invalid";
    public static final String DIVIDE_BY_ZERO = "It can't be possible to divide a number by zero";
    public static final String NON_HERMITIAN_MATRIX = "This matrix isn't hermitian";

    public ComplexException(String message) {
        super(message);
    }
}
