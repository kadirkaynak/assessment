import com.cern.Office;
import com.cern.SpreadsheetImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Below, you will find a bunch of tests, that describe a simple spreadsheet engine. Write the business code that make
 * all tests pass.
 * <p>
 * In order to fully work in a TDD (Test Driven Development) way, we strongly encourage you to write
 * only the necessary code to make the tests pass one by one, in order. You will have to make some refactorings along
 * the way, of course.
 * <p>
 * You can find the test suite here: xxx (link to the code below in hastebin.com AND pastee.org)
 * <p>
 * Use Java for this exercise.
 */
@RunWith(JUnit4.class)
public class Question {

    private SpreadsheetImpl sheet;

    @Before
    public void setup() {
        int rows = 10;
        int columns = 5;
        sheet = Office.newSpreadsheet(rows, columns);
    }

    @Test
    public void cellsAreEmptyByDefault() {
        Assert.assertEquals("", sheet.get(0, 0));
        Assert.assertEquals("", sheet.get(3, 4));
    }

    @Test
    public void cellsAreStored() {
        sheet.put(1, 2, "foo");
        Assert.assertEquals("foo", sheet.get(1, 2));

        sheet.put(3, 3, "bar");
        Assert.assertEquals("bar", sheet.get(3, 3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void cantGetOutOfLimits() {
        sheet.get(12, 3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void cantPutOutOfLimits() {
        sheet.put(3, 7, "foo");
    }
}