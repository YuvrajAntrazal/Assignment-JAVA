package New_Assignment.Utility;
import New_Assignment.Animal.Animal;
import New_Assignment.Animal.Bird.Eagle;
 import New_Assignment.Animal.Bird.Peacock;
import New_Assignment.Animal.Mammal.Cow;
 import New_Assignment.Animal.Mammal.Lion;
 import New_Assignment.Animal.Reptile.Crocodile;
import New_Assignment.Animal.Reptile.Snake;
public class Animal_Factory {
    public static Animal createAnimalObj(String type, String name, int age, double weight) {
        switch (type.trim().toLowerCase()) {
            case "lion":
                return new Lion(name, age, weight);
            case "cow":
                return new Cow(name, age, weight);
            case "crocodile":
                return new Crocodile(name, age, weight);
            case "snake":
                return new Snake(name, age, weight);
            case "peacock":
                return new Peacock(name, age, weight);
            case "eagle":
                return new Eagle(name, age, weight);
            default:
                System.out.println("Invalid Animal type: " + type);
                return null; 
        }
    }
}
