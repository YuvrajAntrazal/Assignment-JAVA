package New_Assignment.Animal.Reptile;

import New_Assignment.*;
import New_Assignment.Utility.EnumConstant;
import New_Assignment.Utility.EnumConstant.CageType;

public class Crocodile extends Reptile {
    public Crocodile(String name,int age,double weight){
        super(name,age,weight);
    }

    @Override
    public String getSound(){
        return "Crocodile bellow...";
    }

    @Override
    public  EnumConstant.AnimalSpecies getSpeciesType(){
        return EnumConstant.AnimalSpecies.REPTILE;
    }

    @Override
    public  EnumConstant.CageType getCageType(){
        return EnumConstant.CageType.CROCODILE;
    }
}

