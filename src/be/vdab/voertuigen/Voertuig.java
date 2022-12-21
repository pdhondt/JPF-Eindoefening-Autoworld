package be.vdab.voertuigen;

import be.vdab.voertuigen.div.Div;
import be.vdab.voertuigen.div.Nummerplaat;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Voertuig implements Comparable<Voertuig>, Serializable {
    private final Nummerplaat nummerplaat; // = Div.INSTANCE.getNummerplaat();
    private String merk;
    private int aankoopprijs;
    @Serial
    private static final long serialVersionUID = 1L;

    public Voertuig(String merk, int aankoopprijs) {
        this.nummerplaat = Div.INSTANCE.getNummerplaat();
        setMerk(merk);
        setAankoopprijs(aankoopprijs);
    }

    public Nummerplaat getNummerplaat() {
        return nummerplaat;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        if (merk == null || merk.isEmpty()) {
            throw new IllegalArgumentException("merk moet ingevuld zijn");
        } else {
            this.merk = merk;
        }
    }

    public int getAankoopprijs() {
        return aankoopprijs;
    }

    public void setAankoopprijs(int aankoopprijs) {
        if (aankoopprijs < 0) {
            throw new IllegalArgumentException("aankoopprijs mag niet negatief zijn");
        } else {
            this.aankoopprijs = aankoopprijs;
        }
    }

    @Override
    public String toString() {
        return "Voertuig{" +
                "nummerplaat=" + nummerplaat +
                ", merk='" + merk + '\'' +
                ", aankoopprijs=" + aankoopprijs +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voertuig voertuig = (Voertuig) o;
        return Objects.equals(nummerplaat, voertuig.nummerplaat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nummerplaat);
    }

    @Override
    public int compareTo(Voertuig v) {
        return nummerplaat.compareTo(v.getNummerplaat());
    }
}
