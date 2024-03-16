package New_Assignment.Animal.Bird;
import New_Assignment.Utility.EnumConstant;
public class Eagle extends Bird {
    public Eagle(String name,int age,double weight){
       super(name,age,weight);
   }

   @Override
   public String getSound(){
       return "Eagle eeeeeeeeee...";
   }

   @Override
   public  EnumConstant.AnimalSpecies getSpeciesType(){
       return EnumConstant.AnimalSpecies.BIRD;
   }

   @Override
   public  EnumConstant.CageType getCageType(){
       return EnumConstant.CageType.EAGLE;
   }
}
