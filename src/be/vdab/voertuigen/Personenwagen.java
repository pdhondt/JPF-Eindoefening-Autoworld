package be.vdab.voertuigen;

import java.io.Serial;

public class Personenwagen extends Voertuig {
    private int zitplaatsen = 1;
    @Serial
    private static final long serialVersionUID = 1L;

    public Personenwagen(String merk, int aankoopprijs, int zitplaatsen) {
        super(merk, aankoopprijs);
        setZitplaatsen(zitplaatsen);
    }

    public int getZitplaatsen() {
        return zitplaatsen;
    }

    public final void setZitplaatsen(int zitplaatsen) {
        if (zitplaatsen <= 0) {
            throw new IllegalArgumentException("zitplaatsen mag niet 0 of negatief zijn");
        } else {
            this.zitplaatsen = zitplaatsen;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "Personenwagen{" +
                "zitplaatsen=" + zitplaatsen +
                '}';
    }
}
