
/**
 * Write a description of class RouteCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RouteCipher
{
    private String [][] letterBlock;
    private int numRows;
    private int numCols;

    public RouteCipher(int row,int col)
    {
        numRows = row;
        numCols = col;
        letterBlock = new String[row][col];
    }

    /**
     * Used for testing.
     * @param message the string to send to fillBlock
     * @return letterBlock;
     */
    public String[][] fillAndGetLetterBlock(String message){
        fillBlock(message);
        return letterBlock;
    }

    /**
     * Places a string into letterBlock in row-major order. 
     * @param str the string to be processed
     * Postcondition:
     *     if str.length() < numRows * numCols, "A" is placed in each unfilled cell
     *     if str.length() > numRows * numCols, trailing characters are ignored
     */
    public void fillBlock(String str) {
        int place = 0, finX = 0, finY = 0;
        for(int x = 0; x < numRows; x++)
        {
            for(int y = 0; y < numCols; y++)
            {
                if(place < str.length())
                {
                    letterBlock[x][y] = str.substring(place,place+1);
                    place++;
                }
                else
                {
                    letterBlock[x][y] = "A"; 
                }
            }
        }
        /*if(place < numRows * numCols)
        {
        for(int x = finX; x < numRows; x++)
        {
        for(int y = finY; y < numCols; y++)
        {
        letterBlock[x][y] = "A";
        }
        }
        }*/

    }

    /** Extracts encrypted string from letterBlock in column-major order.
     * Precondition: letterBlock has been filled
     * @return the encrypted string from letterBlock
     */
    private String encryptBlock()
    { /* implementation not shown in description */
        String encrypted = "";
        for(int c=0;c<letterBlock[0].length;c++)
            for(int r=0;r<letterBlock.length;r++)
                encrypted+=letterBlock[r][c];
        return encrypted;
    }

    /** Encrypts a message.
     * @param message the string to be encrypted
     * @return the encrypted message;
     *         if message is the empty string, returns the empty string 
     */
    public String encryptMessage(String message) {
        String retStr = "";
        if(message.length() == 0)
            return message;
        for(int place = 0; place < message.length(); place += numRows*numCols)
        {
            fillBlock(message.substring(place, place + (numRows*numCols)));
            retStr += encryptBlock();
            place += numRows * numCols;
        }
        return retStr;
    }
}
