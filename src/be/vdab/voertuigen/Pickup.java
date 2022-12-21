package be.vdab.voertuigen;

import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;

import java.io.Serial;

public class Pickup extends Personenwagen implements Laadbaar {
    private Volume laadvolume;
    @Serial
    private static final long serialVersionUID = 1L;

    public Pickup(String merk, int aankoopprijs, int zitplaatsen, Volume laadvolume) {
        super(merk, aankoopprijs, zitplaatsen);
        setLaadvolume(laadvolume);
    }


    @Override
    public Volume getLaadvolume() {
        return laadvolume;
    }

    @Override
    public void setLaadvolume(Volume laadvolume) {
        this.laadvolume = laadvolume;
    }

    @Override
    public String toString() {
        return super.toString() + "Pickup{" +
                "laadvolume=" + laadvolume +
                '}';
    }

}
