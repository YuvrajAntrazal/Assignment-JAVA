package New_Assignment.Animal.Mammal;

import New_Assignment.Animal.Animal;

/*
*********************************************************************************************************
 *  @Java Class Name :   Mammal
 *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   18-03-2024
 *  @Description     :   This is an Abstract Mammal Class which extends Abstract Animal Class.
********************************************************************************************************
*/
abstract class Mammal extends Animal {

    /*
    *********************************************************************************************************
     *  @Method Name     :   Mammal
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Constructor of Mammal Class.
     *  @param           :   String name, int age, double weight
    ********************************************************************************************************
    */
    public Mammal(String name, int age, double weight) {
        super(name, age, weight);
    }
}
