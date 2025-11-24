package com.game.model;

public class Country {
    private final int ranking;
    private final String name;
    private final double points;
    private final String confederation;

    public Country(int ranking, String name, double points, String confederation) {
        this.ranking = ranking;
        this.name = name;
        this.points = points;
        this.confederation = confederation;
    }

    public int getRanking() {return this.ranking;};
    public String getName() {return this.name;};
    public double getPoints() {return this.points;};
    public String getConfederation() {return this.confederation;};

    @Override
    public String toString() {
        return String.format("%s (Rank - #%d, %.2f points)", name, ranking, points);
    }
}
