package New_Assignment.Animal.Bird;

import New_Assignment.Utility.EnumConstant;

/*
*********************************************************************************************************
 *  @Java Class Name :   Eagle
 *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   18-03-2024
 *  @Description     :   This Eagle class contains all the overrided methods of Animal Class.
********************************************************************************************************
*/

public class Eagle extends Bird {

    /*
    *********************************************************************************************************
     *  @Method Name     :   Eagle
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Constructor of Eagle Class.
     *  @param           :   String name, int age, double weight
    ********************************************************************************************************
    */
    public Eagle(String name, int age, double weight) {
        super(name, age, weight);
    }

     /*
    *********************************************************************************************************
     *  @Method Name     :   getSound
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Overrided from Animal Class for providing Sound of the Animal.
     *  @return          :   Sound of Eagle
    ********************************************************************************************************
    */
    @Override
    public String getSound() {
        return "Eagle eeeeeeeeee...";
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
        return EnumConstant.CageType.EAGLE;
    }
}
