## Learning Planets with Java Enum

#### About Enum
###### An enum is a special "class" that represents a group of constants (unchangeable variables, like final variables).An enum can, just like a class, have attributes and methods. The only difference is that enum constants are public, static and final (unchangeable - cannot be overridden).

###### An enum cannot be used to create objects, and it cannot extend other classes (but it can implement interfaces).Enum is used when you have values that you know aren't going to change, like month days, days, colors, deck of cards, etc.

#### Overview
###### Create a Enum Planet class with 8 values representing the planets in Solar system. The values include name, mass, average distance, refractive index, color. Methods are written to Calculate person's weight on each planet and Implement  tests to check the functionality of Application.

#### Program Flow

1.  Enum java Class is created and planets are added with different values like name, mass, refractive index, spinning speed and color of planet.
````
package org.example;

public enum EnumPlanets {
    MERCURY("Mercury", 5.79e+7, 3.303e+23, 0.38f, 10.8f, "Gray"),
    VENUS("Venus", 10.82e+7, 4.869e+24, 0.91f, 6.5f, "Orange"),
    Earth("Earth", 14.96e+7, 5.976e+24, 1.0f, 1574.0f, "Blue"),
    MARS("Mars", 22.79e+7, 6.421e+23, 0.38f, 866.0f, "Red"),
    JUPITER("Jupiter", 77.86e+7, 1.9e+27, 2.34f, 45583.0f, null),
    SATURN("S@turn", 143.35e+7, 5.688e+26, 1.06f, 36840.0f, "Yellow"),
    Uranus("Uranus", 287.25e+7, 8.686e+25, 0.92f, 14794.0f, "Green"),
    NEPTUNE("Neptune#", 449.51e+7, 1.024e+26, 1.19f, 9719.0f, "Blue");

````
2. Constructor class and getters are created to access the values.
````
private final String name;
    private final double avgDistance;
    private final double mass;
    private final float refWtIndex;
    private final Float rotationSpeed;
    private final String colorOfPlanet;


    EnumPlanets(String name, double avgDistance, double mass, float refWtIndex, Float rotationSpeed, String colorOfPlanet) {
        this.name = name;
        this.avgDistance = avgDistance;
        this.mass = mass;
        this.refWtIndex = refWtIndex;
        this.rotationSpeed = rotationSpeed;
        this.colorOfPlanet = colorOfPlanet;
    }
    public String getName() {
        return name;
    }

    public double getAvgDistance() {
        return avgDistance;
    }

    public double getMass() {
        return mass;
    }

    public String getColorOfPlanet() {
        return colorOfPlanet;
    }

    public float getRefWtIndex() {
        return refWtIndex;
    }

    public Float getRotationSpeed() {
        return rotationSpeed;
    }

````
3. wtOnPlanet() method is created to get person's weight on each planet.
````
 public float wtOnPlanet(float x) {

        return x * getRefWtIndex();

    }

````
4. nearBySun() method is created to check if planet exists in  the inner or outer boundaries of the solar system.
````
 public String nearbySun(double avgDistance) {
        double val = 22.79e+7;
        if (avgDistance < val) {
            return "Inner Planets of Solar System";
        }
        return "outer Planets of the Solar system";
    }
````
5. checkSurface() method returns the surface type of planet -rocky or gas based on bigger masses comparisons.
````
public String checkSurface() {
        double val = 5.976e+24;
        if (mass > val) {
            return "Gas Gaint";
        }
        return "Rocky Planet";

    }
````
6. specialCharacters() method checks if planets name consists of any special character.
 
````
 public boolean specialCharacters() {
        String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
            if (specialCharactersString.contains(Character.toString(ch))) {
                return true;
            }
        }
        return false;

    }
}

````
7. Below code from the Planet class  iterates over all the planets in the solar system and print the weight of the person on each planet.

````
public class Main {
    public static void main(String[] args) {
        float weight= 50;
        for(EnumPlanets Planet: EnumPlanets.values()){

            System.out.println("Your weight on " + Planet+ "is :"+ Planet.wtOnPlanet(weight));

        }

    }
````

#### Tests Implementation

###### Unit Testing is done with Jupiter JUnit. Test cases includes, checking the null values in color of planets, Special characters in Name of planets, weight on planet , conditional checks on mass  and rotational speed of planets .
````
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


````