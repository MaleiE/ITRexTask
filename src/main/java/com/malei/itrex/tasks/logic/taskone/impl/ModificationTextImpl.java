package com.malei.itrex.tasks.logic.taskone.impl;

import com.malei.itrex.tasks.exception.ApplicationException;
import com.malei.itrex.tasks.logic.io.ReadWriteFile;
import com.malei.itrex.tasks.logic.io.impl.ReadWriteFileImpl;
import com.malei.itrex.tasks.logic.taskone.ModificationText;

import java.util.LinkedList;
import java.util.List;

public class ModificationTextImpl implements ModificationText {

    @Override
    public StringBuilder deleteChar(StringBuilder text){
        final String si = "si";
        final String se = "se";
        final String ckTok = "k";
        final String k = "k";
        String s = text.toString().replaceAll("([Cc][Ii])",si).replaceAll("([Cc][Ee])", se).replaceAll("([Cc][Kk])", ckTok).replaceAll("([Cc])", k);
        text.setLength(0);
        return text.append(s);
    }

    @Override
    public StringBuilder deleteArticles(StringBuilder sb) {
        String text = sb.toString().replaceAll("\\b([Tt][Hh][Ee])\\b|\\b([Aa][Nn])\\b|\\b([Aa])\\b", "");
        sb.setLength(0);
        sb.append(text);
        return sb;

    }

    @Override
    public StringBuilder deleteDuplicatesChar(StringBuilder sb) {
        final String oo = "oo";
        final String ee = "ee";
        final String u = "u";
        final String i = "i";
        String text = sb.toString().replace(oo, u).replace(ee, i).replaceAll("([A-Za-z])\\1{1,}", "$1");
        sb.setLength(0);
        sb.append(text);
        return sb;
    }

    @Override
    public StringBuilder deleteLastChar(StringBuilder sb) {
        String text = sb.toString().replaceAll("(?<=\\w)[e](?!\\w)", "");
        sb.setLength(0);
        sb.append(text);
        return sb;
    }

    @Override
    public List modificationText() throws ApplicationException {
        ReadWriteFile rw = new ReadWriteFileImpl();
        List<String> text = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        try {
            for (Object o : rw.readText()) {
                sb.append(o);

                sb = deleteArticles(sb);
                sb = deleteChar(sb);
                sb = deleteDuplicatesChar(sb);
                sb = deleteLastChar(sb);

                if (!sb.toString().isEmpty()) {
                    text.add(sb.toString());
                }

                sb.delete(0, sb.length());
            }
        } catch (ApplicationException e) {
            throw new ApplicationException("Text not modified",e);
        }

        return text;
    }


}
