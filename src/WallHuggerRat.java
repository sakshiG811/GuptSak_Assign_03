
/** Name: Sakshi Gupta
 * Date: 08-03-2022
 * Description: This rat hates going left so instead of doing things randomly, it always goes right relative to its
 * orientation.
 */
public class WallHuggerRat implements Animal{

    int        startCol   = 0;
    int        startRow   = 0;
    int        currentCol = 0;
    int        currentRow = 0;
    String     name       = "NoName";
    int        numMoves   = 0;
    int        orientation = -1;

    // returns current column animal is in
    @Override
    public int getColumn() {
        return currentCol;
    }           /** Overridden Getter */

    // returns one letter to represent animal
    @Override
    public char getLetter() {
        return name.charAt(0);
    }       /** Overridden Getter */

    // returns animal's name
    @Override
    public String getName() {
        return name;
    }                   /** Overridden Getter */

    // returns # moves animal has made in maze so far
    @Override
    public int getNumMoves() {
        return numMoves;
    }               /** Overridden Getter */

    // returns current row animal is in
    @Override
    public int getRow() {
        return currentRow;
    }                   /** Overridden Getter */

    // returns column where animal started in maze
    @Override
    public int getStartColumn() {
        return startCol;
    }               /** Overridden Getter */

    // returns row where animal started in maze
    @Override
    public int getStartRow() {
        return startRow;
    }                   /** Overridden Getter */

    /**
     * Overridden Move Method
     * @param maz this method implements the movement of the rat according to the instructions provided.
     */
    // asks animal to make a move in this maze. This is called by the Maze
    @Override
    public void move(Maze maz) {
        if(orientation <= 0)
        {
            if( maz.canMove(currentRow , currentCol + 1))
            {   currentCol++;                         //RIGHT
                orientation = 3;
            }
            else if( maz.canMove(currentRow -1, currentCol))
            {   currentRow--;                         //up
                orientation = 0;
            }
            else if( maz.canMove(currentRow  , currentCol - 1))
            {   currentCol--;                         //Left
                orientation = 2;
            }
            else if( maz.canMove(currentRow + 1 , currentCol ))
            {   currentRow++;                         //DOWN
                orientation = 1;
            }
        }
        else if(orientation == 1)
        {
            if( maz.canMove(currentRow  , currentCol - 1))
            {   currentCol--;                         //Left
                orientation = 2;
            }
            else if( maz.canMove(currentRow + 1 , currentCol ))
            {   currentRow++;                         //DOWN
                orientation = 1;
            }
            else if( maz.canMove(currentRow , currentCol + 1))
            {   currentCol++;                         //RIGHT
                orientation = 3;
            }
            else if( maz.canMove(currentRow -1, currentCol))
            {   currentRow--;                         //up
                orientation = 0;
            }
        }
        else if(orientation == 2)
        {
            if( maz.canMove(currentRow -1, currentCol))
            {   currentRow--;                         //up
                orientation = 0;
            }
            else if( maz.canMove(currentRow  , currentCol - 1))
            {   currentCol--;                         //Left
                orientation = 2;
            }
            else if( maz.canMove(currentRow + 1 , currentCol ))
            {   currentRow++;                         //DOWN
                orientation = 1;
            }
            else if( maz.canMove(currentRow , currentCol + 1))
            {   currentCol++;                         //RIGHT
                orientation = 3;
            }

        }
        else if(orientation == 3)
        {
            if( maz.canMove(currentRow + 1 , currentCol ))
            {   currentRow++;                         //DOWN
                orientation = 1;
            }
            else if( maz.canMove(currentRow , currentCol + 1))
            {   currentCol++;                         //RIGHT
                orientation = 3;
            }
            else if( maz.canMove(currentRow -1, currentCol))
            {   currentRow--;                         //up
                orientation = 0;
            }
            else if( maz.canMove(currentRow  , currentCol - 1))
            {   currentCol--;                         //Left
                orientation = 2;
            }
        }
        numMoves++;
    }

    // moves animal back to starting row/column, wipes # moves to 0
    @Override
    public void reset() {                                           /** Overridden reset method */
        currentRow = startRow;
        currentCol = startCol;
        orientation = -1;
        numMoves = 0;
    }

    // sets column where animal started in maze
    @Override
    public void setStartColumn(int col) {
        startCol = col;
    }           /** Overridden setter */

    // sets row where animal started in maze
    @Override
    public void setStartRow(int row) {
        startRow = row;
    }               /** Overridden setter */
}
