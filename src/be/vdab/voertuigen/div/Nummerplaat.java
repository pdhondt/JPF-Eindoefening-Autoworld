package be.vdab.voertuigen.div;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Nummerplaat implements Serializable, Comparable<Nummerplaat> {
    private final String plaat;
    @Serial
    private static final long serialVersionUID = 1L;

    public Nummerplaat(String plaat) {
        this.plaat = plaat;
    }

    public String getPlaat() {
        return plaat;
    }

    @Override
    public String toString() {
        return "Nummerplaat{" +
                "plaat='" + plaat + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nummerplaat that = (Nummerplaat) o;
        return Objects.equals(plaat, that.plaat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plaat);
    }

    @Override
    public int compareTo(Nummerplaat n) {
        return plaat.compareTo(n.getPlaat());
    }

}
