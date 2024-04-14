package com.divyesh.medanon;

public class Psychiatrist {
    private String name;
    private String specialization;
    private String experience;
    private int imageResource;

    public Psychiatrist(String name, String specialization, String experience, int imageResource) {
        this.name = name;
        this.specialization = specialization;
        this.experience = experience;
        this.imageResource = imageResource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}

