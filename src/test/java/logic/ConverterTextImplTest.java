package logic;

import com.malei.itrex.tasks.logic.taskone.ModificationText;
import com.malei.itrex.tasks.logic.taskone.impl.ModificationTextImpl;
import org.junit.Assert;
import org.junit.Test;

public class ConverterTextImplTest {

    private ModificationText mt = new ModificationTextImpl();
    private StringBuilder sb = new StringBuilder();

    private static final String IN_DELETE_C = "success";
    private static final String OUT_DELETE_C = "suksess";
    private static final String IN_DELETE_DOUBLE_LETTER = "iee. iee eeii ooooo";
    private static final String OUT_DELETE_DOUBLE_LETTER = "i. i i uo";
    private static final String IN_DELETE_LAST_LETTER_E = "The. the thee e. e E e ethe";
    private static final String OUT_DELETE_LAST_LETTER_E = "Th. th the e. e E e eth";
    private static final String IN_ARTICLES = "an An. the, The a";
    private static final String OUT_ARTICLES = " . ,  ";

    @Test
    public void removeCharTest() throws Exception {
        sb.append(IN_DELETE_C);
        sb = mt.deleteChar(sb);
        Assert.assertEquals(OUT_DELETE_C, sb.toString());
    }

    @Test
    public void deleteDuplicatesCharTest() throws Exception {
        sb.append(IN_DELETE_DOUBLE_LETTER);
        sb = mt.deleteDuplicatesChar(sb);
        System.out.println(sb);
        Assert.assertEquals(OUT_DELETE_DOUBLE_LETTER, sb.toString());
    }

    @Test
    public void deleteLastCharTest() throws Exception {
        sb.append(IN_DELETE_LAST_LETTER_E);
        sb = mt.deleteLastChar(sb);
        Assert.assertEquals(OUT_DELETE_LAST_LETTER_E, sb.toString());
    }

    @Test
    public void deleteArticlesTest() throws Exception {
        sb.append(IN_ARTICLES);
        sb = mt.deleteArticles(sb);
        Assert.assertEquals(OUT_ARTICLES, sb.toString());
    }


}
