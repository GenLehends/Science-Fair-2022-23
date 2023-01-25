package com.example.plan_tahead;

import java.util.Objects;

public class Plant {
    private String name;
    private double weeksToGrow;
    private String subGroup;
    private Soil[] compatibleSoil = {};
    private boolean cantGrowInWinter;
    private String preferedSeason;

    public Plant(String name, double daysToGrows, String subGroup) {
        this.name = name;
        this.weeksToGrow = daysToGrows;
        this.subGroup = subGroup;
        this.compatibleSoil = determineCompatibleSoil();
        cantGrowInWinter = this.noGrowInWinter();
        preferedSeason = determineSeason();
    }

    public Plant() {
        name = "";
        weeksToGrow = 0;
        subGroup = "";
        Soil[] compatibleSoil;
        cantGrowInWinter = false;
        preferedSeason = "";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeeksToGrow(double weeksToGrow) {
        this.weeksToGrow = weeksToGrow;
    }

    public void setSubGroup(String subGroup) {
        this.subGroup = subGroup;
    }

    public void setCompatibleSoil(Soil[] compatibleSoil) {
        this.compatibleSoil = compatibleSoil;
    }

    public Soil[] getCompatibleSoil() {
        return compatibleSoil;
    }

    public double getWeeksToGrow() {
        return weeksToGrow;
    }

    public String getSubGroup() {
        return subGroup;
    }

    public String getName() {
        return name;
    }

    public boolean getCantGrowInWinter() {
        return cantGrowInWinter;
    }

    public String getPreferedSeason() {
        return preferedSeason;
    }

    public boolean noGrowInWinter() {
        return subGroup.equals("Tomato") || subGroup.equals("Herb");
    }

    public String determineSeason() {
        if (this.subGroup.equals("Leafy Greens") || this.subGroup.equals("Herb")) {
            return "Fall";
        } else if (this.subGroup.equals("Roots")) {
            return "Summer";
        }
        return "Spring";
    }

    public Soil[] determineCompatibleSoil() {
        //Root, Brassica, Tomato, Leafy Green, Herb
        Soil[] list0 = {};
        Soil[] list1 = {new Soil("Sand"), new Soil("Silt"), new Soil("Peaty")};
        Soil[] list2 = {new Soil("Silt"), new Soil("Chalky")};
        Soil[] list3 = {new Soil("Sand")};
        Soil[] list4 = {new Soil("Loam")};
        if (Objects.equals(this.subGroup, "Brassicas")) {
            return list4;
        } else if (Objects.equals(this.subGroup, "Leafy Greens")) {
            return list2;
        } else if (Objects.equals(this.subGroup, "Tomato")) {
            return list3;
        } else if (Objects.equals(this.subGroup, "Herb")) {
            return list4;
        } else if (Objects.equals(this.subGroup, "Root")) {
            return list1;
        }
        return list0;
    }//end dCS


    public String toString() {
        return this.name;
    }
}
