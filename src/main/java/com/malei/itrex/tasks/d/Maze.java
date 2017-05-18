package com.malei.itrex.tasks.d;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Maze {

    public static int[][][] arr = new int[][][] {
            {{0,0,0,0},
             {5,5,5,0},
             {0,0,0,0},
             {0,0,0,0},},

            {{5,5,5,0},
             {0,0,0,0},
             {0,5,5,0},
             {0,0,0,0},},

            {{0,0,0,0},
             {0,5,5,5},
             {0,5,0,5},
             {0,0,0,5},},

            {{0,0,0,0},
             {0,5,0,0},
             {0,5,5,5},
             {0,0,0,9},},


    };

    private static class Point {
        int x;
        int y;
        int z;
        Point parent;

        public Point(int x, int y, int z, Point parent) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.parent = parent;
        }

        public Point getParent() {
            return this.parent;
        }

        public String toString() {
            return "x = " + x + " y = " + y + " z = " + z;
        }
    }

    public static Queue<Point> q = new LinkedList<>();

    public static Point getPathBFS(int x, int y, int z) {
        int count = 0;

        q.add(new Point(x,y,z, null));

        while(!q.isEmpty()) {
            count++;
            Point p = q.remove();

            if (arr[p.x][p.y][p.z] == 9) {
                System.out.println("x = " + p.x + " y = " + p.y + " z = " + p.z);
                System.out.println(count);
                return p;
            }

            if(isFree(p.x+1,p.y,p.z)) {
                arr[p.x][p.y][p.z] = -1;
                Point nextP = new Point(p.x+1,p.y,p.z, p);
                q.add(nextP);
            }

            if(isFree(p.x-1,p.y,p.z)) {
                arr[p.x][p.y][p.z] = -1;
                Point nextP = new Point(p.x-1,p.y,p.z, p);
                q.add(nextP);
            }

            if(isFree(p.x,p.y+1,p.z)) {
                arr[p.x][p.y][p.z] = -1;
                Point nextP = new Point(p.x,p.y+1,p.z, p);
                q.add(nextP);
            }

            if(isFree(p.x,p.y-1,p.z)) {
                arr[p.x][p.y][p.z] = -1;
                Point nextP = new Point(p.x,p.y-1,p.z, p);
                q.add(nextP);
            }

            if(isFree(p.x,p.y,p.z+1)) {
                arr[p.x][p.y][p.z] = -1;
                Point nextP = new Point(p.x,p.y,p.z+1, p);
                q.add(nextP);
            }

            if(isFree(p.x,p.y,p.z-1)) {
                arr[p.x][p.y][p.z] = -1;
                Point nextP = new Point(p.x,p.y,p.z-1, p);
                q.add(nextP);
            }

        }
        return null;
    }


    private static boolean isFree(int x, int y, int z) {
        if((x >= 0 && x < arr.length)
                && (y >= 0 && y < arr[1].length)
                && (z >= 0 && z < arr[2].length)
                && (arr[x][y][z] == 0 || arr[x][y][z] == 9)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        Point p = getPathBFS(0,0,0);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k<4; k++){
                    System.out.print(arr[i][j][k]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println(arr.length+" length");

        while(p.getParent() != null) {
            System.out.println(p);
            p = p.getParent();
        }

    }

}