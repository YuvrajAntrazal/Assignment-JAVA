package New_Assignment.Utility;

/*
*********************************************************************************************************
 *  @Java Class Name :   Constant_Class
 *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   18-03-2024
 *  @Description     :   Responsible for making constant statements in the whole program.
********************************************************************************************************
*/
public class Constant_Class {
        public static final String INVALID_INPUT = "== Invalid Input ==";
        public static final String GOOD_BYY = "Good Byy! Visit Again..";
        public static final String ADD_ANIMAL = "Add Animal.";
        public static final String ZOO_NAME = "Enter the name of your Zoo: ";
        public static final String NO_OF_ZONES = "Enter the No. of Zones in your Zoo: ";
        public static final String ENTER_ZOO_ID = "Enter Zoo Id: ";
        public static final String ANIMAL_ADD_SUCC = "Animal Added Successfully";
        public static final String FAIL_INSERT_ANIMAL = "Failed to insert animal.";
        public static final String PLEASE_MAKE_SURE = "== Please make sure the input is Right ==";
        public static final String ENTER_ID_TO_REMOVE = "Enter Animal ID to remove: ";
        public static final String ENTER_ANI_ID = "Enter Animal ID:";
        public static final String ENTER_ANI_NAME = "Enter Animal Name: ";
        public static final String ENTER_AGE = "Enter Age: ";
        public static final String ENTER_WEIGHT = "Enter weight: ";
        public static final String DIAPLAY = "1.Add Animal \n" +
                        "2.View Zoo Details \n" +
                        "3.Remove Animal from Zoo \n" +
                        "4.Get Animal Details By ID \n" +
                        "5.View Zone Details By ID \n" +
                        "6.Exit \n" +
                        "Enter your Choice";
        public static final String ENTER_ANIMAL_TYPE = """
                        -Lion
                        -Cow
                        -Crocodile
                        -Snake
                        -Peacock
                        -Eagle
                         """;
        public static final String AGE_MUST_BE_POSITIVE = " == Age must be a positive number == ";
        public static final String AGE_MUST_BE_VALID_NO = " == Please enter a valid number for age == ";
        public static final String WEIGHT_MUST_BE_POSIT = " == Weight must be a positive number == ";
        public static final String VALI_NO_OF_WEIGHT = " == Please enter a valid number for weight == ";
        public static final String INVALID_ANIMAL_TYPE = " == Invalid animal type. Please choose from the provided options == ";
        public static final String ENTER_ANIMAL_TYPE_BEG = """
                        ==== Enter Animal Type ===
                        """;
        public static final String ENTER_VALID_NAME = " == Please enter a valid name == ";
        public static final String ANIMAL_NOT_REMOVED = "Animal Is Not Removed";
        public static final String ANIMAL_TABLE_IS_NOT_CREATED_YET = "Animal Table Is Not Created Yet";
        public static final String SELECT_ALL_FROM_ANIMAL = "select * from animal";
        public static final String SELECT_ANIMALID_FROM_ANIMAL = "select animalId from animal order by animalId DESC limit 1";
        public static final String CREATE_TABLE_ANIMAL = "CREATE TABLE IF NOT EXISTS Animal ("
                        + "id INT AUTO_INCREMENT PRIMARY KEY , "
                        + "animalId INT NOT NULL, "
                        + "animalName VARCHAR(255), "
                        + "animalType VARCHAR(255), "
                        + "animalAge INT, "
                        + "animalWeight DOUBLE,"
                        + "zooId INT ,"
                        + "cageId INT,"
                        + "zoneId INT "
                        + ")";
        public static final String ALTER_TABLE_ANIMAL = "ALTER TABLE Animal AUTO_INCREMENT = 1000";
        public static final String INSERT_INTO_ANIMAL = "insert into Animal(animalName,animalAge,animalWeight,zooId,cageId, zoneId, animalId, animalType) values (?,?,?,?,?,?,?,?)";
        public static final String SELECT_CAGEID_FROM_CAGE = "select cageId from cage order by cageId DESC limit 1";
        public static final String CAGE_TABLE_IS_NOT_CREATED = "Cage Table Is Not Created Yet";
        public static final String CREATE_TABLE_CAGE = "CREATE TABLE IF NOT EXISTS Cage ("
                        + "id INT AUTO_INCREMENT PRIMARY KEY , "
                        + "animalSpeciestype VARCHAR(255), "
                        + "cagetype VARCHAR(255), "
                        + "maxNumberOfAnimal INT, "
                        + "zooId INT,"
                        + "zoneId INT,"
                        + "cageId INT"
                        + ")";
        public static final String INSERT_INTO_CAGE = "insert into Cage(animalSpeciestype,maxNumberOfAnimal, cagetype,zooId, zoneId, cageId) values (?,?,?,?,?,?)";
        public static final String SELECT_ZONE_ID_FROM_ZONE = "select zoneId from zone order by zoneId DESC limit 1";
        public static final String ZONE_TABLE_NOT_CREATED_YET = "Zone Table Is Not Created Yet";
        public static final String CREATE_ZONE_TABLE = "CREATE TABLE IF NOT EXISTS Zone ("
                        + "id INT AUTO_INCREMENT PRIMARY KEY , "
                        + "speciesType VARCHAR(255), "
                        + "maxNumberOfCages INT,"
                        + "zooId INT,"
                        + "zoneId INT"
                        + ")";
        public static final String ALTER_TABLE_ZONE = "ALTER TABLE Zone AUTO_INCREMENT = 100";
        public static final String INSERT_INTO_ZONE = "insert into Zone(speciesType,maxNumberOfCages,zooId, zoneId) values(?,?,?, ?)";
        public static final String SELECT_ZOO_ID = "select zooId from zoo order by zooId DESC limit 1";
        public static final String CREATE_ZOO_TABLE = "create table IF NOT EXISTS zoo (zooId INT AUTO_INCREMENT PRIMARY KEY, zooName VARCHAR(255))";
        public static final String SELECT_COUNT_FROM_ZOO = "SELECT COUNT(*) FROM zoo WHERE zooId = ?";
        public static final String INSERT_INTO_ZOO = "insert into Zoo(zooId,zooName) values(?,?)";
        public static final String SELECT_ALL_FROM_ZOO = "SELECT * FROM Zoo";
        public static final String SELECT_ZOO_ID_FROM_ABOVE = "\nEnter Zoo ID from above to see Zoo Details.";
        public static final String SELECT_ALL_FROM_ZONE = "select * from zone where zooId=";
        public static final String SELECT_ALL_FROM_ANIMAL_WHERE = "select * from animal where zooId = ";
        public static final String SELECT_ALL_FROM_CAGE_WHERE = "select * from cage where zooId = ";
        public static final String URLHAI = "jdbc:mysql://localhost:3306/ZOO_MANAGEMENT_SYSTEM";
        public static final int ZONE_STRT_ID = 1000;
}
