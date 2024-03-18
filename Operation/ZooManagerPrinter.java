package New_Assignment.Operation;

import New_Assignment.Utility.Constant_Class;

/*
*********************************************************************************************************
 *  @Java Class Name :   ZooManagerPrinter
 *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   18-03-2024
 *  @Description     :   This class is responsible for All Printing Statements in the Zoo Management System.
********************************************************************************************************
*/
public class ZooManagerPrinter {

    public static void printZooNamePrompt() {
        System.out.print(Constant_Class.ZOO_NAME);
    }

    public static void printEnterValidName() {
        System.out.println(Constant_Class.ENTER_VALID_NAME + "\n");
    }

    public static void printNoOfZonesPrompt() {
        System.out.print(Constant_Class.NO_OF_ZONES);
    }

    public static void printEnterZooId() {
        System.out.print(Constant_Class.ENTER_ZOO_ID);
    }

    public static void printPleaseMakeSure() {
        System.out.println(Constant_Class.PLEASE_MAKE_SURE + "\n");
    }

    public static void printEnterAnimalId() {
        System.out.println(Constant_Class.ENTER_ANI_ID);
    }

    public static void printZooDetailsHeader(String zooName) {
        System.out.println(("=").repeat(6) + " " + zooName + " Zoo Details " + ("=").repeat(6));
    }

    public static void printZoneIdPrompt() {
        System.out.println(("=").repeat(6) + " " + " Enter Zone ID " + ("=").repeat(6));
    }

    public static void printInvalidZooName() {
        System.out.println(Constant_Class.ENTER_VALID_NAME + "\n");
    }

    public static void printNumberOfZonesPrompt() {
        System.out.print(Constant_Class.NO_OF_ZONES);
    }

    public static void printInvalidInputMessage() {
        System.out.println(Constant_Class.PLEASE_MAKE_SURE + "\n");
    }

    public static void printWelcomeMessage(String zooName) {
        System.out.println("_____________Welcome to " + zooName + " Zoo______________\n");
    }

    public static void printMenu() {
        System.out.println(Constant_Class.DIAPLAY);
    }

    public static void printInvalidChoiceMessage() {
        System.out.println(Constant_Class.PLEASE_MAKE_SURE + "\n");
    }

    public static void printInvalidAnimalTypeMessage() {
        System.out.println(Constant_Class.INVALID_ANIMAL_TYPE + "\n");
    }

    public static void printEnterAnimalNamePrompt() {
        System.out.print(Constant_Class.ENTER_ANI_NAME);
    }

    public static void printInvalidAnimalNameMessage() {
        System.out.println(Constant_Class.ENTER_VALID_NAME + "\n");
    }

    public static void printEnterAgePrompt() {
        System.out.print(Constant_Class.ENTER_AGE);
    }

    public static void printInvalidAgeMessage() {
        System.out.println(Constant_Class.AGE_MUST_BE_POSITIVE + "\n");
    }

    public static void printAgeMustBeValidNumber() {
        System.out.println(Constant_Class.AGE_MUST_BE_VALID_NO + "\n");
    }

    public static void printEnterWeightPrompt() {
        System.out.print(Constant_Class.ENTER_WEIGHT);
    }

    public static void printInvalidWeightMessage() {
        System.out.println(Constant_Class.WEIGHT_MUST_BE_POSIT + "\n");
    }

    public static void printValidNumberForWeight() {
        System.out.println(Constant_Class.VALI_NO_OF_WEIGHT + "\n");
    }

    public static void printAnimalId(int id) {
        System.out.println("Animal ID: " + id);
    }

    public static void printAnimalAddSuccessMessage() {
        System.out.println(Constant_Class.ANIMAL_ADD_SUCC + "\n");
    }

    public static void printFailInsertAnimalMessage() {
        System.out.println(Constant_Class.FAIL_INSERT_ANIMAL + "\n");
    }

    public static void printRemoveAnimalByIdPrompt() {
        System.out.print(Constant_Class.ENTER_ID_TO_REMOVE);
    }

    public static void printAnimalRemovedMessage(int animalId) {
        System.out.println("Animal with ID " + animalId + " removed from Zoo.");
    }

    public static void printAnimalNotPresentMessage(int animalId) {
        System.out.println("Animal with ID " + animalId + " not present in the Zoo.");
    }

    public static void printEnterAnimalIdPrompt() {
        System.out.println(Constant_Class.ENTER_ANI_ID);
    }

    public static void printViewZoneByIdHeader() {
        System.out.println(("=").repeat(6) + " " + " Enter Zone ID " + ("=").repeat(6));
    }

    public static void printGoodByeMessage() {
        System.out.println(Constant_Class.GOOD_BYY);
    }

    public static void AnimalNotRemovedMessage(){
        System.out.println(Constant_Class.ANIMAL_NOT_REMOVED);
    }
    public static void AnimalIsNotRemovedYet(){
        System.out.println(Constant_Class.ANIMAL_TABLE_IS_NOT_CREATED_YET);
    }
}