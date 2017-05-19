package com.malei.itrex.tasks.logic.io;

import com.malei.itrex.tasks.exception.ApplicationException;

import java.util.List;

public interface ReadWriteFile {

    List readText() throws ApplicationException;

    void writeText(String text) throws ApplicationException;
}
