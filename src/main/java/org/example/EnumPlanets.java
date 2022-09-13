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

    public float wtOnPlanet(float x) {

        return x * getRefWtIndex();

    }

    public String nearbySun(double avgDistance) {
        double val = 22.79e+7;
        if (avgDistance < val) {
            return "Inner Planets of Solar System";
        }
        return "outer Planets of the Solar system";
    }

    public String checkSurface() {
        double val = 5.976e+24;
        if (mass > val) {
            return "Gas Gaint";
        }
        return "Rocky Planet";

    }

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
