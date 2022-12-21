package be.vdab.voertuigen;

import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;

import java.io.Serial;

public class Vrachtwagen extends Voertuig implements Laadbaar {
    private Volume laadvolume;
    private int maximaalToegelatenMassa, aantalAssen;
    @Serial
    private static final long serialVersionUID = 1L;

    public Vrachtwagen(String merk, int aankoopprijs, Volume laadvolume, int maximaalToegelatenMassa, int aantalAssen) {
        super(merk, aankoopprijs);
        this.laadvolume = laadvolume;
        setMaximaalToegelatenMassa(maximaalToegelatenMassa);
        setAantalAssen(aantalAssen);
    }


    @Override
    public Volume getLaadvolume() {
        return laadvolume;
    }

    @Override
    public void setLaadvolume(Volume laadvolume) {
        this.laadvolume = laadvolume;
    }

    public int getMaximaalToegelatenMassa() {
        return maximaalToegelatenMassa;
    }

    public void setMaximaalToegelatenMassa(int maximaalToegelatenMassa) {
        if (maximaalToegelatenMassa <= 0) {
            throw new IllegalArgumentException("maximaalToegelatenMassa mag niet 0 of negatief zijn");
        } else {
            this.maximaalToegelatenMassa = maximaalToegelatenMassa;
        }
    }

    public int getAantalAssen() {
        return aantalAssen;
    }

    public void setAantalAssen(int aantalAssen) {
        if (aantalAssen <= 0) {
            throw new IllegalArgumentException("aantalAssen mag niet 0 of negatief zijn");
        } else {
            this.aantalAssen = aantalAssen;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "Vrachtwagen{" +
                "laadvolume=" + laadvolume +
                ", maximaalToegelatenMassa=" + maximaalToegelatenMassa +
                ", aantalAssen=" + aantalAssen +
                '}';
    }
}
