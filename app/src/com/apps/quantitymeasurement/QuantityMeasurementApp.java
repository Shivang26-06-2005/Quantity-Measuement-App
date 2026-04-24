package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

<<<<<<< Updated upstream
    // Inner class to represent Feet measurement
    public static class Feet {
        private final double value;

        // Constructor
        public Feet(double value) {
            this.value = value;
        }

        /**
         * Override equals() method to compare two Feet objects based on their value
         */
        @Override
        public boolean equals(Object obj) {

            // 1. Reference check
            if (this == obj) return true;

            // 2. Null check
            if (obj == null) return false;

            // 3. Type check
            if (getClass() != obj.getClass()) return false;

            // 4. Cast and compare values
            Feet other = (Feet) obj;
            return Double.compare(this.value, other.value) == 0;
        }

        // Always override hashCode when equals is overridden
        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }

    // Main method to demonstrate functionality
    public static void main(String[] args) {
        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);

        System.out.println("Input: 1.0 ft and 1.0 ft");
        System.out.println("Output: Equal (" + f1.equals(f2) + ")");
=======
    public static void main(String[] args) {

        // ===== Cross-unit comparison =====
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);

        System.out.println("Input: Quantity(1.0, \"feet\") and Quantity(12.0, \"inches\")");
        System.out.println("Output: Equal (" + l1.equals(l2) + ")");

        // ===== Same unit comparison =====
        Length l3 = new Length(1.0, Length.LengthUnit.INCHES);
        Length l4 = new Length(1.0, Length.LengthUnit.INCHES);

        System.out.println("Input: Quantity(1.0, \"inch\") and Quantity(1.0, \"inch\")");
        System.out.println("Output: Equal (" + l3.equals(l4) + ")");
>>>>>>> Stashed changes
    }
}
