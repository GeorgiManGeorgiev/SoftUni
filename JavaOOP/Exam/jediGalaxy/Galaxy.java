package jediGalaxy;

public class Galaxy {
    private Field field;
    private JediMovement jediMovement;
    private SithMovement sithMovement;

    public Galaxy(Field field,JediMovement jediMovement,SithMovement sithMovement) {
        this.field = field;
        this.jediMovement = jediMovement;
        this.sithMovement = sithMovement;
    }

    public void moveSith(int row, int col) {
       this.sithMovement.move(row,col,this.field);

    }

    public long moveJedi(int row, int col) {
      return this.jediMovement.move(row,col,this.field);
    }
}
