package New_Assignment.Animal.Mammal;

import New_Assignment.Utility.EnumConstant;

/*
*********************************************************************************************************
 *  @Java Class Name :   Cow
 *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   18-03-2024
 *  @Description     :   This Cow class contains all the overrided methods of Animal Class.
********************************************************************************************************
*/
public class Cow extends Mammal {

    /*
    *********************************************************************************************************
     *  @Method Name     :   Cow
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Constructor of Cow Class.
     *  @param           :   String name, int age, double weight
    ********************************************************************************************************
    */
    public Cow(String name, int age, double weight) {
        super(name, age, weight);
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   getSound
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Overrided from Animal Class for providing Sound of the Animal.
     *  @return          :   Sound of Cow
    ********************************************************************************************************
    */
    @Override
    public String getSound() {
        return "Cow Booooo...";
    }

     /*
    *********************************************************************************************************
     *  @Method Name     :   getSpeciesType
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Overrided from Animal Class for providing SpeciesType of the Animal.
     *  @return          :   AnimalSpecies.
    ********************************************************************************************************
    */
    @Override
    public EnumConstant.AnimalSpecies getSpeciesType() {
        return EnumConstant.AnimalSpecies.MAMMAL;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   getCageType
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Overrided from Animal Class for providing CageType of the Animal.
     *  @return          :   CageType.
    ********************************************************************************************************
    */
    @Override
    public EnumConstant.CageType getCageType() {
        return EnumConstant.CageType.COW;
    }
}