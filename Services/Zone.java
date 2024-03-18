package New_Assignment.Services;

import New_Assignment.DB_Repo.CageRepository;
import New_Assignment.DB_Repo.ZoneRepository;
import New_Assignment.Utility.EnumConstant;
import New_Assignment.Utility.EnumConstant.AnimalSpecies;
import New_Assignment.Animal.Animal;
import java.util.*;

/*
*********************************************************************************************************
 *  @Java Class Name :   Zone
 *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   18-03-2024
 *  @Description     :   This class will holds the list of Cages that are present in the Zone & functionalities of its own.
********************************************************************************************************
*/
public class Zone {
    private int id;
    private String zoneName;
    private AnimalSpecies zoneType;
    private int maxNumberOfCages;
    private boolean isEmpty;
    private List<Cage> cageslist;
    private int zooId;
    private boolean hasPark;
    private boolean hasCanteen;

    /*
    *********************************************************************************************************
     *  @Method Name     :   Zone
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Constructor of Zone Class.
     *  @param           :   int id, EnumConstant.AnimalSpecies zoneType, int maxNumberOfCages, int zooId
    ********************************************************************************************************
    */
    public Zone(int id, EnumConstant.AnimalSpecies zoneType, int maxNumberOfCages, int zooId) {
        if (id == -1)
            this.id = ZoneRepository.getId();
        else
            this.id = id;
        this.zoneType = zoneType;
        this.maxNumberOfCages = maxNumberOfCages;
        this.zooId = zooId;
        this.isEmpty = true;
        this.cageslist = new ArrayList<>(maxNumberOfCages);
        ZoneRepository.ZoneTable();

    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   setHasCanteen
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Used for Setting the Canteen If it Exists or Not.
     *  @Param           :   hasCanteen
    ********************************************************************************************************
    */
    public void setHasCanteen(boolean hasCanteen) {
        this.hasCanteen = hasCanteen;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   getHasCanteen
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Used for Getting The Canteen in Zone.
     *  @return          :   Return True or False.
    ********************************************************************************************************
    */
    public boolean getHasCanteen() {
        return true;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   setHasPark
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Used for Setting the Park If it Exists or Note.
     *  @Param           :   hasPark
    ********************************************************************************************************
    */
    public void setHasPark(boolean hasPark) {
        this.hasPark = hasPark;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   getHasPark
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Used for Getting The Park in Zone.
     *  @return          :   Return True or False.
    ********************************************************************************************************
    */
    public boolean getHasPark() {
        return true;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   getId
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Used for Getting the Id of Zone.
     *  @return          :   ID
    ********************************************************************************************************
    */
    public int getId() {
        return id;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   getZoneName
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Used for Getting the Name of Zone.
     *  @return          :   Name of Zone
    ********************************************************************************************************
    */
    public String getZoneName() {
        return zoneName;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   setZoneName
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Used for Setting the Name of the Zone.
     *  @Param           :   zoneName
    ********************************************************************************************************
    */
    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   getZoneType
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Used for getting the Zone Type.
     *  @Return          :   zoneType
    ********************************************************************************************************
    */
    public AnimalSpecies getZoneType() {
        return zoneType;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   setZoneType
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Used for Setting the Type of the Zone.
     *  @Param           :   zoneType
    ********************************************************************************************************
    */
    public void setZoneType(AnimalSpecies zoneType) {
        this.zoneType = zoneType;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   getMaxNumberOfCages
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Used for getting the Maximum Number Of Cages.
     *  @Return          :   Maximum Number Of Cages.
    ********************************************************************************************************
    */
    public int getMaxNumberOfCages() {
        return maxNumberOfCages;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   setMaxNumberOfCages
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Used for Setting the maximum No. of Cages.
     *  @Param           :   maxNumberOfCages
    ********************************************************************************************************
    */
    public void setMaxNumberOfCages(int maxNumberOfCages) {
        this.maxNumberOfCages = maxNumberOfCages;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   setEmpty
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Used for Setting the whether the zone is Empty.
     *  @Param           :   empty
    ********************************************************************************************************
    */
    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   getCages
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Used for Getting The List of Cages.
     *  @return          :   Return the List of Cages present in Zone.
    ********************************************************************************************************
    */
    public List<Cage> getCages() {
        return cageslist;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   addCage
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Used for Adding Cages into Zone.
     *  @Return          :   Return True or False.
     *  @Param           :   Cage cagekaObj
    ********************************************************************************************************
    */
    public boolean addCage(Cage cagekaObj) {
        if (cageslist.size() < maxNumberOfCages) {
            cageslist.add(cagekaObj);
            isEmpty = false;
            return true;
        }
        return false;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   removeCage
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Used for remove Cages from Zone.
     *  @Param           :   Cage cage
    ********************************************************************************************************
    */
    public void removeCage(Cage cage) {
        this.cageslist = CageRepository.getCagesOfZone(this.id, zooId);
        cageslist.remove(cage);
        isEmpty = cageslist.isEmpty();
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   checkPoint
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Check the CageType of an Animal is equals or not.
     *  @Param           :   CAnimal animal, Cage cage
     *  @Return          :   Return True or False.
    ********************************************************************************************************
    */
    public boolean checkPoint(Animal animal, Cage cage) {
        cage.setList();
        for (Animal an : cage.getAnimals()) {

            if (!an.getCageType().name().equalsIgnoreCase(animal.getCageType().name())) {
                return false;
            }
        }
        return true;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   addAnimal
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Used for Adding Animal to the Zone.
     *  @Param           :   Animal animal, int zooId
     *  @Return          :   Return True or False.
    ********************************************************************************************************
    */
    public Boolean addAnimal(Animal animal, int zooId) {
        Boolean isAdded = false;
        this.cageslist = CageRepository.getCagesOfZone(this.id, zooId);
        for (Cage cage : cageslist) {

            if (checkPoint(animal, cage) && !cage.isFull()) {
                isAdded = cage.addAnimal(animal, this.id);
            }

        }
        if (!isAdded && cageslist.size() < 3) {
            Cage Newcage = new Cage(-1, animal.getSpeciesType(), animal.getCageType(), 2, zooId, this.id);
            CageRepository.insertintoCageTable(1, animal.getSpeciesType(), 2, animal.getCageType().name(), zooId,
                    this.id, Newcage.getId());
            isAdded = Newcage.addAnimal(animal, this.id);
        }
        return isAdded;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   removeAnimal
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Used for removing Animal from the Zone.
     *  @Param           :   int id
     *  @Return          :   Return True or False.
    ********************************************************************************************************
    */
    public boolean removeAnimal(int id) {
        this.cageslist = CageRepository.getCagesOfZone(this.id, zooId);
        boolean isRemoved = false;
        for (Cage c : cageslist) {
            isRemoved = c.removeAnimal(id);
            if (isRemoved)
                break;
        }
        return isRemoved;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   getAnimalDetailsById
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Used for getting Animal details from the Zone.
     *  @Param           :   int id
    ********************************************************************************************************
    */
    public void getAnimalDetailsById(int id) {
        this.cageslist = CageRepository.getCagesOfZone(this.id, zooId);
        for (Cage cage : cageslist) {
            cage.getAnimalDetailsById(id);
        }
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   viewZoneDetails
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Used for getting Animal details from the Zone.
     *  @Param           :   int id
    ********************************************************************************************************
    */
    public void viewZoneDetails() {
        this.cageslist = CageRepository.getCagesOfZone(this.id, zooId);
        System.out.println("Zone ID --> " + getId());
        System.out.println("Zone Type --> " + getZoneType() + "\n");
        System.out.println("Has Canteen --> " + getHasCanteen());
        System.out.println("Has Park --> " + getHasPark() + "\n");
        for (Cage cage : cageslist) {
            System.out.println("Cage ID --> " + cage.getId());
            ArrayList<Animal> animals = cage.getAnimals();
            for (Animal animal : animals) {
                System.out.println("Animal ID --> " + animal.getId());
                System.out.println("Animal Name --> " + animal.getName());
                System.out.println("Animal Type --> " + animal.getClass().getSimpleName());
                System.out.println("Animal Sound --> " + animal.getSound() + "\n");
            }
        }
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   showZoneDetails
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Used for showing the Zone Details.
    ********************************************************************************************************
    */
    public void showZoneDetails() {
        System.out.println();
        this.cageslist = CageRepository.getCagesOfZone(this.id, zooId);
        System.out.println("Zone Name --> " + getZoneType() + "     Zone ID --> " + getId());
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
