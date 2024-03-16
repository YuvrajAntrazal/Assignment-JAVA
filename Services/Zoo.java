package New_Assignment.Services;
import java.util.*;
import New_Assignment.DB_Repo.ZoneRepository;
import New_Assignment.Services.Zone;
import New_Assignment.DB_Repo.ZooRepository;
import New_Assignment.Utility.EnumConstant;
import New_Assignment.Animal.Animal;
public class Zoo {
    private int zooId;
    private String zooName;
    private int maxNumberOfZones;
    private List<Zone> zoneslist;
    public Zoo(int id,String zooName, int maxNumberOfZones) {
        this.zooId = id;
        this.zooName = zooName;
        this.maxNumberOfZones = maxNumberOfZones;
        this.zoneslist = new ArrayList<>(maxNumberOfZones);
        ZooRepository.ZooTable(zooName);
        ZooRepository.insertIntoZooTable(zooId, zooName);
    }

    public void setZoneslist(List<Zone> zoneslist) {
        this.zoneslist = zoneslist;
    }
    public List<Zone> getZoneList() {
        return this.zoneslist;
    }

    public int getId() {
        return zooId;
    }

    public String getZooName() {
        return zooName;
    }

    public void setZooName(String zooName) {
        this.zooName = zooName;
    }

    public int getMaxNumberOfZones() {
        return maxNumberOfZones;
    }

    public List<Zone> getZone() {
        return zoneslist;
    }

    public boolean addZone(Zone zone) {
        for (int i = 0; i < zoneslist.size(); i++) {
            zoneslist.add(zone);
            return true;
        }
        return false;
    }

    public Zone findAvailableZone(EnumConstant.AnimalSpecies animalSpecies, List<Zone> zoneslist) {
        for (Zone x : zoneslist) { 
            if (x.getZoneType() == animalSpecies) {
                return x;
            }
        }
        return null;

    }

    public Zone addNewZone(String zoneName, EnumConstant.AnimalSpecies animalSpecies, int maxNumberOfCages,int zooId) {
        return new Zone(animalSpecies, 3,zooId);
    }

    public boolean allocateAnimal(Animal animal) {
        boolean isAdded = false;
        EnumConstant.AnimalSpecies animalSpecies = animal.getSpeciesType();
        this.zoneslist = ZoneRepository.getZonesOfZoo(this.zooId);
        Zone zone = findAvailableZone(animalSpecies, zoneslist);
        if (zone != null) {
            isAdded = zone.addAnimal(animal, this.zooId);
            System.out.println("Zone ID: "+zone.getId());
        }  
        else {
            Zone newZone = this.addNewZone(zooName, animalSpecies, maxNumberOfZones,zooId);
            zoneslist.add(newZone);
            ZoneRepository.insertIntoZoneTable(newZone.getId(), animalSpecies, 3,zooId, newZone.getId()); 
            System.out.println("Zone ID: "+newZone.getId());
            isAdded = newZone.addAnimal(animal, this.zooId);
        }
        return isAdded;
    }

    public boolean checkPoint(Animal animal, Cage cage) {
        for (Animal an : cage.getAnimals()) {
            if (!an.getCageType().name().equalsIgnoreCase(animal.getCageType().name())) {
                return false;
            }
        }
        return true;
    }

    public void showZooDetails() {
        System.out.println("\nNumber of Zones --> " + maxNumberOfZones);
        for (Zone zone : zoneslist) {
            zone.showZoneDetails(); 
        }
    }
        
    public void getAnimalDetailsById(int id) {
        for (Zone zone : zoneslist) {
            zone.getAnimalDetailsById(id);
        }
    }
 
    public boolean removeAnimalById(int id){
        boolean isRemoved=false;
        for(Zone z:zoneslist){
           isRemoved=z.removeAnimal(id);
           if (isRemoved) { 
            return true;
        }
        }
        return isRemoved;
    }

    public void viewZoneById(int zoneId) {
        for (Zone zone : zoneslist) {
            if (zone.getId() == zoneId) {
                zone.viewZoneDetails(); 
                return; 
            }
        }
        System.out.println("Zone with ID " + zoneId + " not found.");
    }

}        