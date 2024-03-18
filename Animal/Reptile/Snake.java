package New_Assignment.Animal.Reptile;

import New_Assignment.Utility.EnumConstant;

/*
*********************************************************************************************************
 *  @Java Class Name :   Snake
 *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   18-03-2024
 *  @Description     :   This Snake class contains all the overrided methods of Animal Class.
********************************************************************************************************
*/
public class Snake extends Reptile {

    /*
    *********************************************************************************************************
     *  @Method Name     :   Snake
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Constructor of Snake Class.
     *  @param           :   String name, int age, double weight
    ********************************************************************************************************
    */
    public Snake(String name, int age, double weight) {
        super(name, age, weight);
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   getSound
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Overrided from Animal Class for providing Sound of the Animal.
     *  @return          :   Sound of Snake
    ********************************************************************************************************
    */
    @Override
    public String getSound() {
        return "Snake Shhhh...";
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
        return EnumConstant.AnimalSpecies.REPTILE;
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
        return EnumConstant.CageType.SNAKE;
    }
}
