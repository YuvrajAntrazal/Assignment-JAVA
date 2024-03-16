package New_Assignment.Animal.Mammal;

import New_Assignment.Utility.EnumConstant;

public class Cow extends Mammal{
    public Cow(String name,int age,double weight){
        super(name,age,weight);
    }

    @Override
    public String getSound(){
        return "Cow Booooo...";
    }

    @Override
    public  EnumConstant.AnimalSpecies getSpeciesType(){
        return EnumConstant.AnimalSpecies.MAMMAL;
    }

    @Override
    public  EnumConstant.CageType getCageType(){
        return EnumConstant.CageType.COW;
    }
}