package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static void demonstrateLengthComparison(
            double value1, Length.LengthUnit unit1,
            double value2, Length.LengthUnit unit2) {

        Length l1 = new Length(value1, unit1);
        Length l2 = new Length(value2, unit2);

        System.out.println("Input: Quantity(" + value1 + ", " + unit1 +
                ") and Quantity(" + value2 + ", " + unit2 + ")");
        System.out.println("Output: Equal (" + l1.equals(l2) + ")");
        System.out.println();
    }

    public static void main(String[] args) {

        // Feet ↔ Inches
        demonstrateLengthComparison(1.0, Length.LengthUnit.FEET,
                12.0, Length.LengthUnit.INCHES);

        // Yards ↔ Feet
        demonstrateLengthComparison(1.0, Length.LengthUnit.YARDS,
                3.0, Length.LengthUnit.FEET);

        // Yards ↔ Inches
        demonstrateLengthComparison(1.0, Length.LengthUnit.YARDS,
                36.0, Length.LengthUnit.INCHES);

        // CM ↔ Inches
        demonstrateLengthComparison(1.0, Length.LengthUnit.CENTIMETERS,
                0.393701, Length.LengthUnit.INCHES);

        // Feet ↔ Yards
        demonstrateLengthComparison(3.0, Length.LengthUnit.FEET,
                1.0, Length.LengthUnit.YARDS);

        // CM ↔ Feet
        demonstrateLengthComparison(30.48, Length.LengthUnit.CENTIMETERS,
                1.0, Length.LengthUnit.FEET);
    }
}
