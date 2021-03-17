package C_JavaAdvanced.JavaAdv.DefiningClasses.CatLady;

public class Siamese extends Cat {

    public Siamese(String name,double specialField){
        super(name,specialField);
    }

    @Override
    public String toString() {
        return "Siamese " + super.toString();
    }
}
