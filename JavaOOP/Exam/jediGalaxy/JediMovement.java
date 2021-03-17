package jediGalaxy;

public class JediMovement {
    public long move(int row, int col, Field field) {
        long starPowerCollected = 0;
        while ( row >= 0 && col < field.getColLength(1)) {
            if (field.isInBound(row, col)) {
                starPowerCollected += field.gerValue(row,col);
            }

            row--;
            col++;
        }
        return starPowerCollected;
    }
}
