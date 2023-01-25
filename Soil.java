package com.example.plan_tahead;

public class Soil {
    private String name;
    private double growthFactor;

    public Soil(String name) {
        this.name = name;
        growthFactor = 1;
    }

    public Soil() {
        name = "";
        growthFactor = 0;
    }

    public double getGrowthFactor() {
        return growthFactor;
    }

    public void setGrowthFactor(double NewgrowthFactor) {
        growthFactor = NewgrowthFactor;
    }

    public String getName() {
        return name;
    }

    public void changeGrowthFactor(Plant plant) {
        double finalGrowthFactor = 1;
        Soil[] plantSoil = plant.getCompatibleSoil();
        for (int i = 0; i < plantSoil.length; i++) {
            if (name.equals(plantSoil[i].getName())) {
                finalGrowthFactor = 1;
            } else {
                finalGrowthFactor = 1.7;
            }
        }
        setGrowthFactor(finalGrowthFactor);
    }

    public String toString() {
        return name;
    }
}


