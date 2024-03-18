package New_Assignment.Services;

import java.util.*;
import New_Assignment.DB_Repo.AnimalRepository;
import New_Assignment.DB_Repo.CageRepository;
import New_Assignment.Utility.EnumConstant;
import New_Assignment.Utility.EnumConstant.AnimalSpecies;
import New_Assignment.Utility.EnumConstant.CageType;
import New_Assignment.Animal.Animal;

/*
*********************************************************************************************************
 *  @Java Class Name :   Cage
 *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   18-03-2024
 *  @Description     :   This class will holds the list of Animals that are present in the Cage & functionalities of its own.
********************************************************************************************************
*/
public class Cage {
    public int id;
    private String cageName;
    private AnimalSpecies animalSpecies;
    private int maxNumberOfAnimal;
    private CageType cageType;
    private boolean isEmpty;
    public int zooId;
    public int zoneId;
    private ArrayList<Animal> animalslist;

    /*
    *********************************************************************************************************
     *  @Method Name     :   Cage
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Constructor of Cage Class.
     *  @param           :   int id, AnimalSpecies animalSpeciestype, CageType cageType, int maxNumberOfAnimal, int zooId,
                             int zoneId.
    ********************************************************************************************************
    */
    public Cage(int id, AnimalSpecies animalSpeciestype, CageType cageType, int maxNumberOfAnimal, int zooId,
            int zoneId) {
        if (id == -1)
            this.id = CageRepository.getId();
        else
            this.id = id;
        this.animalSpecies = animalSpeciestype;

        if (animalSpecies == AnimalSpecies.BIRD) {
            this.maxNumberOfAnimal = 10;
        } else if (animalSpeciestype == AnimalSpecies.REPTILE) {
            this.maxNumberOfAnimal = 5;
        } else {
            this.maxNumberOfAnimal = maxNumberOfAnimal;
        }
        this.cageType = cageType;
        this.zooId = zooId;
        this.zoneId = zoneId;
        this.isEmpty = true;
        this.animalslist = new ArrayList<>();

        CageRepository.cageTable();
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   getId
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Used for Getting up the ID of the Cage.
     *  @return          :   ID
    ********************************************************************************************************
    */
    public int getId() {
        return id;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   getCageName
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Used for Getting up the ID of the Cage.
     *  @return          :   Cage Name
    ********************************************************************************************************
    */
    public String getCageName() {
        return cageName + "'s Cage";
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   setCageName
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Used for Setting the Name of the Cage.
     *  @Param           :   cageName
    ********************************************************************************************************
    */
    public void setCageName(String cageName) {
        this.cageName = cageName;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   getAnimalType
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Used for Getting Animal Species.
     *  @return          :   animalSpecies
    ********************************************************************************************************
    */
    public EnumConstant.AnimalSpecies getAnimalType() {
        return animalSpecies;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   getMaxNumberOfAnimal
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Used for Getting Strength of the Cage.
     *  @return          :   Maximum Number Of Animal
    ********************************************************************************************************
    */
    public int getMaxNumberOfAnimal() {
        return maxNumberOfAnimal;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   isEmpty
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Used for Checking whether the cage is Empty or Not.
     *  @return          :   True if Cage is Empty otherwise return False.
    ********************************************************************************************************
    */
    public boolean isEmpty() {
        return isEmpty;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   getAnimals
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Used for Getting List of Animals from Database & Store it into ArrayList.
     *  @return          :   List of Animal.
    ********************************************************************************************************
    */
    public ArrayList<Animal> getAnimals() {
        this.animalslist = AnimalRepository.getAnimalsOfCage(zoneId, zooId, this.id);
        return animalslist;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   getCageType
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Used for Getting the Cage Type.
     *  @return          :   Cage Type.
    ********************************************************************************************************
    */
    public CageType getCageType() {
        return cageType;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   setCageType
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Used for Setting the Cage Type.
     *  @Param           :   cageType
    ********************************************************************************************************
    */
    public void setCageType(CageType cageType) {
        this.cageType = cageType;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   setList
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Used for Setting the Animal List from Database..
    ********************************************************************************************************
    */
    public void setList() {
        this.animalslist = AnimalRepository.getAnimalsOfCage(zoneId, zooId, this.id);
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   isFull
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Used for Checking the size of animal list.
     *  @Return          :   Return True & False.
    ********************************************************************************************************
    */
    public boolean isFull() {
        return animalslist.size() >= maxNumberOfAnimal;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   addAnimal
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Responsible for adding animal to the Animal Table.
     *  @Param           :   Animal animal, int zoneId
     *  @Return          :   Return True & False.
    ********************************************************************************************************
    */
    public boolean addAnimal(Animal animal, int zoneId) {
        if (!isFull() && animalSpecies.name().equalsIgnoreCase(animal.getSpeciesType().name())) {
            AnimalRepository.animalTable();
            animal.setId(AnimalRepository.getId());
            AnimalRepository.insertIntoAnimalTable(animal.getId(), animal.getName(), animal.getAge(),
                    animal.getWeight(), zooId, getId(), zoneId, animal.getCageType().name());
            this.setList();
            return true;
        }
        return false;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   removeAnimal
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Responsible for removing animal from the Animal Table.
     *  @Param           :   int id.
     *  @Return          :   Return True & False.
    ********************************************************************************************************
    */
    public boolean removeAnimal(int id) {
        this.setList();
        boolean isRemoved = false;
        for (Animal a : animalslist) {
            if (a.getId() == id) {
                isRemoved = AnimalRepository.removeAnimal(this, id);
                this.setList();
            }
            if (isRemoved)
                break;
        }
        return isRemoved;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   findAnimal
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Responsible for finding animal from the Animal Table.
     *  @Param           :   int animalId
     *  @Return          :   Animal.
    ********************************************************************************************************
    */
    public Animal findAnimal(int animalId) {
        this.setList();
        for (Animal animal : animalslist) {
            if (animal.getId() == animalId) {
                return animal;
            }
        }
        return null;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   getAnimalDetailsById
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Responsible for finding animal details by their id from Database.
     *  @Param           :   int animalId
    ********************************************************************************************************
    */
    public void getAnimalDetailsById(int id) {
        this.setList();
        for (Animal animal : animalslist) {
            if (animal.getId() == id) {
                System.out.println("Animal ID --> " + animal.getId() +
                        "\nAnimal Type --> " + animal.getClass().getSimpleName() +
                        "\nSound --> " + animal.getSound() + "\nAge --> " + animal.getAge()
                        + "\nWeight --> " + animal.getWeight());
                return;
            }
        }
    }
}
