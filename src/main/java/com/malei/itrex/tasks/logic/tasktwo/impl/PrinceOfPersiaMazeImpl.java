package com.malei.itrex.tasks.logic.tasktwo.impl;

import com.malei.itrex.tasks.logic.tasktwo.PrinceOfPersiaMaze;
import com.malei.itrex.tasks.logic.tasktwo.entity.Point;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrinceOfPersiaMazeImpl implements PrinceOfPersiaMaze {

    private static final int TIME = 5;

    private Queue<Point> pointQueue = new LinkedList<>();
    private String[][][] maze = null;
    private int count;
    private int lvl = 0;
    private int i = 0;
    private int k = 0;
    private int j = 0;
    private int y = 0;
    private int startX = 0;
    private int startY = 0;
    private int startZ = 0;

    @Override
    public String[][][] buildMaze(List list) {
        for (int u = 0; u < list.size(); u++) {
            if (u == 0) {
                i = Integer.parseInt(String.valueOf(list.get(u).toString().charAt(0)));
                k = Integer.parseInt(String.valueOf(list.get(u).toString().charAt(2)));
                j = Integer.parseInt(String.valueOf(list.get(u).toString().charAt(4)));
                maze = new String[i][k][j];
            }
            if (u != 0 && (!list.get(u).equals(""))) {
                String s = (String) list.get(u);
                for (int x = 0; x < maze[lvl][y].length; x++) {
                    maze[lvl][y][x] = String.valueOf(s.charAt(x));
                    if(String.valueOf(s.charAt(x)).equals("1")){
                        startX = lvl;
                        startY = y;
                        startZ = x;
                    }
                }
                y++;
                if (y >= maze[lvl].length) {
                    y = 0;
                }
            } else if (u > 1) {
                lvl++;
            }
        }
        return maze;
    }

    private Point getPathBFS(int x, int y, int z) {

        pointQueue.add(new Point(x, y, z, null));

        while (!pointQueue.isEmpty()) {
            Point activeP = pointQueue.remove();

            if (maze[activeP.getX()][activeP.getY()][activeP.getZ()].equals("2")) {
                return activeP;
            }

            if (freePoint(activeP.getX() + 1, activeP.getY(), activeP.getZ())) {
                maze[activeP.getX()][activeP.getY()][activeP.getZ()] = "-1";
                Point nextP = new Point(activeP.getX() + 1, activeP.getY(), activeP.getZ(), activeP);
                pointQueue.add(nextP);
            }

            if (freePoint(activeP.getX() - 1, activeP.getY(), activeP.getZ())) {
                maze[activeP.getX()][activeP.getY()][activeP.getZ()] = "-1";
                Point nextP = new Point(activeP.getX() - 1, activeP.getY(), activeP.getZ(), activeP);
                pointQueue.add(nextP);
            }

            if (freePoint(activeP.getX(), activeP.getY() + 1, activeP.getZ())) {
                maze[activeP.getX()][activeP.getY()][activeP.getZ()] = "-1";
                Point nextP = new Point(activeP.getX(), activeP.getY() + 1, activeP.getZ(), activeP);
                pointQueue.add(nextP);
            }

            if (freePoint(activeP.getX(), activeP.getY() - 1, activeP.getZ())) {
                maze[activeP.getX()][activeP.getY()][activeP.getZ()] = "-1";
                Point nextP = new Point(activeP.getX(), activeP.getY() - 1, activeP.getZ(), activeP);
                pointQueue.add(nextP);
            }

            if (freePoint(activeP.getX(), activeP.getY(), activeP.getZ() + 1)) {
                maze[activeP.getX()][activeP.getY()][activeP.getZ()] = "-1";
                Point nextP = new Point(activeP.getX(), activeP.getY(), activeP.getZ() + 1, activeP);
                pointQueue.add(nextP);
            }

            if (freePoint(activeP.getX(), activeP.getY(), activeP.getZ() - 1)) {
                maze[activeP.getX()][activeP.getY()][activeP.getZ()] = "-1";
                Point nextP = new Point(activeP.getX(), activeP.getY(), activeP.getZ() - 1, activeP);
                pointQueue.add(nextP);
            }

        }
        return null;
    }

    private boolean freePoint(int x, int y, int z) {
        if ((x >= 0 && x < maze.length)
                && (y >= 0 && y < maze[1].length)
                && (z >= 0 && z < maze[2].length)
                && (maze[x][y][z].equals(".") || maze[x][y][z].equals("2"))) {
            return true;
        }
        return false;
    }

    @Override
    public String start() {
        Point p = getPathBFS(startX,startY,startZ);

        while (p.getParent() != null) {
            p = p.getParent();
            count++;
            System.out.println(p.toString());
        }
        return String.valueOf((count*TIME));
    }
}