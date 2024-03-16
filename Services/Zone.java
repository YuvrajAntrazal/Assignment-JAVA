package New_Assignment.Services;
import New_Assignment.DB_Repo.CageRepository;
import New_Assignment.DB_Repo.ZoneRepository;
import New_Assignment.Utility.EnumConstant;
import New_Assignment.Utility.EnumConstant.AnimalSpecies;
import New_Assignment.Animal.Animal;
import java.util.*;
public class Zone {
    // private static int idCounter = 100;
    private int id;
    private String zoneName;
    private AnimalSpecies zoneType;
    private int maxNumberOfCages;
    private boolean isEmpty;
    private List<Cage> cageslist;
    private int zooId;
    private boolean hasPark;
    private boolean hasCanteen;

    public Zone(int id, EnumConstant.AnimalSpecies zoneType, int maxNumberOfCages,int zooId) {
        if(id==-1)this.id = ZoneRepository.getId();
        else this.id = id;
        //this.zoneName = zoneName;
        this.zoneType = zoneType;
        this.maxNumberOfCages = maxNumberOfCages;
        this.zooId=zooId;
        this.isEmpty = true;
        this.cageslist = new ArrayList<>(maxNumberOfCages);
        ZoneRepository.ZoneTable();//db

    }

    public void setHasCanteen(boolean hasCanteen) {
        this.hasCanteen = hasCanteen;
    }

    public boolean getHasCanteen() {
        return true;
    }

    public void setHasPark(boolean hasPark) {
        this.hasPark = hasPark;
    }

    public boolean getHasPark() {
        return true;
    }

    public int getId() {
        return id;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public AnimalSpecies getZoneType() {
        return zoneType;
    }

    public void setZoneType(AnimalSpecies zoneType) {
        this.zoneType = zoneType;
    }

    public int getMaxNumberOfCages() {
        return maxNumberOfCages;
    }

    public void setMaxNumberOfCages(int maxNumberOfCages) {
        this.maxNumberOfCages = maxNumberOfCages;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public List<Cage> getCages() {
        return cageslist;
    }

    public boolean addCage(Cage cagekaObj) {
        if (cageslist.size() < maxNumberOfCages) {
            cageslist.add(cagekaObj);
            isEmpty = false;
            return true;
        }
        return false;
    }

    public void removeCage(Cage cage) {
        cageslist.remove(cage);
        isEmpty = cageslist.isEmpty();
    }

    public boolean checkPoint(Animal animal, Cage cage) {
        cage.setList();
        for (Animal an : cage.getAnimals()) {

            if (!an.getCageType().name().equalsIgnoreCase(animal.getCageType().name())) {
                return false;
            }
        }
        return true;
    }

    public Boolean addAnimal(Animal animal, int zooId) {
        Boolean isAdded = false;
        this.cageslist = CageRepository.getCagesOfZone(this.id, zooId);
        for (Cage cage : cageslist) {

            if (checkPoint(animal, cage) && !cage.isFull()) {
                isAdded = cage.addAnimal(animal, this.id);
            }

        }
        if (!isAdded && cageslist.size() < 3) {
            Cage Newcage = new Cage(-1, animal.getSpeciesType(), animal.getCageType(),  2,zooId, this.id);
            CageRepository.insertintoCageTable(1, animal.getSpeciesType(), 2, animal.getCageType().name(),zooId, this.id, Newcage.getId());
            isAdded = Newcage.addAnimal(animal, this.id);
        }
        return isAdded;
    }

    public boolean removeAnimal(int id) {
        boolean isRemoved = false;
        for (Cage c : cageslist) {
            isRemoved=c.removeAnimal(id);
            if (isRemoved) { 
                return isRemoved;
            }
        }
        return isRemoved;
    }

    public void getAnimalDetailsById(int id) {
        for (Cage cage : cageslist) {
            cage.getAnimalDetailsById(id);
        }
    }

    public void viewZoneDetails() {
        System.out.println("Zone ID --> " + getId());
        System.out.println("Zone Type --> " + getZoneType() + "\n");
        System.out.println("Has Canteen --> " + getHasCanteen());
        System.out.println("Has Park --> " + getHasPark() + "\n");
        for (Cage cage : cageslist) {
            System.out.println("Cage ID --> "+cage.getId());
            ArrayList<Animal> animals = cage.getAnimals();
            for (Animal animal : animals) {
                System.out.println("Animal ID --> " + animal.getId());
                System.out.println("Animal Name --> " + animal.getName());
                System.out.println("Animal Type --> " + animal.getClass().getSimpleName());
                System.out.println("Animal Sound --> " + animal.getSound() + "\n");
            }
        }
    }
    
    public void showZoneDetails() {

        System.out.println();
        System.out.println("Zone Name --> " + getZoneType()+ "     Zone ID --> " + getId());
        System.out.println("Number of Cages in " + getZoneType() + " Zone --> " + cageslist.size());
    
        for (Cage cage : cageslist) {
            ArrayList<Animal> animals = cage.getAnimals();
            if (!animals.isEmpty()) {
                System.out.println();
                System.out.println("Cage " + cage.getId());
                for (Animal animal : animals) {
                    System.out.println("     " + animal.getName() + " (ID: " + animal.getId() + ")");
                }
            } else {
                System.out.println("Cage ID - " + cage.getId() + " --> This Cage is Empty.");
            }
        }
    }
}
