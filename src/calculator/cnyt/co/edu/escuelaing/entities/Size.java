package calculator.cnyt.co.edu.escuelaing.entities;

import java.util.Objects;

public class Size {
    private int rows;
    private int columns;

    public Size(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    @Override
    public String toString() {
        return "Size{" +
                "rows=" + rows +
                ", columns=" + columns +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        Size size = (Size) o;
        return rows == size.rows &&
                columns == size.columns;
    }

}
