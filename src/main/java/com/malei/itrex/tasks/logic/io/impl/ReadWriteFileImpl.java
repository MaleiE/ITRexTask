package com.malei.itrex.tasks.logic.io.impl;

import com.malei.itrex.tasks.exception.ApplicationException;
import com.malei.itrex.tasks.logic.io.ReadWriteFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ReadWriteFileImpl implements ReadWriteFile {

    private BufferedReader reader;
    private BufferedWriter writer;

    private final static String PROPERTIES = "path";
    private final static String INPUT_PATH = "path.input";
    private final static String OUTPUT_PATH = "path.output";

    @Override
    public List readText() throws ApplicationException {

        List<String> strings = new ArrayList<>();
        try {
            String inputPath = getProperties(INPUT_PATH);
            reader = new BufferedReader(new FileReader(inputPath));
            String line;
            while ((line = reader.readLine()) != null) {
                strings.add(line);
            }
        } catch (IOException e) {
            throw new ApplicationException("The file is not read", e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                    reader = null;
                } catch (IOException e) {
                    throw new ApplicationException("Reader is not closed", e);
                }
            }
        }
        return strings;
    }

    @Override
    public void writeText(String text) throws ApplicationException {
        try {
            String outputPath = getProperties(OUTPUT_PATH);
            writer = new BufferedWriter(new FileWriter(outputPath));
            writer.append(text);

        } catch (IOException e) {
            throw new ApplicationException("The text is not written", e);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    throw new ApplicationException("Writer is not closed", e);
                }
            }
        }
    }

    private String getProperties(String key) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(PROPERTIES);
        return resourceBundle.getString(key);
    }

}
