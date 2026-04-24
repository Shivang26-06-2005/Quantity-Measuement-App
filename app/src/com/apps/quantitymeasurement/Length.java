package com.apps.quantitymeasurement;

public class Length {

    private final double value;
    private final LengthUnit unit;

    public Length(double value, LengthUnit unit) {
        if (unit == null || !Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid input");
        }
        this.value = value;
        this.unit = unit;
    }

    // ENUM (Base = INCHES)
    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double factor;

        LengthUnit(double factor) {
            this.factor = factor;
        }

        public double getFactor() {
            return factor;
        }
    }

    // Convert to base (inches)
    private double toBase() {
        return this.value * this.unit.getFactor();
    }

    // Convert from base to target
    private static double fromBase(double baseValue, LengthUnit target) {
        return baseValue / target.getFactor();
    }

    // UC5: convertTo
    public Length convertTo(LengthUnit target) {
        if (target == null) throw new IllegalArgumentException("Target null");

        double base = toBase();
        double converted = fromBase(base, target);

        return new Length(round(converted), target);
    }

    // UC6: add
    public Length add(Length other) {
        if (other == null) throw new IllegalArgumentException("Null length");

        double sumBase = this.toBase() + other.toBase();
        double result = fromBase(sumBase, this.unit);

        return new Length(round(result), this.unit);
    }

    // Equality
    private boolean compare(Length other) {
        return Math.abs(this.toBase() - other.toBase()) < 0.01;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Length)) return false;
        return compare((Length) o);
    }

    private double round(double v) {
        return Math.round(v * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit);
    }
}
