package ShipOrganizer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static ShipOrganizer.Main.ships;
import static ShipOrganizer.Main.squadrons;

public class Squadron {
    private String name;
    private String craftClass;
    private int size;
    private String nation;

    public Squadron(String name, String craftClass, int size, String nation) {
        this.name = name;
        this.craftClass = craftClass;
        this.size = size;
        this.nation = nation;
    }

    public String toString() { return (this.nation + " '" + this.name + "' - " + this.size + " " + this.craftClass + "-Class craft."); }

    public String toStringFile() { return (this.nation + "|" + this.name + "|" + this.size + "|" +this.craftClass); }

    public String getName() { return this.name; }

    public String getCraftClass() { return this.craftClass; }

    public String getNation() { return this.nation; }

    public int getSize() { return this.size; }

    public static void importSquadrons() throws IOException {
        File fileNameSquadrons = new File("src\\squadrons.txt");
        fileNameSquadrons.createNewFile();
        Scanner fileShips = new Scanner(fileNameSquadrons);
        String tempHolder;
        String[] holderArray;
        String nation;
        String craftClass;
        String name;
        int size;
        while (fileShips.hasNext()) {
            tempHolder = fileShips.nextLine();
            holderArray = tempHolder.split("\\|");
            nation = holderArray[0];
            name = holderArray[1];
            craftClass = holderArray[2];
            size = Integer.parseInt(holderArray[3]);
            ships.add(new Ship(name, craftClass, size, nation));
        }
        fileShips.close();
        System.out.println("Squadrons file imported from / created at:\n" + fileNameSquadrons.getAbsolutePath());
    }

    public static void  exportSquadrons() throws IOException {
        File fileNameSquadrons = new File("src\\squadrons.txt");
        FileWriter nameSquadronsWriter = new FileWriter(fileNameSquadrons);
        for(int i = 0; i < squadrons.size(); i++) {
            nameSquadronsWriter.write(squadrons.get(i).toStringFile() + "\n");
        }
        nameSquadronsWriter.close();
        System.out.println("Squadrons saved at:\n" + fileNameSquadrons.getAbsolutePath());
    }
}
