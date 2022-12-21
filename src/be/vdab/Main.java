package be.vdab;

import be.vdab.schoolgerief.Boekentas;
import be.vdab.util.Laadbaar;
import be.vdab.util.Maat;
import be.vdab.util.Volume;
import be.vdab.util.VolumeException;
import be.vdab.voertuigen.Personenwagen;
import be.vdab.voertuigen.Pickup;
import be.vdab.voertuigen.Voertuig;
import be.vdab.voertuigen.Vrachtwagen;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    private static final Path PATH = Path.of("wagenpark.dat");

    public static void main(String[] args) {
        Set<Voertuig> voertuigen = new TreeSet<>();
        try {
            voertuigen.add(new Personenwagen("Honda", 35000, 5));
            voertuigen.add(new Personenwagen("Kia", 45000, 3));
            voertuigen.add(new Pickup("Toyota", 55000, 7, new Volume(225, 175, 405, Maat.CENTIMETER)));
            voertuigen.add(new Pickup("Ford", 65000, 9, new Volume(245, 195, 425, Maat.CENTIMETER)));
            voertuigen.add(new Vrachtwagen("Mercedes", 135000, new Volume(275, 205, 1523, Maat.CENTIMETER), 5000, 2));
            voertuigen.add(new Vrachtwagen("Daf", 165000, new Volume(295, 225, 1805, Maat.CENTIMETER), 7000, 3));
        } catch (IllegalArgumentException | VolumeException ex) {
            System.err.println(ex.getMessage());
        }

        System.out.println("\nWeergave TreeSet voertuigen:");
        for (var voertuig : voertuigen) {
            System.out.println(voertuig);
        }

        try (var stream = new ObjectOutputStream(Files.newOutputStream(PATH))) {
            stream.writeObject(voertuigen);
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }

        System.out.println("\nWeergave inhoud wagenpark.dat:");
        try (var stream = new ObjectInputStream(Files.newInputStream(PATH))) {
            var setVoertuigen = (TreeSet<Voertuig>) stream.readObject();
            setVoertuigen.stream().forEach(voertuig -> System.out.println(voertuig));
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace(System.err);
        }

        System.out.println("\nAanmaken en tonen Boekentas objecten:");
        var boekentas1 = new Boekentas("rood", new Volume(40, 30, 10, Maat.CENTIMETER));
        System.out.println(boekentas1);
        var boekentas2 = new Boekentas("blauw", new Volume(50, 40, 20, Maat.CENTIMETER));
        System.out.println(boekentas2);

        System.out.println("\nAanmaak en weergave Array met objecten van type Laadbaar:");
        var laadbareObjecten = new Laadbaar[4];
        laadbareObjecten[0] = new Pickup("Toyota", 55000, 7, new Volume(225, 175, 405, Maat.CENTIMETER));
        laadbareObjecten[1] = new Vrachtwagen("Daf", 165000, new Volume(295, 225, 1805, Maat.CENTIMETER), 7000, 3);
        laadbareObjecten[2] = boekentas1;
        laadbareObjecten[3] = boekentas2;

        Arrays.stream(laadbareObjecten).forEach(laadbaarObject -> System.out.println(laadbaarObject));

        var totaalLaadvolume = 0.0;
        for (var laadbaarObject : laadbareObjecten) {
            totaalLaadvolume += laadbaarObject.getLaadvolume().getVolume();
        }
        System.out.println("\nHet totale laadvolume bedraagt " + totaalLaadvolume + "m3");

    }
}
