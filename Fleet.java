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
        return (this.nation + " '" + this.name + "' (" + ships.size() + " Ships):" + getComposition());
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
        StringBuilder composition = new StringBuilder();
        for(int i = 0; i < this.ships.size(); i++) {
            composition.append("\n").append(this.ships.get(i).toStringFleet());
        }
        return composition.toString();
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
        String[] holderArray2;
        int j = 0;
        String shipClass;
        int meterage;
        String nation;
        String name;
        while(fileFleets.hasNext()) {
            tempHolder = fileFleets.nextLine();
            holderArray = tempHolder.split("\\|");
            nation = holderArray[0];
            name = holderArray[1];
            fleets.add(new Fleet(name, nation));
            for(int i = 0; i < Integer.parseInt(holderArray[2]); i++) {
                tempHolder = fileFleets.nextLine();
                holderArray2 = tempHolder.split("\\|");
                nation = holderArray2[0];
                name= holderArray2[1];
                shipClass = holderArray2[2];
                meterage = Integer.parseInt(holderArray2[3]);
                fleets.get(j).addShip(new Ship(name, shipClass, meterage, nation));
            }
            j++;
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
