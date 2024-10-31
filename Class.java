package ShipOrganizer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static ShipOrganizer.Main.classes;

public class Class {
    private String name;
    private int meterage;
    private String nation;

    public Class(String name, int meterage, String nation) {
        this.name = name;
        this.meterage = meterage;
        this.nation = nation;
    }

    public String toString() { return (this.nation + " " + this.name + "-Class (" + this.meterage + "m)"); }

    public String toStringFile() { return (this.nation + "|" + this.name + "|" + this.meterage); }

    public String getName() { return this.name; }

    public int getMeterage() {return this.meterage; }

    public String getNation() { return this.nation; }

    public static void importClasses() throws IOException {
        File fileNameClasses = new File("src\\classes.txt");
        fileNameClasses.createNewFile();
        Scanner fileClasses = new Scanner(fileNameClasses);
        String tempHolder;
        String[] holderArray;
        String name;
        String nation;
        int meterage;
        while(fileClasses.hasNext()) {
            tempHolder = fileClasses.nextLine();
            holderArray = tempHolder.split("\\|");
            nation = holderArray[0];
            name = holderArray[1];
            meterage = Integer.parseInt(holderArray[2]);
            classes.add(new Class(name, meterage, nation));
        }
        fileClasses.close();
        System.out.println("Classes file imported from / created at:\n" + fileNameClasses.getAbsolutePath());
    }

    public static void exportClasses() throws IOException {
        File fileNameClasses = new File("src\\classes.txt");
        FileWriter nameClassesWriter = new FileWriter("src\\classes.txt");
        for(int i = 0; i < classes.size(); i++) {
            nameClassesWriter.write(classes.get(i).toStringFile() + "\n");
        }
        nameClassesWriter.close();
        System.out.println("Classes saved at:\n" + fileNameClasses.getAbsolutePath());
    }
}
