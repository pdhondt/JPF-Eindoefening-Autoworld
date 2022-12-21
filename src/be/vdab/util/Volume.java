package be.vdab.util;

import java.io.Serial;
import java.io.Serializable;

public record Volume(int breedte, int hoogte, int diepte, Maat maat) implements Comparable<Volume>, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    public Volume {
        if (breedte < 0 || hoogte < 0 || diepte < 0) {
            throw new VolumeException("Geen negatieve waardes toegelaten");
        }
    }

    public double getVolume() {
        return maat.getWaardeInMeter(breedte) * maat.getWaardeInMeter(hoogte) * maat.getWaardeInMeter(diepte);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Volume volume = (Volume) o;
        return breedte == volume.breedte && hoogte == volume.hoogte && diepte == volume.diepte && maat == volume.maat;
    }

    @Override
    public int compareTo(Volume v) {
        return (int) getVolume() - (int) v.getVolume();
    }

}
