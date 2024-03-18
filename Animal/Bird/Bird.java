package New_Assignment.Animal.Bird;

import New_Assignment.Animal.Animal;
/*
*********************************************************************************************************
 *  @Java Class Name :   Bird
 *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   18-03-2024
 *  @Description     :   This is an Abstract Bird Class which extends Abstract Animal Class.
********************************************************************************************************
*/
abstract class Bird extends Animal {

    /*
    *********************************************************************************************************
     *  @Method Name     :   Bird
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Constructor of Bird Class.
     *  @param           :   String name, int age, double weight
    ********************************************************************************************************
    */
    public Bird(String name, int age, double weight) {
        super(name, age, weight);
    }
}
