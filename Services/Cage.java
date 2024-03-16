package New_Assignment.Services;
import java.util.*;
import New_Assignment.DB_Repo.AnimalRepository;
import New_Assignment.DB_Repo.CageRepository;
import New_Assignment.Utility.EnumConstant;
import New_Assignment.Utility.EnumConstant.AnimalSpecies;
import New_Assignment.Utility.EnumConstant.CageType;
import New_Assignment.Animal.Animal;

public class Cage {
    // private static int idCounter = 1;
    public int id;
    private String cageName;
    private AnimalSpecies animalSpecies;
    private int maxNumberOfAnimal;
    private CageType cageType;
    private boolean isEmpty;
    public int zooId;
    public int zoneId;
    private ArrayList<Animal> animalslist;

    public Cage(int id, AnimalSpecies animalSpeciestype, CageType cageType,int maxNumberOfAnimal,int zooId, int zoneId) {
        // this.id = Cage.idCounter++;
        if(id==-1) this.id = CageRepository.getId();
        else this.id = id;
        this.animalSpecies = animalSpeciestype;

        if (animalSpecies == AnimalSpecies.BIRD) { 
            this.maxNumberOfAnimal = 10;
        } else if (animalSpeciestype == AnimalSpecies.REPTILE) { 
            this.maxNumberOfAnimal = 5;
        } else {
            this.maxNumberOfAnimal = maxNumberOfAnimal;
        }
        this.cageType = cageType;
        this.zooId=zooId;
        this.zoneId = zoneId;
        this.isEmpty = true;
        this.animalslist = new ArrayList<>();

        CageRepository.cageTable(); //db
    }

    public int getId() {
        return id;
    }

    public String getCageName() {
        return cageName + "'s Cage";
    }

    public void setCageName(String cageName) {
        this.cageName = cageName;
    }

    public EnumConstant.AnimalSpecies getAnimalType() {
        return animalSpecies;
    }

    public int getMaxNumberOfAnimal() {
        return maxNumberOfAnimal;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public ArrayList<Animal> getAnimals() {
        this.animalslist = AnimalRepository.getAnimalsOfCage(zoneId, zooId, this.id);
        return animalslist;
    }

    public CageType getCageType() {
        return cageType;
    }

    public void setCageType(CageType cageType) {
        this.cageType = cageType;
    }

    public void setList(){
        this.animalslist = AnimalRepository.getAnimalsOfCage(zoneId, zooId, this.id);
    }

    public boolean isFull() {
        return animalslist.size() >= maxNumberOfAnimal;
    }

    public boolean addAnimal(Animal animal, int zoneId) {
        if (!isFull() && animalSpecies.name().equalsIgnoreCase(animal.getSpeciesType().name())) {
            AnimalRepository.animalTable();
            animal.setId(AnimalRepository.getId());
            AnimalRepository.insertIntoAnimalTable(animal.getId(), animal.getName(),animal.getAge(),animal.getWeight(), zooId, getId(), zoneId, animal.getCageType().name());
            this.setList();
            return true;
        }
        return false;
    }

    public boolean removeAnimal(int id){
        boolean isRemoved=false;
        for(Animal a:animalslist){
            if(a.getId()==id){
                isRemoved=animalslist.remove(a);
                return AnimalRepository.removeAnimal(this, id);
            }
        }
        return isRemoved;
    }

    public Animal findAnimal(int animalId) {
        this.setList();
        for (Animal animal : animalslist) {
            if (animal.getId() == animalId) {
                return animal;
            }
        }
        return null;
    }

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
