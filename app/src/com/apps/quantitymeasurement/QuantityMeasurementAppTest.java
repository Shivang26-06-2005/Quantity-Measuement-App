package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.apps.quantitymeasurement.Length;
import com.apps.quantitymeasurement.Length.LengthUnit;

public class QuantityMeasurementAppTest {

    private static final double EPSILON = 0.0001;

    // =========================
    // UC3 / UC4 Equality Tests
    // =========================

    @Test
    public void testFeetToFeet_SameValue() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(1.0, LengthUnit.FEET);

        assertTrue(l1.equals(l2));
    }

    @Test
    public void testFeetToFeet_DifferentValue() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(2.0, LengthUnit.FEET);

        assertFalse(l1.equals(l2));
    }

    @Test
    public void testFeetToInches_Equal() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);

        assertTrue(l1.equals(l2));
    }

    @Test
    public void testYardsToFeet_Equal() {
        Length l1 = new Length(1.0, LengthUnit.YARDS);
        Length l2 = new Length(3.0, LengthUnit.FEET);

        assertTrue(l1.equals(l2));
    }

    @Test
    public void testCentimetersToFeet_Equal() {
        Length l1 = new Length(30.48, LengthUnit.CENTIMETERS);
        Length l2 = new Length(1.0, LengthUnit.FEET);

        assertTrue(l1.equals(l2));
    }

    @Test
    public void testNullComparison() {
        Length l1 = new Length(1.0, LengthUnit.FEET);

        assertFalse(l1.equals(null));
    }

    @Test
    public void testSameReference() {
        Length l1 = new Length(1.0, LengthUnit.FEET);

        assertTrue(l1.equals(l1));
    }

    // =========================
    // UC5 Conversion Tests
    // =========================

    @Test
    public void testConvert_FeetToInches() {
        double result = QuantityMeasurementApp.convert(1.0, LengthUnit.FEET, LengthUnit.INCHES);
        assertEquals(12.0, result, EPSILON);
    }

    @Test
    public void testConvert_InchesToFeet() {
        double result = QuantityMeasurementApp.convert(24.0, LengthUnit.INCHES, LengthUnit.FEET);
        assertEquals(2.0, result, EPSILON);
    }

    @Test
    public void testConvert_YardsToFeet() {
        double result = QuantityMeasurementApp.convert(3.0, LengthUnit.YARDS, LengthUnit.FEET);
        assertEquals(9.0, result, EPSILON);
    }

    @Test
    public void testConvert_InchesToYards() {
        double result = QuantityMeasurementApp.convert(72.0, LengthUnit.INCHES, LengthUnit.YARDS);
        assertEquals(2.0, result, EPSILON);
    }

    @Test
    public void testConvert_CentimetersToInches() {
        double result = QuantityMeasurementApp.convert(2.54, LengthUnit.CENTIMETERS, LengthUnit.INCHES);
        assertEquals(1.0, result, EPSILON);
    }

    @Test
    public void testConvert_ZeroValue() {
        double result = QuantityMeasurementApp.convert(0.0, LengthUnit.FEET, LengthUnit.INCHES);
        assertEquals(0.0, result, EPSILON);
    }

    @Test
    public void testConvert_NegativeValue() {
        double result = QuantityMeasurementApp.convert(-1.0, LengthUnit.FEET, LengthUnit.INCHES);
        assertEquals(-12.0, result, EPSILON);
    }

    @Test
    public void testConvert_SameUnit() {
        double result = QuantityMeasurementApp.convert(5.0, LengthUnit.FEET, LengthUnit.FEET);
        assertEquals(5.0, result, EPSILON);
    }

    // =========================
    // Overloaded Method Tests
    // =========================

    @Test
    public void testOverloadedMethod_RawValues() {
        Length result = QuantityMeasurementApp.demonstrateLengthConversion(
                3.0, LengthUnit.FEET, LengthUnit.INCHES);

        Length expected = new Length(36.0, LengthUnit.INCHES);

        assertTrue(result.equals(expected));
    }

    @Test
    public void testOverloadedMethod_ObjectInput() {
        Length input = new Length(2.0, LengthUnit.YARDS);

        Length result = QuantityMeasurementApp.demonstrateLengthConversion(
                input, LengthUnit.INCHES);

        Length expected = new Length(72.0, LengthUnit.INCHES);

        assertTrue(result.equals(expected));
    }

    // =========================
    // Exception Tests
    // =========================

    @Test
    public void testConvert_NullUnit() {
        assertThrows(IllegalArgumentException.class, () ->
                QuantityMeasurementApp.convert(1.0, null, LengthUnit.FEET));
    }

    @Test
    public void testConvert_InvalidValue() {
        assertThrows(IllegalArgumentException.class, () ->
                QuantityMeasurementApp.convert(Double.NaN, LengthUnit.FEET, LengthUnit.INCHES));
    }
}
