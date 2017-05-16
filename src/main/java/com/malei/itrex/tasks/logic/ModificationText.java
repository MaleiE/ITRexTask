package com.malei.itrex.tasks.logic;

public interface ModificationText {

    public StringBuilder deleteChar(StringBuilder text);

    public StringBuilder deleteArticles(StringBuilder sb);

    public StringBuilder deleteDuplicatesChar(StringBuilder sb);

    public StringBuilder deleteLastChar(StringBuilder sb);

}
