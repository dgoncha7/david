
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class RouteCipherTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class RouteCipherTest
{
    private RouteCipher routeCip1,routeCip2;

    /**
     * Default constructor for test class RouteCipherTest
     */
    public RouteCipherTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        routeCip1 = new RouteCipher(2, 3);
        routeCip2 = new RouteCipher(3, 5);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void encyptEntireMessage()
    {
        assertEquals("Mte eati dmnitgAhA", routeCip1.encryptMessage("Meet at midnight"));
    }

    @Test
    public void ecryptEmptyString()
    {
        assertEquals("", routeCip1.encryptMessage(""));
    }

    @Test
    public void fillBlockNoFiller()
    {
        String[][] expected = {{"A","r","n"},
                               {"o","l","d"}};

        assertArrayEquals(expected, routeCip1.fillAndGetLetterBlock("Arnold"));
    }

    @Test
    public void fillLargerBlockWithFiller()
    {
        String[][] expected = {{"M","e","e","t"," "},
                               {"a","t"," ","n","o"},
                               {"o","n","A","A","A"}};
        assertArrayEquals(expected, routeCip2.fillAndGetLetterBlock("Meet at noon"));
    }
    
    @Test
    public void fillLargerBlockNoFillerLargerString()
    {
        String[][] expected = {{"M","e","e","t"," "},
                               {"a","t"," ","m","i"},
                               {"d","n","i","g","h"}};

        assertArrayEquals(expected, routeCip2.fillAndGetLetterBlock("Meet at midnight"));
    }

    @Test
    public void encryptLargerBlock()
    {
        assertEquals("Maoetne AtnA oA", routeCip2.encryptMessage("Meet at noon"));
    }

    @Test
    public void encryptLargerBlock2()
    {
        assertEquals("Madetne itmg ihtAAAAAAAAAAAAAA", routeCip2.encryptMessage("Meet at midnight"));
    }
    
    @Test
    public void encryptLargerBlockNoFiller()
    {
        assertEquals("Madetne itmg ih", routeCip2.encryptMessage("Meet at midnigh"));
    }
}



