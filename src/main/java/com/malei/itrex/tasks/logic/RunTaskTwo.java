package com.malei.itrex.tasks.logic;

import com.malei.itrex.tasks.logic.io.ReadWriteFile;
import com.malei.itrex.tasks.logic.io.impl.ReadWriteFileImpl;
import com.malei.itrex.tasks.logic.tasktwo.PrinceOfPersiaMaze;
import com.malei.itrex.tasks.logic.tasktwo.impl.PrinceOfPersiaMazeImpl;


public class RunTaskTwo {
    public static void main(String[] args){
        try {
            ReadWriteFile rw = new ReadWriteFileImpl();
            PrinceOfPersiaMaze p = new PrinceOfPersiaMazeImpl();

            p.buildMaze(rw.readText());
            rw.writeText(p.start());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
