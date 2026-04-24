package com.apps.quantitymeasurement;

public class Length {

    private double value;
    private LengthUnit unit;

    // ===== ENUM =====
    public enum LengthUnit {
        FEET(12.0),     // 1 ft = 12 inches
        INCHES(1.0);    // base unit = inches

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

    // ===== COMPARE METHOD =====
    public boolean compare(Length that) {
        if (that == null) return false;

        return Double.compare(
                this.convertToBaseUnit(),
                that.convertToBaseUnit()
        ) == 0;
    }

    // ===== EQUALS =====
    @Override
    public boolean equals(Object obj) {

        // Reflexive
        if (this == obj) return true;

        // Null & type check
        if (obj == null || getClass() != obj.getClass()) return false;

        Length that = (Length) obj;

        // Delegate to compare
        return this.compare(that);
    }

    // ===== HASHCODE =====
    @Override
    public int hashCode() {
        return Double.hashCode(convertToBaseUnit());
    }

    // ===== MAIN (DEMO) =====
    public static void main(String[] args) {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);

        System.out.println("Input: Quantity(1.0, \"feet\") and Quantity(12.0, \"inches\")");
        System.out.println("Output: Equal (" + l1.equals(l2) + ")");

        Length l3 = new Length(1.0, LengthUnit.INCHES);
        Length l4 = new Length(1.0, LengthUnit.INCHES);

        System.out.println("Input: Quantity(1.0, \"inch\") and Quantity(1.0, \"inch\")");
        System.out.println("Output: Equal (" + l3.equals(l4) + ")");
    }
}
