package New_Assignment.Animal.Reptile;

import New_Assignment.Animal.Animal;

/*
*********************************************************************************************************
 *  @Java Class Name :   Reptile
 *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   18-03-2024
 *  @Description     :   This is an Abstract Reptile Class which extends Abstract Animal Class.
********************************************************************************************************
*/
abstract class Reptile extends Animal {

    /*
    *********************************************************************************************************
     *  @Method Name     :   Reptile
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Constructor of Reptile Class.
     *  @param           :   String name, int age, double weight
    ********************************************************************************************************
    */
    public Reptile(String name, int age, double weight) {
        super(name, age, weight);
    }
}