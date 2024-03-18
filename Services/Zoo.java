package New_Assignment.Services;

import java.util.*;
import New_Assignment.DB_Repo.ZoneRepository;
import New_Assignment.DB_Repo.ZooRepository;
import New_Assignment.Utility.EnumConstant;
import New_Assignment.Animal.Animal;

/*
*********************************************************************************************************
 *  @Java Class Name :   Zoo
 *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   18-03-2024
 *  @Description     :   This class will holds the list of Zone that are present in the Zoo & functionalities of its own.
********************************************************************************************************
*/
public class Zoo {
    private int zooId;
    private String zooName;
    private int maxNumberOfZones;
    private List<Zone> zoneslist;

    /*
    *********************************************************************************************************
     *  @Method Name     :   Zoo
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Constructor of Zoo Class.
     *  @param           :   int id, String zooName, int maxNumberOfZones
    ********************************************************************************************************
    */
    public Zoo(int id, String zooName, int maxNumberOfZones) {
        this.zooId = id;
        this.zooName = zooName;
        this.maxNumberOfZones = maxNumberOfZones;
        this.zoneslist = new ArrayList<>(maxNumberOfZones);
        ZooRepository.ZooTable(zooName);
        ZooRepository.insertIntoZooTable(zooId, zooName);
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   setZoneslist
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Used for Setting the List of zones.
     *  @Param           :   List<Zone> zoneslist
    ********************************************************************************************************
    */
    public void setZoneslist(List<Zone> zoneslist) {
        this.zoneslist = zoneslist;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   getZoneList
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Used for Getting The List of Zone.
     *  @return          :   Return List of Zone.
    ********************************************************************************************************
    */
    public List<Zone> getZoneList() {
        this.zoneslist = ZoneRepository.getZonesOfZoo(this.zooId);
        return this.zoneslist;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   getId
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Used for Getting The ID of Zoo.
     *  @return          :   ID
    ********************************************************************************************************
    */
    public int getId() {
        return zooId;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   getZooName
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Used for Getting The Name of the Zoo.
     *  @return          :   Return Zoo Name.
    ********************************************************************************************************
    */
    public String getZooName() {
        return zooName;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   setZooName
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Used for Setting the Name of Zoo.
     *  @Param           :   zooName
    ********************************************************************************************************
    */
    public void setZooName(String zooName) {
        this.zooName = zooName;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   getMaxNumberOfZones
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Used for Getting The Maximum number of Zones in Zoo.
     *  @return          :   Return Maximum Number of Zone
    ********************************************************************************************************
    */
    public int getMaxNumberOfZones() {
        return maxNumberOfZones;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   getZone
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Used for Getting The Zone.
     *  @return          :   Return Zone.
    ********************************************************************************************************
    */
    public List<Zone> getZone() {
        return zoneslist;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   addZone
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Used for Adding Zones in the Zoo.
     *  @Param           :   Zone zone
     *  @return          :   Return True or False.
    ********************************************************************************************************
    */
    public boolean addZone(Zone zone) {
        this.getZoneList();
        for (int i = 0; i < zoneslist.size(); i++) {
            zoneslist.add(zone);
            return true;
        }
        return false;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   findAvailableZone
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Responsible for finding the Availability of the Zone.
     *  @Param           :   EnumConstant.AnimalSpecies animalSpecies, List<Zone> zoneslist
     *  @return          :   Return Zone
    ********************************************************************************************************
    */
    public Zone  findAvailableZone(EnumConstant.AnimalSpecies animalSpecies, List<Zone> zoneslist) {
        this.getZoneList();
        for (Zone x : zoneslist) {
            if (x.getZoneType() == animalSpecies) {
                return x;
            }
        }
        return null;

    }

     /*
    *********************************************************************************************************
     *  @Method Name     :   addNewZone
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Responsible for adding the new Zone in the Zoo.
     *  @Param           :   String zoneName, EnumConstant.AnimalSpecies animalSpecies, int maxNumberOfCages, int zooId
     *  @return          :   Return Zone
    ********************************************************************************************************
    */
    public Zone addNewZone(String zoneName, EnumConstant.AnimalSpecies animalSpecies, int maxNumberOfCages, int zooId) {
        return new Zone(-1, animalSpecies, 3, zooId);
    }

     /*
    *********************************************************************************************************
     *  @Method Name     :   allocateAnimal
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Responsible for adding Animal in the Zoo.
     *  @Param           :   Animal animal
     *  @return          :   Return True or False.
    ********************************************************************************************************
    */
    public boolean allocateAnimal(Animal animal) {
        boolean isAdded = false;
        EnumConstant.AnimalSpecies animalSpecies = animal.getSpeciesType();
        this.zoneslist = ZoneRepository.getZonesOfZoo(this.zooId);
        Zone zone = findAvailableZone(animalSpecies, zoneslist);
        if (zone != null) {
            isAdded = zone.addAnimal(animal, this.zooId);
            System.out.println("Zone ID: " + zone.getId());
        } else {
            Zone newZone = this.addNewZone(zooName, animalSpecies, maxNumberOfZones, zooId);
            ZoneRepository.insertIntoZoneTable(newZone.getId(), animalSpecies, 3, zooId);
            System.out.println("Zone ID: " + newZone.getId());
            isAdded = newZone.addAnimal(animal, this.zooId);
        }
        return isAdded;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   checkPoint
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Responsible for checking AnimalType & the CageType.
     *  @Param           :   Animal animal, Cage cage
     *  @return          :   Return True or False.
    ********************************************************************************************************
    */
    public boolean checkPoint(Animal animal, Cage cage) {
        for (Animal an : cage.getAnimals()) {
            if (!an.getCageType().name().equalsIgnoreCase(animal.getCageType().name())) {
                return false;
            }
        }
        return true;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   showZooDetails
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Responsible for Showing all the Zoo Detilas at Once.
    ********************************************************************************************************
    */
    public void showZooDetails() {
        System.out.println("\nNumber of Zones --> " + maxNumberOfZones);
        this.zoneslist = ZoneRepository.getZonesOfZoo(this.zooId);
        for (Zone zone : zoneslist) {
            zone.showZoneDetails();
        }
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   getAnimalDetailsById
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Responsible for Getting Animal Details by Id
     *  @Param           :   int id
    ********************************************************************************************************
    */
    public void getAnimalDetailsById(int id) {
        this.getZoneList();
        for (Zone zone : zoneslist) {
            zone.getAnimalDetailsById(id);
        }
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   removeAnimalById
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Responsible for Removing Animal by Id from the Zoo.
     *  @Param           :   int id
    ********************************************************************************************************
    */
    public boolean removeAnimalById(int id) {
        this.getZoneList();
        boolean isRemoved = false;
        for (Zone z : zoneslist) {
            isRemoved = z.removeAnimal(id);
            if (isRemoved)
                break;
        }
        return isRemoved;
    }

    /*
    *********************************************************************************************************
     *  @Method Name     :   viewZoneById
     *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
     *  @Company         :   Antrazal
     *  @Date            :   18-03-2024
     *  @Description     :   Responsible for Viewing a Particular Zone by its ID.
     *  @Param           :   int zoneId
    ********************************************************************************************************
    */
    public void viewZoneById(int zoneId) {
        this.getZoneList();
        for (Zone zone : zoneslist) {
            if (zone.getId() == zoneId) {
                zone.viewZoneDetails();
                return;
            }
        }
        System.out.println("Zone with ID " + zoneId + " not found.");
    }

}