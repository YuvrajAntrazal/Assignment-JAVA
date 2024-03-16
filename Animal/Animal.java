package New_Assignment.Animal;
import New_Assignment.DB_Repo.AnimalRepository;
import New_Assignment.Utility.EnumConstant;
public abstract class Animal {
    // private int idCounter = 1000;
    public int id;
    private String name;
    private int age;
    private double weight;

    public Animal(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }
    
    public void setId(int id){
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public abstract String getSound();

    public abstract EnumConstant.AnimalSpecies getSpeciesType(); 

    public abstract EnumConstant.CageType getCageType(); 
    

    //public abstract SpeciesType getSpeciesType();
}

