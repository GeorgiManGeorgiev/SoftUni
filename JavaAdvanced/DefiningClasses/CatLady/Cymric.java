package C_JavaAdvanced.JavaAdv.DefiningClasses.CatLady;

public class Cymric extends Cat {

    public Cymric(String name,double specialField){
        super(name,specialField);
    }


    @Override
    public String toString() {
        return "Cymric " + super.toString();
    }
}
