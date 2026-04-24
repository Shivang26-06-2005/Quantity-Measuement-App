package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    // ===== UC5 STATIC CONVERSION API =====
    public static double convert(double value,
                                 Length.LengthUnit source,
                                 Length.LengthUnit target) {

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be finite");
        }

        if (source == null || target == null) {
            throw new IllegalArgumentException("Units cannot be null");
        }

        // convert to base (inches)
        double base = value * source.getConversionFactor();

        // convert to target
        return base / target.getConversionFactor();
    }

    // ===== OVERLOADED METHOD (RAW VALUES) =====
    public static Length demonstrateLengthConversion(double value,
                                                     Length.LengthUnit from,
                                                     Length.LengthUnit to) {

        double result = convert(value, from, to);
        return new Length(result, to);
    }

    // ===== OVERLOADED METHOD (OBJECT BASED) =====
    public static Length demonstrateLengthConversion(Length length,
                                                     Length.LengthUnit toUnit) {

        if (length == null) {
            throw new IllegalArgumentException("Length cannot be null");
        }

        return length.convertTo(toUnit);
    }

    // ===== EQUALITY DEMO =====
    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }

    // ===== MAIN METHOD =====
    public static void main(String[] args) {

        // UC5 Conversion examples
        System.out.println(convert(1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES)); // 12
        System.out.println(convert(3.0, Length.LengthUnit.YARDS, Length.LengthUnit.FEET)); // 9
        System.out.println(convert(36.0, Length.LengthUnit.INCHES, Length.LengthUnit.YARDS)); // 1

        // Object-based conversion
        Length length = new Length(2.0, Length.LengthUnit.YARDS);
        Length converted = demonstrateLengthConversion(length, Length.LengthUnit.INCHES);

        System.out.println(converted); // 72 inches

        // Equality check
        Length l1 = new Length(30.48, Length.LengthUnit.CENTIMETERS);
        Length l2 = new Length(1.0, Length.LengthUnit.FEET);

        System.out.println("Equal? " + l1.equals(l2)); // true
    }
}
