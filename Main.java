package ShipOrganizer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Ship> ships = new ArrayList<Ship>();
    static ArrayList<Class> classes = new ArrayList<Class>();
    static ArrayList<Fleet> fleets = new ArrayList<Fleet>();
    static ArrayList<Squadron> squadrons = new ArrayList<Squadron>();

    static Scanner scanner = new Scanner(System.in);
    static String tempHolder;
    static String[] holderArray;
    static Ship shipHolder;
    static Squadron squadronHolder;
    static Class classHolder;
    static Fleet fleetHolder;
    static int indexHolder;

    public static void main(String[] args) throws IOException {
        do {
            System.out.println("Input command - use \"help\" to list available commands");
            switch(scanner.nextLine()) {
                case "help" -> System.out.println("""
                        Available commands:
                        new -- Creates a new ship, squadron, class, or fleet
                        remove -- Deletes a ship, squadron, class, or fleet
                        locate -- locate a specific ship, squadron, class, or fleet
                        list -- lists all ships, squadrons, classes, or fleets with or without specification
                        manage fleets -- enter fleet managment options
                        import -- Imports existing ships, squadrons, classes, and fleets from specific files
                        export -- saves current ships, squadrons, classes, and fleets to a file
                        exit -- quit program""");
                case "exit" -> System.exit(0);
                case "new" -> {
                    System.out.println("Create a new (ship, squadron, class, fleet):");
                    switch(scanner.nextLine()) {
                        default -> System.out.println("Invalid entry.");
                        case "ship" -> {
                            shipHolder = Helper.newShip();
                            if(shipHolder != null) {
                                ships.add(shipHolder);
                                System.out.println("Ship created:\n" + shipHolder.toString());
                            }
                        }
                        case "class" -> {
                            classHolder = Helper.newClass();
                            if(classHolder != null) {
                                classes.add(classHolder);
                                System.out.println("Class created:\n" + classHolder.toString());
                            }
                        }
                        case "fleet" -> {
                            fleetHolder = Helper.newFleet();
                            if(fleetHolder != null) {
                                fleets.add(fleetHolder);
                                System.out.println("Fleet created:\n" + fleetHolder.toString());
                            }
                        }
                        case "squadron" -> {
                            squadronHolder = Helper.newSquadron();
                            if(squadronHolder != null) {
                                squadrons.add(squadronHolder);
                                System.out.println("Squadron created:\n" + squadronHolder.toString());
                            }
                        }
                    }
                }
                case "remove" -> {
                    System.out.println("Remove a (ship, class, fleet):");
                    switch(scanner.nextLine()) {
                        default -> System.out.println("Invalid entry.");
                        case "ship" -> { Helper.removeShip(); }
                        case "squadron" -> { Helper.removeSquadron(); }
                        case "class" -> { Helper.removeClass(); }
                        case "fleet" -> { Helper.removeFleet(); }
                    }
                }
                case "import" -> {
                    System.out.println("Import type (all, ships, squadrons, classes, fleets");
                    switch(scanner.nextLine()) {
                        default -> System.out.println("Invalid entry.");
                        case "all" -> {
                            System.out.println("Confirm import (y/n):");
                            if(scanner.nextLine().equals("y")) {
                                Class.importClasses();
                                Ship.importShips();
                                Squadron.importSquadrons();
                                Fleet.importFleets();
                            }
                        }
                        case "ships" -> {
                            System.out.println("Confirm import (y/n):");
                            if(scanner.nextLine().equals("y")) {
                                Ship.importShips();
                            }
                        }
                        case "classes" -> {
                            System.out.println("Confirm import (y/n):");
                            if(scanner.nextLine().equals("y")) {
                                Class.importClasses();
                            }
                        }
                        case "squadrons" -> {
                            System.out.println("Confirm import (y/n):");
                            if(scanner.nextLine().equals("y")) {
                                Squadron.importSquadrons();
                            }
                        }
                        case "fleets" -> {
                            System.out.println("Confirm import (y/n):");
                            if(scanner.nextLine().equals("y")) {
                                Fleet.importFleets();
                            }
                        }
                    }
                }
                case "export" -> {
                    System.out.println("Export type (all, ships, squadrons, classes, fleets):");
                    switch(scanner.nextLine()) {
                        default -> System.out.println("Invalid entry.");
                        case "all" -> {
                            System.out.println("Confirm export (y/n):");
                            if (scanner.nextLine().equals("y")) {
                                Class.exportClasses();
                                Ship.exportShips();
                                Squadron.importSquadrons();
                                Fleet.exportFleets();
                            }
                        }
                        case "ships" -> {
                            System.out.println("Confirm export (y/n):");
                            if(scanner.nextLine().equals("y")) {
                                Ship.exportShips();
                            }
                        }
                        case "squadrons" -> {
                            System.out.println("Confirm export (y/n):");
                            if(scanner.nextLine().equals("y")) {
                                Squadron.exportSquadrons();
                            }
                        }
                        case "classes" -> {
                            System.out.println("Confirm export (y/n):");
                            if(scanner.nextLine().equals("y")) {
                                Class.exportClasses();
                            }
                        }
                        case "fleets" -> {
                            System.out.println("Confirm export (y/n):");
                            if(scanner.nextLine().equals("y")) {
                                Fleet.exportFleets();
                            }
                        }
                    }
                }
                case "locate" -> {
                    System.out.println("Locate a (ship, squadron, class, fleet):");
                    switch(scanner.nextLine()) {
                        default -> System.out.println("Invalid entry.");
                        case "ship" -> {
                            shipHolder = Helper.locateShip();
                            if(shipHolder != null) {
                                System.out.println("Ship found:\n" + shipHolder.toString());
                            }
                        }
                        case "squadron" -> {
                            squadronHolder = Helper.locateSquadron();
                            if(squadronHolder != null) {
                                System.out.println("Squadron found:\n" + squadronHolder.toString());
                            }
                        }
                        case "class" -> {
                            classHolder = Helper.locateClass();
                            if(classHolder != null) {
                                System.out.println("Class found:\n" + classHolder.toString());
                            }
                        }
                        case "fleet" -> {
                            fleetHolder = Helper.locateFleet();
                            if (fleetHolder != null) {
                                System.out.println("Fleet found:\n" + fleetHolder.toString());
                            }
                        }
                    }
                }
                case "list" -> {
                    System.out.println("List (ships, squadrons, classes, fleets):");
                    switch(scanner.nextLine()) {
                        case "ships" -> {
                            System.out.println("List ships by (all, class, nation, meterage):");
                            switch(scanner.nextLine()) {
                                case "all" -> Helper.listShips();
                                case "class" -> Helper.listShipsClass();
                                case "nation" -> Helper.listShipsNation();
                                case "meterage" -> Helper.listShipsMeterage();
                                default -> System.out.println("Invalid entry.");
                            }
                        }
                        case "squadrons" -> {
                            System.out.println("List squadrons by (all, craft classs, nation, size):");
                            switch(scanner.nextLine()) {
                                case "all" -> Helper.listSquadrons();
                                case "craft class" -> Helper.listSquadronsClass();
                                case "nation" -> Helper.listSquadronsNation();
                                case "size" -> Helper.listSquadronsSize();
                                default -> System.out.println("Invalid entry");
                            }
                        }
                        case "classes" -> {
                            System.out.println("List classes by (all, nation, meterage):");
                            switch(scanner.nextLine()) {
                                case "all" -> Helper.listClasses();
                                case "nation" -> Helper.listClassesNation();
                                case "meterage" -> Helper.listClassesMeterage();
                                default -> System.out.println("Invalid entry.");
                            }
                        }
                        case "fleets" -> {
                            System.out.println("List all fleets by (all, nation, size)");
                            switch(scanner.nextLine()) {
                                case "all" -> Helper.listFleets();
                                case "nation" -> Helper.listFleetsNation();
                                case "size" -> Helper.listFleetsSize();
                                default -> System.out.println("Invalid entry.");
                            }
                        }
                        default -> System.out.println("Invalid entry.");
                    }
                }
                case "manage fleets" -> {
                    System.out.println("Fleet to manage:");
                    fleetHolder = Helper.locateFleet();
                    for (int i = 0; i < fleets.size(); i++) {
                        if (fleets.get(i).equals(fleetHolder)) {
                            indexHolder = i;
                        }
                    }
                    System.out.println("""
                            Fleet management to do:
                            add ship
                            composition""");
                    switch(scanner.nextLine()) {
                        default -> System.out.println("Invalid entry.");
                        case "add ship" -> Helper.addToFleet();
                        case "composition" -> System.out.println("Composition of fleet:\n" + fleets.get(indexHolder).toString());
                    }
                }
                default -> System.out.println("Invalid command.");
            }
        } while(true);
    }
}
