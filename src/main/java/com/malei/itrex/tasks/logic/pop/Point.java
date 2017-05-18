package com.malei.itrex.tasks.logic.pop;

import org.apache.commons.lang3.builder.ToStringBuilder;

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

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public Point getParent() {
        return parent;
    }

    public void setParent(Point parent) {
        this.parent = parent;
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
