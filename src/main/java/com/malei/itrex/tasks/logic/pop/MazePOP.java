package com.malei.itrex.tasks.logic.pop;

import java.util.LinkedList;
import java.util.Queue;

public class MazePOP {

    private Queue<Point> pointQueue = new LinkedList<>();
    private int[][][] maze = new int[][][] {
            {{0,0,0},
             {5,5,0},
             {0,0,0},},

            {{5,5,5},
             {0,0,5},
             {0,5,5},},

            {{5,5,5},
             {5,0,0},
             {5,0,9},},
    };


    private   Point getPathBFS(int x, int y, int z) {

        pointQueue.add(new Point(x,y,z, null));

        while(!pointQueue.isEmpty()) {
            Point p = pointQueue.remove();

            if (maze[p.getX()][p.getY()][p.getZ()] == 9) {
                System.out.println("x = " + p.getX() + " y = " + p.getY() + " z = " + p.getZ());
                return p;
            }

            if(freePoint(p.getX()+1,p.getY(),p.getZ())) {
                maze[p.getX()][p.getY()][p.getZ()] = -1;
                Point nextP = new Point(p.getX()+1,p.getY(),p.getZ(), p);
                pointQueue.add(nextP);
            }

            if(freePoint(p.getX()-1,p.getY(),p.getZ())) {
                maze[p.getX()][p.getY()][p.getZ()] = -1;
                Point nextP = new Point(p.getX()-1,p.getY(),p.getZ(), p);
                pointQueue.add(nextP);
            }

            if(freePoint(p.getX(),p.getY()+1,p.getZ())) {
                maze[p.getX()][p.getY()][p.getZ()] = -1;
                Point nextP = new Point(p.getX(),p.getY()+1,p.getZ(), p);
                pointQueue.add(nextP);
            }

            if(freePoint(p.getX(),p.getY()-1,p.getZ())) {
                maze[p.getX()][p.getY()][p.getZ()] = -1;
                Point nextP = new Point(p.getX(),p.getY()-1,p.getZ(), p);
                pointQueue.add(nextP);
            }

            if(freePoint(p.getX(),p.getY(),p.getZ()+1)) {
                maze[p.getX()][p.getY()][p.getZ()] = -1;
                Point nextP = new Point(p.getX(),p.getY(),p.getZ()+1, p);
                pointQueue.add(nextP);
            }

            if(freePoint(p.getX(),p.getY(),p.getZ()-1)) {
                maze[p.getX()][p.getY()][p.getZ()] = -1;
                Point nextP = new Point(p.getX(),p.getY(),p.getZ()-1, p);
                pointQueue.add(nextP);
            }

        }
        return null;
    }

    private  boolean freePoint(int x, int y, int z) {
        if((x >= 0 && x < maze.length)
                && (y >= 0 && y < maze[1].length)
                && (z >= 0 && z < maze[2].length)
                && (maze[x][y][z] == 0 || maze[x][y][z] == 9)) {
            return true;
        }
        return false;
    }

    public void startPOP(int x, int y, int z){
        Point p = getPathBFS(x,y,z);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++){
                    System.out.print(maze[i][j][k]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println(maze.length+" length");

        while(p.getParent() != null) {
            System.out.println(p.toString());
            p = p.getParent();
        }
    }
}
