package New_Assignment.Animal.Bird;

import New_Assignment.Utility.EnumConstant;

/*
*********************************************************************************************************
 *  @Java Class Name :   Peacock
 *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   18-03-2024
 *  @Description     :   This Peacock class contains all the overrided methods of Animal Class.
********************************************************************************************************
*/

public class Peacock extends Bird {

    /*
    *********************************************************************************************************
     *  @Method Name     :   Peacock
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Constructor of Peacock Class.
     *  @param           :   String name, int age, double weight
    ********************************************************************************************************
    */
    public Peacock(String name, int age, double weight) {
        super(name, age, weight);
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   getSound
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Overrided from Animal Class for providing Sound of the Animal.
     *  @return          :   Sound of Peacock
    ********************************************************************************************************
    */
    @Override
    public String getSound() {
        return "Peacock MeoMeo...";
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
        return EnumConstant.AnimalSpecies.BIRD;
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
        return EnumConstant.CageType.PEACOCK;
    }
}
