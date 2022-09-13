package org.example;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Before
    public void before() {
        EnumPlanets[] Planet = EnumPlanets.values();
    }

    @Test
    @DisplayName("check outer and inner planets of Solar System")
    void checkPosition() {
        EnumPlanets planet = EnumPlanets.JUPITER;
        assertEquals("outer Planets of the Solar system", planet.nearbySun(planet.getAvgDistance()));
        EnumPlanets planet1 = EnumPlanets.VENUS;
        assertEquals("Inner Planets of Solar System", planet1.nearbySun(planet1.getAvgDistance()));
    }
    @Test
    @DisplayName("check null values of rotation speed of planet ")
    void checkForNullColor() {
        EnumPlanets Planet= EnumPlanets.JUPITER;
        Assertions.assertNull(Planet.getColorOfPlanet());
    }

    @Test
    @DisplayName("Check specialCharacters")
    void checkSpecialCharacters() {
        EnumPlanets planet1 = EnumPlanets.SATURN;
        EnumPlanets planet2 = EnumPlanets.NEPTUNE;
        EnumPlanets planet3 = EnumPlanets.Uranus;

        Assertions.assertTrue(planet2.specialCharacters());
        Assertions.assertTrue(planet1.specialCharacters());
        Assertions.assertFalse(planet3.specialCharacters());

    }

    @Test
    @DisplayName("Check greater spinning speed")
    void spinningSpeed() {
        EnumPlanets Planet = EnumPlanets.MERCURY;
        EnumPlanets Planet1 = EnumPlanets.Earth;
        Assertions.assertTrue(Planet.getRotationSpeed()<Planet1.getRotationSpeed());
    }


    @Test
    @DisplayName("Check surface of planet")
    void checkPlanetSurface() {

        EnumPlanets planet = EnumPlanets.JUPITER;
        EnumPlanets planet1 = EnumPlanets.Earth;

        assertEquals("Gas Gaint", planet.checkSurface());
        assertEquals("Rocky Planet", planet1.checkSurface());

    }

    @Test
    @DisplayName("check not null values of planets ")
    void checkForNotNull() {
        for (EnumPlanets Planet : EnumPlanets.values()) {
            Assertions.assertNotNull(Planet.getAvgDistance());
        }
    }
    @Test
    @DisplayName("compare weight on two planets")
    void checkWtOnPlanet(){
        EnumPlanets planet = EnumPlanets.MARS;
        EnumPlanets planet1 = EnumPlanets.SATURN;
        Assertions.assertFalse(planet.wtOnPlanet(50)>planet1.wtOnPlanet(50));
        Assertions.assertTrue(planet.wtOnPlanet(67)<planet1.wtOnPlanet(67));

    }


}
