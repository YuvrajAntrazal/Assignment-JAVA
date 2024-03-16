package New_Assignment.Animal.Mammal;
import New_Assignment.Utility.EnumConstant;

public class Lion extends Mammal{
    public Lion(String name,int age,double weight){
        super(name,age,weight);
    }

    @Override
    public String getSound(){
        return "Lion Roars...";
    }

    @Override
    public  EnumConstant.AnimalSpecies getSpeciesType(){
        return EnumConstant.AnimalSpecies.MAMMAL;
    }

    @Override
    public  EnumConstant.CageType getCageType(){
        return EnumConstant.CageType.LION;
    }

}