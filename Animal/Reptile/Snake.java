package New_Assignment.Animal.Reptile;

import New_Assignment.Utility.EnumConstant;

public class Snake extends Reptile {
    public Snake(String name,int age,double weight){
        super(name,age,weight);
    }

    @Override
    public String getSound(){
        return "Snake Shhhh...";
    }

    @Override
    public  EnumConstant.AnimalSpecies getSpeciesType(){
        return EnumConstant.AnimalSpecies.REPTILE;
    }

    @Override
    public  EnumConstant.CageType getCageType(){
        return EnumConstant.CageType.SNAKE;
    }
}

