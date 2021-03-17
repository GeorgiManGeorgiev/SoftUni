package jediGalaxy;

public class SithMovement {
    public void move(int row, int col, Field field) {
        while (row >= 0 && col >= 0) {
            if (field.isInBound(row, col)) {
                field.setValue( row,col,0);
            }
            row--;
            col--;
        }
    }
}
