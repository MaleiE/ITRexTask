package com.malei.itrex.tasks.logic.taskone;

import com.malei.itrex.tasks.exception.ApplicationException;

import java.util.List;

public interface ModificationText {

    StringBuilder deleteChar(StringBuilder text);

    StringBuilder deleteArticles(StringBuilder sb);

    StringBuilder deleteDuplicatesChar(StringBuilder sb);

    StringBuilder deleteLastChar(StringBuilder sb);

    List modificationText()throws ApplicationException;

}
