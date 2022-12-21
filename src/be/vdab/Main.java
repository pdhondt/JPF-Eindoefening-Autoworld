package be.vdab;

import be.vdab.util.Maat;
import be.vdab.util.Volume;
import be.vdab.util.VolumeException;
import be.vdab.voertuigen.Personenwagen;
import be.vdab.voertuigen.Pickup;
import be.vdab.voertuigen.Voertuig;
import be.vdab.voertuigen.Vrachtwagen;

import java.nio.file.Path;
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

        for (var voertuig : voertuigen) {
            System.out.println(voertuig);
        }
    }
}
