package com.mobdeve.s20.bacosa.serrato.mco;

public class Character {
    private String name;
    private String className;
    private String dateCreated;
    private int level;
    private String species; // Species field
    private int iconResource;

    public Character(String name, String className, String dateCreated, int level, String species, int iconResource) {
        this.name = name;
        this.className = className;
        this.dateCreated = dateCreated;
        this.level = level;
        this.species = species; // Assign species
        this.iconResource = iconResource;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public int getLevel() {
        return level;
    }

    public String getSpecies() {
        return species; // Species getter
    }

    public int getIconResource() {
        return iconResource;
    }
}
