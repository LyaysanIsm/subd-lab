package ru.ulstu.model;

public class TechniqueStatistic {

    private String name;

    public TechniqueStatistic(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
