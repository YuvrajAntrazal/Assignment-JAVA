package New_Assignment.Animal;

import New_Assignment.Utility.EnumConstant;

/*
*********************************************************************************************************
 *  @Java Class Name :   Animal
 *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   18-03-2024
 *  @Description     :   This is an Abstract Animal Class which is the Parent class of - Mammal,Reptile,Bird.
********************************************************************************************************
*/
public abstract class Animal {
    public int id;
    private String name;
    private int age;
    private double weight;

    /*
    *********************************************************************************************************
     *  @Method Name     :   Animal
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Constructor of Animal Class.
     *  @param           :   String name, int age, double weight
    ********************************************************************************************************
    */
    public Animal(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

     /*
    *********************************************************************************************************
     *  @Method Name     :   setId
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Used for Setting the ID of the Animal.
    ********************************************************************************************************
    */
    public void setId(int id) {
        this.id = id;
    }

     /*
    *********************************************************************************************************
     *  @Method Name     :   getId
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Used for Getting up the ID of the Animal.
     *  @return          :   ID
    ********************************************************************************************************
    */
    public int getId() {
        return this.id;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   getName
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Used for Getting up the Name of the Animal.
     *  @return          :   Name
    ********************************************************************************************************
    */
    public String getName() {
        return name;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   getAge
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Used for Getting up the Age of the Animal.
     *  @return          :   Age
    ********************************************************************************************************
    */
    public int getAge() {
        return age;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   getWeight
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Used for Getting up the Weight of the Animal.
     *  @return          :   Weight
    ********************************************************************************************************
    */
    public double getWeight() {
        return weight;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   setName
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Used for Setting the Setting of the Animal.
    ********************************************************************************************************
    */
    public void setName(String name) {
        this.name = name;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   setAge
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Used for Setting the Age of the Animal.
    ********************************************************************************************************
    */
    public void setAge(int age) {
        this.age = age;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   setWeight
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Used for Setting the Weight of the Animal.
    ********************************************************************************************************
    */
    public void setWeight(double weight) {
        this.weight = weight;
    }

     /*
    *********************************************************************************************************
     *  @Method Name     :   getSound
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Abstract Method Which is Overrided by its Child Classes for the Sound.
    ********************************************************************************************************
    */
    public abstract String getSound();

    /*
    *********************************************************************************************************
     *  @Method Name     :   getSpeciesType
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Abstract Method Which is Overrided by its Child Classes for the SpeciesType.
    ********************************************************************************************************
    */
    public abstract EnumConstant.AnimalSpecies getSpeciesType();

    /*
    *********************************************************************************************************
     *  @Method Name     :   getCageType
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Abstract Method Which is Overrided by its Child Classes for the CageType.
    ********************************************************************************************************
    */
    public abstract EnumConstant.CageType getCageType();

}
