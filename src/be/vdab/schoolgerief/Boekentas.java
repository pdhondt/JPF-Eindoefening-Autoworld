package be.vdab.schoolgerief;

import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Boekentas implements Laadbaar, Serializable {
    private String kleur;
    private Volume laadvolume;
    @Serial
    private static final long serialVersionUID = 1L;

    public Boekentas(String kleur, Volume laadvolume) {
        setKleur(kleur);
        setLaadvolume(laadvolume);
    }

    public String getKleur() {
        return kleur;
    }

    public void setKleur(String kleur) {
        if (kleur == null || kleur.isEmpty()) {
            throw new IllegalArgumentException("kleur moet ingevuld worden");
        } else {
            this.kleur = kleur;
        }
    }

    @Override
    public Volume getLaadvolume() {
        return laadvolume;
    }

    @Override
    public void setLaadvolume(Volume laadvolume) {
        if (laadvolume == null) {
            throw new IllegalArgumentException("geen laadvolume aanwezig");
        } else {
            this.laadvolume = laadvolume;
        }
    }

    @Override
    public String toString() {
        return "Boekentas{" +
                "kleur='" + kleur + '\'' +
                ", laadvolume=" + laadvolume +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Boekentas boekentas = (Boekentas) o;
        return Objects.equals(kleur, boekentas.kleur) && Objects.equals(laadvolume, boekentas.laadvolume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kleur, laadvolume);
    }
}
