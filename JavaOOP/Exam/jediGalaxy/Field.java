package jediGalaxy;

public class Field {
    private int[][] matrix;

    public Field(int rows, int cols) {
        this.matrix = new int[rows][cols];
        this.fillValues();
    }

    private void fillValues() {
        int value = 0;
        for (int r = 0; r < this.matrix.length; r++) {
            for (int c = 0; c < this.matrix[r].length; c++) {
                this.matrix[r][c] = value++;
            }
        }
    }

    public boolean isInBound(int row, int col) {
        return row >= 0 && row < this.matrix.length && col >= 0 && col <this.matrix[row].length;
    }

    public void setValue(int row, int col, int newValue) {
        this.matrix[row][col]= newValue;
    }

    public int getColLength(int row) {
        return this.matrix[row].length;
    }

    public int gerValue(int row, int col) {
        return this.matrix[row][col];
    }
}
