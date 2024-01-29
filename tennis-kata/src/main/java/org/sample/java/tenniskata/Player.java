package org.sample.java.tenniskata;

public class Player {

    public Player(String name) {
        this.name = name;
        this.points = PointsEnum.LOVE;
    }

    private String name;
    private PointsEnum points;

    public String getName() {
        return name;
    }

    public PointsEnum getPoints() {
        return points;
    }

    public void setPoints(PointsEnum points) {
        this.points = points;
    }
}
