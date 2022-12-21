package be.vdab.util;

public enum Maat {
    CENTIMETER(0.01), DECIMETER(0.1), METER(1.0);
    private final double factor;

    Maat(double factor) {
        this.factor = factor;
    }

    public double getFactor() {
        return factor;
    }
}
