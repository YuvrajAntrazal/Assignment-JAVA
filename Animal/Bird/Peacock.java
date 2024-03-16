package New_Assignment.Animal.Bird;

import New_Assignment.Utility.EnumConstant;

public class Peacock extends Bird{
    public Peacock(String name,int age,double weight){
        super(name,age,weight);
    }

    @Override
    public String getSound(){
        return "Peacock MeoMeo...";
    }

    @Override
    public  EnumConstant.AnimalSpecies getSpeciesType(){
        return EnumConstant.AnimalSpecies.BIRD;
    }

    @Override
    public  EnumConstant.CageType getCageType(){
        return EnumConstant.CageType.PEACOCK;
    }
}
