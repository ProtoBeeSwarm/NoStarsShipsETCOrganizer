package ShipOrganizer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static ShipOrganizer.Main.classes;
import static ShipOrganizer.Main.ships;

public class Ship {
    private String name;
    private String shipClass;
    private int meterage;
    private String nation;

    public Ship(String name, String shipClass, int meterage, String nation) {
        this.name = name;
        this.shipClass = shipClass;
        this.meterage = meterage;
        this.nation = nation;
    }

    public String toString() { return (this.nation + " '" + this.name + "' " + this.shipClass + "-Class (" + this.meterage + "m)");}

    public String toStringFleet() { return ("'" + this.name + "' " + this.shipClass + "-Class (" + this.meterage + "m)"); }

    public String toStringFile() { return (this.nation + "|" + this.name + "|" + this.shipClass + "|" + this.meterage); }

    public String getName() { return this.name; }

    public String getShipClass() { return this.shipClass; }

    public int getMeterage() {return this.meterage; }

    public String getNation() { return this.nation; }

    public static void importShips() throws IOException {
        File fileNameShips = new File("src\\ships.txt");
        fileNameShips.createNewFile();
        Scanner fileShips = new Scanner(fileNameShips);
        String tempHolder;
        String[] holderArray;
        String nation;
        String shipClass;
        String name;
        int meterage;
        while(fileShips.hasNext()) {
            tempHolder = fileShips.nextLine();
            holderArray = tempHolder.split("\\|");
            nation = holderArray[0];
            name= holderArray[1];
            shipClass = holderArray[2];
            meterage = Integer.parseInt(holderArray[3]);
            ships.add(new Ship(name, shipClass, meterage, nation));
        }
        fileShips.close();
        System.out.println("Ships file imported from / created at:\n" + fileNameShips.getAbsolutePath());
    }

    public static void  exportShips() throws IOException {
        File fileNameShips = new File("src\\ships.txt");
        FileWriter nameShipsWriter = new FileWriter("src\\ships.txt");
        for(int i = 0; i < ships.size(); i++) {
            nameShipsWriter.write(ships.get(i).toStringFile() + "\n");
        }
        nameShipsWriter.close();
        System.out.println("Ships saved at:\n" + fileNameShips.getAbsolutePath());
    }
}
