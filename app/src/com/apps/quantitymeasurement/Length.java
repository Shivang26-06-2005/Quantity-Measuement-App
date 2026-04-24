package com.apps.quantitymeasurement;

public class Length {

    private final double value;
    private final LengthUnit unit;

    private static final double EPSILON = 0.0001;

    // ===== ENUM =====
    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    // ===== CONSTRUCTOR =====
    public Length(double value, LengthUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be finite");
        }

        this.value = value;
        this.unit = unit;
    }

    // ===== BASE CONVERSION (INCHES) =====
    private double convertToBaseUnit() {
        return this.value * this.unit.getConversionFactor();
    }

    // ===== INSTANCE CONVERSION =====
    public Length convertTo(LengthUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double base = convertToBaseUnit();
        double converted = base / targetUnit.getConversionFactor();

        return new Length(converted, targetUnit);
    }

    // ===== EQUALITY =====
    private boolean compare(Length that) {
        if (that == null) return false;

        double thisVal = this.convertToBaseUnit();
        double thatVal = that.convertToBaseUnit();

        return Math.abs(thisVal - thatVal) < EPSILON;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Length that = (Length) obj;
        return compare(that);
    }

    @Override
    public int hashCode() {
        return Double.hashCode(convertToBaseUnit());
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit);
    }
}
