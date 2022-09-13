package org.example;

public class Main {
    public static void main(String[] args) {
        float weight= 50;
        for(EnumPlanets Planet: EnumPlanets.values()){

            System.out.println("Your weight on " + Planet+ "is :"+ Planet.wtOnPlanet(weight));

        }

    }
}