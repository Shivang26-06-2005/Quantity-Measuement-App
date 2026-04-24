package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // Equality
    @Test
    public void testFeetEquality() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);

        assertTrue(l1.equals(l2));
    }

    // Conversion
    @Test
    public void convertFeetToInches() {
        Length result = QuantityMeasurementApp.demonstrateLengthConversion(
                3.0,
                Length.LengthUnit.FEET,
                Length.LengthUnit.INCHES
        );

        Length expected = new Length(36.0, Length.LengthUnit.INCHES);
        assertTrue(result.equals(expected));
    }

    @Test
    public void convertYardsToFeet() {
        Length result = QuantityMeasurementApp.demonstrateLengthConversion(
                3.0,
                Length.LengthUnit.YARDS,
                Length.LengthUnit.FEET
        );

        Length expected = new Length(9.0, Length.LengthUnit.FEET);
        assertTrue(result.equals(expected));
    }

    // Addition
    @Test
    public void addFeetAndInches() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);

        Length result = QuantityMeasurementApp.demonstrateLengthAddition(l1, l2);
        Length expected = new Length(2.0, Length.LengthUnit.FEET);

        assertTrue(result.equals(expected));
    }

    @Test
    public void addYardsAndFeet() {
        Length l1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length l2 = new Length(3.0, Length.LengthUnit.FEET);

        Length result = QuantityMeasurementApp.demonstrateLengthAddition(l1, l2);
        Length expected = new Length(2.0, Length.LengthUnit.YARDS);

        assertTrue(result.equals(expected));
    }

    @Test
    public void addCentimeterAndInch() {
        Length l1 = new Length(2.54, Length.LengthUnit.CENTIMETERS);
        Length l2 = new Length(1.0, Length.LengthUnit.INCHES);

        Length result = QuantityMeasurementApp.demonstrateLengthAddition(l1, l2);

        assertTrue(result.equals(new Length(5.08, Length.LengthUnit.CENTIMETERS)));
    }
}
