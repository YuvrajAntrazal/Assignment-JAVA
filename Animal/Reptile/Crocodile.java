package New_Assignment.Animal.Reptile;

import New_Assignment.Utility.EnumConstant;

/*
*********************************************************************************************************
 *  @Java Class Name :   Crocodile
 *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   18-03-2024
 *  @Description     :   This Crocodile class contains all the overrided methods of Animal Class.
********************************************************************************************************
*/
public class Crocodile extends Reptile {

    /*
    *********************************************************************************************************
     *  @Method Name     :   Crocodile
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Constructor of Crocodile Class.
     *  @param           :   String name, int age, double weight
    ********************************************************************************************************
    */
    public Crocodile(String name, int age, double weight) {
        super(name, age, weight);
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   getSound
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Overrided from Animal Class for providing Sound of the Animal.
     *  @return          :   Sound of Crocodile
    ********************************************************************************************************
    */
    @Override
    public String getSound() {
        return "Crocodile bellow...";
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
        return EnumConstant.CageType.CROCODILE;
    }
}
