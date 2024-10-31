package ShipOrganizer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static ShipOrganizer.Main.fleets;

public class Fleet {
    private String name;
    private String nation;
    private ArrayList<Ship> ships = new ArrayList<Ship>();

    public Fleet(String name, String nation) {
        this.name = name;
        this.nation = nation;
    }

    public void addShip(Ship ship) { ships.add(ship); }

    public String toString() {
        String composition = (this.nation + " '" + this.name + "' (" + ships.size() + " Ships):");
        for(int i = 0; i < ships.size(); i++) {
            composition = ("\n" + ships.get(i).toString());
        }
        return composition;
    }

    public String toStringFile() {
        return (this.nation + "|" + this.name + "|" + this.getSize() + this.getCompositionFile());
    }

    public String toStringNoComp() {
        return (this.nation + " '" + this.name + "' (" + ships.size() + " Ships)");
    }

    public String getName() { return this.name; }

    public String getNation() { return this.nation; }

    public int getSize() { return this.ships.size(); }

    public ArrayList<Ship> getCompositionShip() { return this.ships; }

    public String getComposition() {
        String composition = "";
        for(int i = 0; i < this.ships.size(); i++) {
            composition += (this.ships.get(i).toStringFleet() + "\n");
        }
        return composition;
    }

    public String getCompositionFile() {
        StringBuilder composition = new StringBuilder();
        for(int i = 0; i < this.ships.size(); i++) {
            composition.append("\n").append(this.ships.get(i).toStringFile());
        }
        return composition.toString();
    }

    public static void importFleets() throws IOException {
        File fileNameFleets = new File("src\\fleets.txt");
        fileNameFleets.createNewFile();
        Scanner fileFleets = new Scanner(fileNameFleets);
        String tempHolder;
        String[] holderArray;
        String shipClass;
        int meterage;
        String nation;
        String name;
        while(fileFleets.hasNext()) {
            tempHolder = fileFleets.nextLine();
            holderArray = tempHolder.split("\\|");
            nation = holderArray[0];
            name = holderArray[1];
            for(int i = 0; i < Integer.parseInt(holderArray[2]); i++) {
                tempHolder = fileFleets.nextLine();
                holderArray = tempHolder.split("\\|");
                nation = holderArray[0];
                name= holderArray[1];
                shipClass = holderArray[2];
                meterage = Integer.parseInt(holderArray[3]);
                fleets.get(i).addShip(new Ship(name, shipClass, meterage, nation));
            }
        }
        fileFleets.close();
        System.out.println("Fleets file imported from / created at:\n" + fileNameFleets.getAbsolutePath());
    }

    public static void exportFleets() throws IOException {
        File fileNameFleets = new File("src\\fleets.txt");
        FileWriter nameFleetsWriter = new FileWriter("src\\fleets.txt");
        for(int i = 0; i < fleets.size(); i++) {
            nameFleetsWriter.write(fleets.get(i).toStringFile() + "\n");
        }
        nameFleetsWriter.close();
        System.out.println("Fleets saved at:\n" + fileNameFleets.getAbsolutePath());
    }
}
