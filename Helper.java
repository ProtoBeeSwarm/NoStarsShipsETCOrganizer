package ShipOrganizer;

public class Helper extends Main {

    public static Ship newShip() {
        System.out.println("""
                Enter parameters in format:
                name, class, meterage, nation
                name, class (meterage and nation imported from existing class)
                name, class, nation (meterage imported from existing class)""");
        tempHolder = scanner.nextLine();
        holderArray = tempHolder.split(", ");
        if (holderArray.length == 4) {
            shipHolder = new Ship(holderArray[0], holderArray[1], Integer.parseInt(holderArray[2]), holderArray[3]);
            if (ships.isEmpty()) {
                return shipHolder;
            } else {
                for (int i = 0; i < ships.size(); i++) {
                    if (ships.get(i).equals(shipHolder)) {
                        System.out.println("Ship already exists.");
                        return null;
                    }
                }
                return shipHolder;
            }
        } else if (holderArray.length == 3) {
            for (int i = 0; i < classes.size(); i++) {
                if (classes.get(i).getName().equals(holderArray[1])) {
                    shipHolder = new Ship(holderArray[0], holderArray[1], classes.get(i).getMeterage(), holderArray[2]);
                    if (ships.isEmpty()) {
                        return shipHolder;
                    } else {
                        for (int j = 0; j < ships.size(); j++) {
                            if (ships.get(j).equals(shipHolder)) {
                                System.out.println("Ship already exists.");
                                return null;
                            }
                        }
                        return shipHolder;
                    }
                } else {
                    System.out.println("Class does not exist.");
                    return null;
                }
            }
            System.out.println("Class does not exist.");
            return null;
        } else if (holderArray.length == 2) {
            for (int i = 0; i < classes.size(); i++) {
                if (classes.get(i).getName().equals(holderArray[1])) {
                    shipHolder = new Ship(holderArray[0], holderArray[1], classes.get(i).getMeterage(), classes.get(i).getNation());
                    if (ships.isEmpty()) {
                        return shipHolder;
                    } else {
                        for (int j = 0; j < ships.size(); j++) {
                            if (ships.get(j).equals(shipHolder)) {
                                System.out.println("Ship already exists.");
                                return null;
                            }
                        }
                        return shipHolder;
                    }
                } else {
                    System.out.println("Class does not exist.");
                    return null;
                }
            }
            System.out.println("Class does not exist.");
            return null;
        } else {
            System.out.println("Invalid entry.");
            return null;
        }
    }

    public static Squadron newSquadron() {
        System.out.println("""
                Enter parameters in format:
                name, craft class, size, nation
                name, craftClass, size (nation imported from existing craft class)""");
        tempHolder = scanner.nextLine();
        holderArray = tempHolder.split(", ");
        if(holderArray.length == 4) {
            squadronHolder = new Squadron(holderArray[0], holderArray[1], Integer.parseInt(holderArray[2]), holderArray[3]);
            if(squadrons.isEmpty()) {
                return squadronHolder;
            } else {
                for(int i = 0; i < squadrons.size(); i++) {
                    if(squadrons.get(i).equals(squadronHolder)) {
                        System.out.println("Squadron already exists.");
                        return null;
                    }
                }
                return squadronHolder;
            }
        } else if(holderArray.length == 3) {
            for (int i = 0; i < squadrons.size(); i++) {
                if (squadrons.get(i).getCraftClass().equals(holderArray[1])) {
                    squadronHolder = new Squadron(holderArray[0], holderArray[1], Integer.parseInt(holderArray[2]), squadrons.get(i).getNation());
                    if (squadrons.isEmpty()) {
                        return squadronHolder;
                    } else {
                        for (int j = 0; j < squadrons.size(); j++) {
                            if (squadrons.get(j).equals(squadronHolder)) {
                                System.out.println("Squadron already exists.");
                                return null;
                            }
                        }
                        return squadronHolder;
                    }
                } else {
                    System.out.println("Craft class does not exist.");
                    return null;
                }
            }
        } else {
            System.out.println("Invalid entry.");
            return null;
        }
        return null;
    }

    public static Class newClass() {
        System.out.println("Enter parameters in format:\nname, meterage, nation");
        tempHolder = scanner.nextLine();
        holderArray = tempHolder.split(", ");
        classHolder = new Class(holderArray[0], Integer.parseInt(holderArray[1]), holderArray[2]);
        if (classes.isEmpty()) {
            return classHolder;
        } else {
            for (int i = 0; i < classes.size(); i++) {
                if (classes.get(i).equals(classHolder)) {
                    System.out.println("Class already exists.");
                    return null;
                } else {
                    return classHolder;
                }
            }
        }
        return null;
    }

    public static Fleet newFleet() {
        System.out.println("Enter parameters in format:\nname, nation");
        tempHolder = scanner.nextLine();
        holderArray = tempHolder.split(", ");
        fleetHolder = new Fleet(holderArray[0], holderArray[1]);
        if (fleets.isEmpty()) {
            return fleetHolder;
        } else {
            for (int i = 0; i < fleets.size(); i++) {
                if (fleets.get(i).getName().equals(fleetHolder.getName()) && fleets.get(i).getNation().equals(fleetHolder.getNation())) {
                    System.out.println("Fleet already exists.");
                    return null;
                } else {
                    return fleetHolder;
                }
            }
        }
        return null;
    }

    public static void removeShip() {
        System.out.println("Ship to remove in format:\nname, class, meterage, nation");
        tempHolder = scanner.nextLine();
        holderArray = tempHolder.split(", ");
        shipHolder = new Ship(holderArray[0], holderArray[1], Integer.parseInt(holderArray[2]), holderArray[3]);
        for (int i = 0; i < ships.size(); i++) {
            if (ships.get(i).equals(shipHolder)) {
                ships.remove(i);
                System.out.println("Ship removed.");
                return;
            }
        }
        System.out.println("Ship does not exist.");
    }

    public static void removeClass() {
        System.out.println("Class to remove in format:\nname, meterage, nation");
        tempHolder = scanner.nextLine();
        holderArray = tempHolder.split(", ");
        classHolder = new Class(holderArray[0], Integer.parseInt(holderArray[1]), holderArray[2]);
        for (int i = 0; i < classes.size(); i++) {
            if (classes.get(i).equals(classHolder)) {
                classes.remove(i);
                System.out.println("Class removed.");
                return;
            }
        }
        System.out.println("Class does not exist.");
    }

    public static void removeFleet() {
        System.out.println("Fleet to remove in format:\nname, nation");
        tempHolder = scanner.nextLine();
        holderArray = tempHolder.split(", ");
        for (int i = 0; i < fleets.size(); i++) {
            if (fleets.get(i).getName().equals(holderArray[0]) && fleets.get(i).getNation().equals(holderArray[1])) {
                fleets.remove(i);
                System.out.println("Fleet removed.");
                return;
            }
        }
        System.out.println("FLeet does not exist.");
    }

    public static Ship locateShip() {
        System.out.println("""
                Enter parameters in format:
                name, class, meterage, nation
                name, class (meterage and nation imported from existing class)
                name, class, nation (meterage imported from existing class)""");
        tempHolder = scanner.nextLine();
        holderArray = tempHolder.split(", ");
        if (holderArray.length == 4) {
            shipHolder = new Ship(holderArray[0], holderArray[1], Integer.parseInt(holderArray[2]), holderArray[3]);
        } else if (holderArray.length == 3) {
            for (int i = 0; i < classes.size(); i++) {
                if (classes.get(i).getName().equals(tempHolder)) {
                    shipHolder = new Ship(holderArray[0], holderArray[1], classes.get(i).getMeterage(), holderArray[2]);
                }
            }
            System.out.println("Class does not exist.");
            return null;
        } else if (holderArray.length == 2) {
            for (int i = 0; i < classes.size(); i++) {
                if (classes.get(i).getName().equals(tempHolder)) {
                    shipHolder = new Ship(holderArray[0], holderArray[1], classes.get(i).getMeterage(), classes.get(i).getNation());
                }
            }
            System.out.println("Class does not exist.");
            return null;
        } else {
            System.out.println("Invalid entry.");
            return null;
        }
        for (int i = 0; i < ships.size(); i++) {
            if (ships.get(i).equals(shipHolder)) {
                return ships.get(i);
            }
        }
        System.out.println("Ship does not exist");
        return null;
    }

    public static Class locateClass() {
        System.out.println("Enter parameters in format:\nname, meterage, nation");
        tempHolder = scanner.nextLine();
        holderArray = tempHolder.split(", ");
        classHolder = new Class(holderArray[0], Integer.parseInt(holderArray[1]), holderArray[2]);
        if (classes.isEmpty()) {
            System.out.println("Class does not exist.");
            return null;
        } else {
            for (int i = 0; i < classes.size(); i++) {
                if (classes.get(i).equals(classHolder)) {
                    return classes.get(i);
                } else {
                    System.out.println("Class does not exist.");
                    return null;
                }
            }
        }
        System.out.println("Class does not exist.");
        return null;
    }

    public static Fleet locateFleet() {
        System.out.println("Enter parameters in format:\nname, nation");
        tempHolder = scanner.nextLine();
        holderArray = tempHolder.split(", ");
        fleetHolder = new Fleet(holderArray[0], holderArray[1]);
        if (fleets.isEmpty()) {
            System.out.println("Fleet does not exist.");
            return null;
        } else {
            for (int i = 0; i < fleets.size(); i++) {
                if (fleets.get(i).getName().equals(fleetHolder.getName()) && fleets.get(i).getNation().equals(fleetHolder.getNation())) {
                    return fleets.get(i);
                }
            }
        }
        System.out.println("Fleet does not exist.");
        return null;
    }

    public static void listShips() {
        StringBuilder tempHolder_temp = new StringBuilder();
        for (int i = 0; i < ships.size(); i++) {
            tempHolder_temp.append("\n").append(ships.get(i).toString());
        }
        tempHolder = tempHolder_temp.toString();
        System.out.println("Listing all ships:" + tempHolder);
    }

    public static void listShipsClass() {
        System.out.println("Class to list all ships of:");
        tempHolder = scanner.nextLine();
        StringBuilder tempHolder_temp = new StringBuilder();
        for (int i = 0; i < classes.size(); i++) {
            if (classes.get(i).getName().equals(tempHolder)) {
                for (int j = 0; j < ships.size(); j++) {
                    if (ships.get(j).getShipClass().equals(tempHolder)) {
                        tempHolder_temp.append("\n").append(ships.get(j).toString());
                    }
                }
            }
        }
        tempHolder = tempHolder_temp.toString();
        System.out.println("Listing all ships of class:" + tempHolder);
    }

    public static void listShipsNation() {
        System.out.println("Nation to list all ships of:");
        tempHolder = scanner.nextLine();
        StringBuilder tempHolder_temp = new StringBuilder();
        for (int i = 0; i < ships.size(); i++) {
            if (ships.get(i).getNation().equals(tempHolder)) {
                tempHolder_temp.append("\n").append(ships.get(i).toString());
            }
        }
        tempHolder = tempHolder_temp.toString();
        System.out.println("Listing all ships of nation:" + tempHolder);
    }

    public static void listShipsMeterage() {
        System.out.println("Meterage to list all ships of:");
        tempHolder = scanner.nextLine();
        StringBuilder tempHolder_temp = new StringBuilder();
        for (int i = 0; i < ships.size(); i++) {
            if (ships.get(i).getMeterage() == Integer.parseInt(tempHolder)) {
                tempHolder_temp.append("\n").append(ships.get(i).toString());
            }
        }
        tempHolder = tempHolder_temp.toString();
        System.out.println("Listing all ships of meterage:" + tempHolder);
    }

    public static void listClasses() {
        StringBuilder tempHolder_temp = new StringBuilder();
        for (int i = 0; i < classes.size(); i++) {
            tempHolder_temp.append("\n").append(classes.get(i).toString());
        }
        tempHolder = tempHolder_temp.toString();
        System.out.println("Listing all ships:" + tempHolder);
    }

    public static void listClassesNation() {
        System.out.println("Nation to list all classes of:");
        tempHolder = scanner.nextLine();
        StringBuilder tempHolder_temp = new StringBuilder();
        for (int i = 0; i < classes.size(); i++) {
            if (classes.get(i).getNation().equals(tempHolder)) {
                tempHolder_temp.append("\n").append(classes.get(i).toString());
            }
        }
        tempHolder = tempHolder_temp.toString();
        System.out.println("Listing all classes of nation:" + tempHolder);
    }

    public static void listClassesMeterage() {
        System.out.println("Meterage to list all classes of:");
        tempHolder = scanner.nextLine();
        StringBuilder tempHolder_temp = new StringBuilder();
        for (int i = 0; i < classes.size(); i++) {
            if (classes.get(i).getMeterage() == Integer.parseInt(tempHolder)) {
                tempHolder_temp.append("\n").append(classes.get(i).toString());
            }
        }
        tempHolder = tempHolder_temp.toString();
        System.out.println("Listing all classes of meterage:" + tempHolder);
    }

    public static void listFleets() {
        StringBuilder tempHolder_temp = new StringBuilder();
        for (int i = 0; i < fleets.size(); i++) {
            tempHolder_temp.append("\n").append(fleets.get(i).toStringNoComp());
        }
        tempHolder = tempHolder_temp.toString();
        System.out.println("Listing all ships:" + tempHolder);
    }

    public static void listFleetsNation() {
        System.out.println("Nation to list all fleets of:");
        tempHolder = scanner.nextLine();
        StringBuilder tempHolder_temp = new StringBuilder();
        for (int i = 0; i < fleets.size(); i++) {
            if (fleets.get(i).getNation().equals(tempHolder)) {
                tempHolder_temp.append("\n").append(fleets.get(i).toStringNoComp());
            }
        }
        tempHolder = tempHolder_temp.toString();
        System.out.println("Listing all fleets of nation:" + tempHolder);
    }

    public static void listFleetsSize() {
        System.out.println("Size to list all fleets of:");
        tempHolder = scanner.nextLine();
        StringBuilder tempHolder_temp = new StringBuilder();
        for (int i = 0; i < fleets.size(); i++) {
            if (fleets.get(i).getSize() == Integer.parseInt(tempHolder)) {
                tempHolder_temp.append("\n").append(fleets.get(i).toString());
            }
        }
        tempHolder = tempHolder_temp.toString();
        System.out.println("Listing all fleets of size:" + tempHolder);
    }

    public static void addToFleet() {
        System.out.println("Add (existing) ship or (new) ship:");
        switch(scanner.nextLine()) {
            default -> System.out.println("Invalid entry.");
            case "existing" -> {
                shipHolder = Helper.locateShip();
                fleets.get(indexHolder).addShip(shipHolder);
                System.out.println("Ship added to fleet:\n" + shipHolder.toString() + "\nto " + fleets.get(indexHolder).toStringNoComp());
            }
            case "new" -> {
                shipHolder = Helper.newShip();
                fleets.get(indexHolder).addShip(shipHolder);
                ships.add(shipHolder);
                System.out.println("Ship created and added to fleet:\n" + shipHolder.toString() + "\nto " + fleets.get(indexHolder).toStringNoComp());
            }
        }
    }
}
