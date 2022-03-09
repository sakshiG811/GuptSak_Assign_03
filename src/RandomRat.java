import java.util.Random;

/** Name: Sakshi Gupta
 * Date: 08-03-2022
 * Description: this rat is relatively smarter than the other two. Rather than pure randomness, it has a small
 * amount of memory that allows it to remember where it has been.
 */

public class RandomRat implements Animal{

    static Random rnd = new Random();

    int        startCol   = 0;
    int        startRow   = 0;
    int        previousRow = 0;
    int        previousCol = 0;
    int        currentCol = 0;
    int        currentRow = 0;
    String     name       = "NoName";
    int        numMoves   = 0;

    // returns current column animal is in
    @Override
    public int getColumn() {
        return currentCol;
    }                       /** Overridden Getter */

    // returns one letter to represent animal
    @Override
    public char getLetter() {
        return name.charAt(0);
    }                   /** Overridden Getter */

    // returns animal's name
    @Override
    public String getName() {
        return name;
    }                              /** Overridden Getter */

    // returns # moves animal has made in maze so far
    @Override
    public int getNumMoves() {
        return numMoves;
    }                           /** Overridden Getter */

    // returns current row animal is in
    @Override
    public int getRow() {
        return currentRow;
    }                               /** Overridden Getter */

    // returns column where animal started in maze
    @Override
    public int getStartColumn() {
        return startCol;
    }                           /** Overridden Getter */

    // returns row where animal started in maze
    @Override
    public int getStartRow() {
        return startRow;
    }                               /** Overridden Getter */

    /**
     * Overridden Move Method
     * @param maz this method implements the movement of the rat according to the instructions provided.
     */
    // asks animal to make a move in this maze. This is called by the Maze
    @Override
    public void move(Maze maz) {
        boolean noMoveFound = true;

        while ( noMoveFound)
            switch ( rnd.nextInt(4))
            {   case 0: if(((currentRow-1)!=previousRow||currentCol!=previousCol)&& maz.canMove(currentRow -1, currentCol) )
            {
                //System.out.println("here first "+(currentRow-1)+" "+previousRow+" "+currentCol+" "+previousCol);
                previousRow = currentRow;
                previousCol = currentCol;
                currentRow--;                         //up
                noMoveFound = false;

                if(maz.getSquare(currentRow,currentCol)!=Maze.FINISH) {
                    // checking dead end
                    int cnt = 0;
                    if (!maz.canMove(currentRow - 1, currentCol)) {
                        cnt++;
                    }
                    if (!maz.canMove(currentRow + 1, currentCol)) {
                        cnt++;
                    }
                    if (!maz.canMove(currentRow, currentCol - 1)) {
                        cnt++;
                    }
                    if (!maz.canMove(currentRow, currentCol + 1)) {
                        cnt++;
                    }
                    if (cnt == 3) {

                        numMoves++;

                        int saveRow = currentRow;
                        int saveCol = currentCol;
                        currentRow = previousRow;
                        currentCol = previousCol;
                        previousRow = saveRow;
                        previousCol = saveCol;
                    }
                }

            }
                break;
                case 1: if((currentRow!=previousRow||(currentCol+1)!=previousCol)&& maz.canMove(currentRow , currentCol + 1) )
                {
                    //System.out.println("here second "+(currentRow)+" "+previousRow+" "+(currentCol+1)+" "+previousCol);
                    previousRow = currentRow;
                    previousCol = currentCol;
                    currentCol++;                         //RIGHT
                    noMoveFound = false;
                    if(maz.getSquare(currentRow,currentCol)!=Maze.FINISH) {
                        // checking dead end
                        int cnt = 0;
                        if (!maz.canMove(currentRow - 1, currentCol)) {
                            cnt++;
                        }
                        if (!maz.canMove(currentRow + 1, currentCol)) {
                            cnt++;
                        }
                        if (!maz.canMove(currentRow, currentCol - 1)) {
                            cnt++;
                        }
                        if (!maz.canMove(currentRow, currentCol + 1)) {
                            cnt++;
                        }
                        if (cnt == 3) {
                            numMoves++;
                            int saveRow = currentRow;
                            int saveCol = currentCol;
                            currentRow = previousRow;
                            currentCol = previousCol;
                            previousRow = saveRow;
                            previousCol = saveCol;
                        }
                    }
                }
                    break;
                case 2: if(((currentRow+1)!=previousRow||currentCol!=previousCol)&& maz.canMove(currentRow + 1 , currentCol ) )
                {
                    //System.out.println("here third "+(currentRow+1)+" "+previousRow+" "+currentCol+" "+previousCol);
                    previousRow = currentRow;
                    previousCol = currentCol;
                    currentRow++;                         //DOWN
                    noMoveFound = false;
                    if(maz.getSquare(currentRow,currentCol)!=Maze.FINISH) {
                        // checking dead end
                        int cnt = 0;
                        if (!maz.canMove(currentRow - 1, currentCol)) {
                            cnt++;
                        }
                        if (!maz.canMove(currentRow + 1, currentCol)) {
                            cnt++;
                        }
                        if (!maz.canMove(currentRow, currentCol - 1)) {
                            cnt++;
                        }
                        if (!maz.canMove(currentRow, currentCol + 1)) {
                            cnt++;
                        }
                        if (cnt == 3) {
                            numMoves++;
                            int saveRow = currentRow;
                            int saveCol = currentCol;
                            currentRow = previousRow;
                            currentCol = previousCol;
                            previousRow = saveRow;
                            previousCol = saveCol;
                        }
                    }
                }
                    break;
                case 3: if((currentRow!=previousRow||(currentCol-1)!=previousCol)&& maz.canMove(currentRow  , currentCol - 1))
                {
                    //System.out.println("here fourth "+(currentRow)+" "+previousRow+" "+(currentCol-1)+" "+previousCol);
                    previousRow = currentRow;
                    previousCol = currentCol;
                    currentCol--;                         //Left
                    noMoveFound = false;

                    if(maz.getSquare(currentRow,currentCol)!=Maze.FINISH) {
                        // checking dead end
                        int cnt = 0;
                        if (!maz.canMove(currentRow - 1, currentCol)) {
                            cnt++;
                        }
                        if (!maz.canMove(currentRow + 1, currentCol)) {
                            cnt++;
                        }
                        if (!maz.canMove(currentRow, currentCol - 1)) {
                            cnt++;
                        }
                        if (!maz.canMove(currentRow, currentCol + 1)) {
                            cnt++;
                        }
                        if (cnt == 3) {
                            numMoves++;
                            int saveRow = currentRow;
                            int saveCol = currentCol;
                            currentRow = previousRow;
                            currentCol = previousCol;
                            previousRow = saveRow;
                            previousCol = saveCol;
                        }
                    }
                }
                    break;


            }

        numMoves++;
    }

    // moves animal back to starting row/column, wipes # moves to 0
    @Override
    public void reset() {                                   /** Overridden reset method */
        currentRow = startRow;
        currentCol = startCol;
        previousCol = startCol;
        previousRow = startRow;
        numMoves = 0;
    }

    // sets column where animal started in maze
    @Override
    public void setStartColumn(int col) {
        startCol = col;
    }           /** Overridden Setter */

    // sets row where animal started in maze
    @Override
    public void setStartRow(int row) {
        startRow = row;
    }               /** Overridden Setter */
}
