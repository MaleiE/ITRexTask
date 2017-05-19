package com.malei.itrex.tasks.logic;
import com.malei.itrex.tasks.exception.ApplicationException;
import com.malei.itrex.tasks.logic.io.ReadWriteFile;
import com.malei.itrex.tasks.logic.io.impl.ReadWriteFileImpl;
import com.malei.itrex.tasks.logic.taskone.ModificationText;
import com.malei.itrex.tasks.logic.taskone.impl.ModificationTextImpl;


public class RunTaskOne {
    public static void main(String[] args) {
        ModificationText mt = new ModificationTextImpl();
        ReadWriteFile rw = new ReadWriteFileImpl();
        StringBuilder sb = new StringBuilder();

        try {
            for (Object o : mt.modificationText()) {
                System.out.print(o);
                sb.append(o);
            }
            rw.writeText(sb.toString());
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
    }
}
