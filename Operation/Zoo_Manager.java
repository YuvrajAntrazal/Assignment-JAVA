package New_Assignment.Operation;
import java.util.*;
import New_Assignment.Animal.Animal;
import New_Assignment.DB_Repo.ZooRepository;
import New_Assignment.Services.*;
import New_Assignment.Utility.Animal_Factory;
import New_Assignment.Utility.Constant_Class;
import New_Assignment.Operation.Zoo_Manager;

public class Zoo_Manager {
    public static void Manager() {
        Scanner ip = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Enter 1 to See Previous Zoo.");
            System.out.println("Enter 2 to Create a New Zoo.");

            int choice = 0;
            boolean validChoice = false;

            while (!validChoice) {
                try {
                    choice = Integer.parseInt(ip.nextLine());
                    if ((choice != 1) || (choice != 2)) {

                        validChoice = true;
                    }

                } catch (Exception e) {
                    System.out.println("Please enter the number from the Above Choices.");
                }

            }

            switch (choice) {
                case 1:
                    ZooRepository.prevoiusZooDetails();
                    break;
                case 2:
                    createNewZoo(ip);
                    break;
                default:

            }

            System.out.println("\nDo you want to go to Main Menu? (yes/no)");
            String answer = ip.nextLine().toLowerCase();
            if (answer.equals("no")) {
                exit = true;
            }
        }

        ip.close();
    }

    private static void createNewZoo(Scanner ip) {

        int zooId = 0;
        boolean validzooIdInput = false;

        while (!validzooIdInput) {
            // try {
            //     ZooManagerPrinter.printEnterZooId();
            //     zooId = Integer.parseInt(ip.nextLine());
            //     validzooIdInput = true;
            // } catch (NumberFormatException e) {
            //     ZooManagerPrinter.printPleaseMakeSure();
            // }
            zooId = ZooRepository.getId();
            validzooIdInput = true;
        }

        try {
            if (ZooRepository.checkIfZooExists(zooId)) {
                System.out.println("Zoo ID " + zooId + " already exists.");
                return; 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String zooName = "";

        while (zooName.isEmpty() || !zooName.matches("[a-zA-Z]+")) {
            ZooManagerPrinter.printZooNamePrompt();
            zooName = ip.nextLine().trim();
            if (!zooName.matches("[a-zA-Z]+")) {
                ZooManagerPrinter.printEnterValidName();
            }
        }

        int maxNumberOfZones = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                ZooManagerPrinter.printNoOfZonesPrompt();
                maxNumberOfZones = Integer.parseInt(ip.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                ZooManagerPrinter.printPleaseMakeSure();
            }
        }

        Zoo zoo = new Zoo(zooId, zooName, maxNumberOfZones);

        boolean flag = false;
        while (!flag) {
            System.out.println();
            System.out.println("_____________Welcome to " + zooName + " Zoo______________\n");
            ZooManagerPrinter.printMenu();
            String choice = ip.nextLine();

            if (!(choice.equalsIgnoreCase("1") ||
                    choice.equalsIgnoreCase("2") ||
                    choice.equalsIgnoreCase("3") ||
                    choice.equalsIgnoreCase("4") ||
                    choice.equalsIgnoreCase("5") ||
                    choice.equalsIgnoreCase("6"))) {
                ZooManagerPrinter.printPleaseMakeSure();
            }

            switch (choice) {

                case "1":
                    boolean validAnimalType = false;
                    String animalType = "";
                    while (!validAnimalType) {
                        System.out.print(Constant_Class.ENTER_ANIMAL_TYPE_BEG);
                        System.out.println(Constant_Class.ENTER_ANIMAL_TYPE);
                        animalType = ip.nextLine().trim().toLowerCase();
                        if (animalType.equals("lion") || animalType.equals("cow") || animalType.equals("crocodile") ||
                                animalType.equals("snake") || animalType.equals("peacock")
                                || animalType.equals("eagle")) {
                            validAnimalType = true;
                        } else {
                            ZooManagerPrinter.printInvalidAnimalTypeMessage();
                        }
                    }

                    System.out.println();
                    String name = "";

                    while (name.isEmpty() || !name.matches("[a-zA-Z]+")) {
                        ZooManagerPrinter.printEnterAnimalNamePrompt();
                        name = ip.nextLine().trim();
                        if (!name.matches("[a-zA-Z]+")) {
                            ZooManagerPrinter.printEnterValidName();
                        }
                    }

                    int age = 0;
                    boolean validAge = false;
                    while (!validAge) {
                        try {
                            System.out.print(Constant_Class.ENTER_AGE);
                            age = Integer.parseInt(ip.nextLine());
                            if (age >= 1) {
                                validAge = true;
                            } else {
                                ZooManagerPrinter.printInvalidAgeMessage();
                            }
                        } catch (NumberFormatException e) {
                            ZooManagerPrinter.printAgeMustBeValidNumber();
                        }
                    }

                    double weight = 0.0;
                    boolean validWeight = false;
                    while (!validWeight) {
                        try {
                            ZooManagerPrinter.printEnterWeightPrompt();
                            weight = Double.parseDouble(ip.nextLine());
                            if (weight >= 1) {
                                validWeight = true;
                            } else {
                                ZooManagerPrinter.printInvalidWeightMessage();
                            }
                        } catch (NumberFormatException e) {
                            ZooManagerPrinter.printValidNumberForWeight();
                        }
                    }

                    Animal animal = Animal_Factory.createAnimalObj(animalType, name, age, weight);
                    System.out.println("Animal ID: " + animal.getId());

                    if (zoo.allocateAnimal(animal)) {
                        ZooManagerPrinter.printAnimalAddSuccessMessage();
                    } else {
                        ZooManagerPrinter.printFailInsertAnimalMessage();
                    }
                    break;

                case "2":
                    ZooManagerPrinter.printZooDetailsHeader(zooName);
                    zoo.showZooDetails();
                    break;

                case "3":
                    ZooManagerPrinter.printRemoveAnimalByIdPrompt();
                    try {
                        int animalId = Integer.parseInt(ip.nextLine());

                        if (zoo.removeAnimalById(animalId)) {
                            System.out.println("Animal with ID " + animalId + " removed from Zoo.");
                        } else {
                            System.out.println("Animal with ID " + animalId + " not present in the Zoo.");
                        }
                    } catch (IllegalArgumentException e) {
                        ZooManagerPrinter.printPleaseMakeSure();
                    }
                    break;

                case "4":
                    int aa = 0;
                    boolean validAnimalId = false;

                    while (!validAnimalId) {
                        try {
                            ZooManagerPrinter.printEnterAnimalId();
                            String input = ip.nextLine();
                            aa = Integer.parseInt(input);

                            if (aa >= 1000 && aa <= 1050) {
                                validAnimalId = true;
                            } else {
                                ZooManagerPrinter.printPleaseMakeSure();
                            }
                        } catch (NumberFormatException e) {
                            ZooManagerPrinter.printPleaseMakeSure();
                        }
                    }

                    zoo.getAnimalDetailsById(aa);
                    break;

                case "5":
                    ZooManagerPrinter.printZoneIdPrompt();
                    int Zid = 0;
                    try {
                        Zid = Integer.parseInt(ip.nextLine());
                    } catch (NumberFormatException e) {
                        ZooManagerPrinter.printPleaseMakeSure();
                        break;
                    }
                    zoo.viewZoneById(Zid);
                    break;

                case "6":
                    flag = true;
                    System.out.println(Constant_Class.GOOD_BYY);
                    break;

                default:
            }
        }

    }
}
