package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

<<<<<<< Updated upstream
import com.apps.quantitymeasurement.QuantityMeasurementApp.Feet;

public class QuantityMeasurementAppTest {

    @Test
    public void testFeetEquality_SameValue() {
        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);

        assertTrue(f1.equals(f2));
    }

    @Test
    public void testFeetEquality_DifferentValue() {
        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(2.0);

        assertFalse(f1.equals(f2));
    }

    @Test
    public void testFeetEquality_NullComparison() {
        Feet f1 = new Feet(1.0);

        assertFalse(f1.equals(null));
    }

    @Test
    public void testFeetEquality_DifferentClass() {
        Feet f1 = new Feet(1.0);

        assertFalse(f1.equals("Some String"));
    }

    @Test
    public void testFeetEquality_SameReference() {
        Feet f1 = new Feet(1.0);

        assertTrue(f1.equals(f1));
=======
public class QuantityMeasurementAppTest {

    @Test
    public void testEquality_FeetToFeet_SameValue() {
        assertTrue(new Length(1.0, Length.LengthUnit.FEET)
                .equals(new Length(1.0, Length.LengthUnit.FEET)));
    }

    @Test
    public void testEquality_InchToInch_SameValue() {
        assertTrue(new Length(1.0, Length.LengthUnit.INCHES)
                .equals(new Length(1.0, Length.LengthUnit.INCHES)));
    }

    @Test
    public void testEquality_FeetToInch_EquivalentValue() {
        assertTrue(new Length(1.0, Length.LengthUnit.FEET)
                .equals(new Length(12.0, Length.LengthUnit.INCHES)));
    }

    @Test
    public void testEquality_InchToFeet_EquivalentValue() {
        assertTrue(new Length(12.0, Length.LengthUnit.INCHES)
                .equals(new Length(1.0, Length.LengthUnit.FEET)));
    }

    @Test
    public void testEquality_FeetToFeet_DifferentValue() {
        assertFalse(new Length(1.0, Length.LengthUnit.FEET)
                .equals(new Length(2.0, Length.LengthUnit.FEET)));
    }

    @Test
    public void testEquality_InchToInch_DifferentValue() {
        assertFalse(new Length(1.0, Length.LengthUnit.INCHES)
                .equals(new Length(2.0, Length.LengthUnit.INCHES)));
    }

    @Test
    public void testEquality_NullComparison() {
        assertFalse(new Length(1.0, Length.LengthUnit.FEET).equals(null));
    }

    @Test
    public void testEquality_SameReference() {
        Length l = new Length(1.0, Length.LengthUnit.FEET);
        assertTrue(l.equals(l));
>>>>>>> Stashed changes
    }
}
