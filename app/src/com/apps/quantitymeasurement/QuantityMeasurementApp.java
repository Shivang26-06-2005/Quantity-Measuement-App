package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    // UC4 Equality
    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }

    // UC4 Comparison
    public static boolean demonstrateLengthComparison(
            double v1, Length.LengthUnit u1,
            double v2, Length.LengthUnit u2) {

        Length l1 = new Length(v1, u1);
        Length l2 = new Length(v2, u2);

        return demonstrateLengthEquality(l1, l2);
    }

    // UC5 Conversion (raw)
    public static Length demonstrateLengthConversion(
            double value,
            Length.LengthUnit from,
            Length.LengthUnit to) {

        Length length = new Length(value, from);
        return length.convertTo(to);
    }

    // UC5 Conversion (overloaded)
    public static Length demonstrateLengthConversion(
            Length length,
            Length.LengthUnit to) {

        return length.convertTo(to);
    }

    // UC6 Addition
    public static Length demonstrateLengthAddition(
            Length l1, Length l2) {

        return l1.add(l2);
    }

    // MAIN
    public static void main(String[] args) {

        System.out.println(
                demonstrateLengthConversion(1.0,
                        Length.LengthUnit.FEET,
                        Length.LengthUnit.INCHES).toString()
        );

        System.out.println(
                demonstrateLengthConversion(3.0,
                        Length.LengthUnit.YARDS,
                        Length.LengthUnit.FEET).toString()
        );

        System.out.println(
                demonstrateLengthComparison(1.0,
                        Length.LengthUnit.FEET,
                        12.0,
                        Length.LengthUnit.INCHES)
        );

        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);

        System.out.println(
                demonstrateLengthAddition(l1, l2)
        );
    }
}
