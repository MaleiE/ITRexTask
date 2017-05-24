package com.malei.itrex.tasks.logic.tasktwo.entity;

public class Point {
    private int x;
    private int y;
    private int z;
    private Point parent;


    public Point(int x, int y, int z, Point parent) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.parent = parent;
    }


    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }


    public int getZ() {
        return z;
    }


    public Point getParent() {
        return parent;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Point{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append(", z=").append(z);
        sb.append('}');
        return sb.toString();
    }
}
