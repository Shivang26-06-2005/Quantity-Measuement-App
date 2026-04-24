package com.apps.quantitymeasurement;

public class Length {

    private final double value;
    private final LengthUnit unit;

    // tolerance for floating-point comparison
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
        this.value = value;
        this.unit = unit;
    }

    // ===== CONVERT TO BASE UNIT (INCHES) =====
    private double convertToBaseUnit() {
        return this.value * this.unit.getConversionFactor();
    }

    // ===== COMPARE (FIXED) =====
    public boolean compare(Length that) {
        if (that == null) return false;

        double thisValue = this.convertToBaseUnit();
        double thatValue = that.convertToBaseUnit();

        return Math.abs(thisValue - thatValue) < EPSILON;
    }

    // ===== EQUALS =====
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Length that = (Length) obj;
        return this.compare(that);
    }

    // ===== HASHCODE =====
    @Override
    public int hashCode() {
        return Double.hashCode(convertToBaseUnit());
    }
}
