import java.util.LinkedList;
import java.util.Queue;

/** Name: Sakshi Gupta
 * Date: 08-03-2022
 * Description: The maze is considered to be a tree with each choice in direction being an
 * edge to another node in the tree. The rat visits all the nodes in the first level of depth.
 */

class Pair{
    public int x,y;
    public Pair(int x,int y)            /** Constructor */
    {
        this.x = x;
        this.y = y;
    }

}

public class CustomRat implements Animal{

    int        startCol   = 0;
    int        startRow   = 0;
    int        currentCol = 0;
    int        currentRow = 0;
    String     name       = "NoName";
    int        numMoves   = 0;
    boolean    visited[][] = new boolean[1001][1001];
    Queue<Pair> q
            = new LinkedList<>();

    // returns current column animal is in
    @Override
    public int getColumn() {
        return currentCol;
    }                   /** Overridden Getter */

    // returns one letter to represent animal
    @Override
    public char getLetter() {
        return name.charAt(0);
    }               /** Overridden Getter */

    // returns animal's name
    @Override
    public String getName() {
        return name;
    }                           /** Overridden Getter */

    // returns # moves animal has made in maze so far
    @Override
    public int getNumMoves() {
        return numMoves;
    }                       /** Overridden Getter */

    // returns current row animal is in
    @Override
    public int getRow() {
        return currentRow;
    }                           /** Overridden Getter */

    // returns column where animal started in maze
    @Override
    public int getStartColumn() {
        return startCol;
    }                       /** Overridden Getter */

    // returns row where animal started in maze
    @Override
    public int getStartRow() {
        return startRow;
    }                           /** Overridden Getter */

    /**
     * Overridden Move Method
     * @param maz this method implements the movement of the rat according to the instructions provided.
     */
    // asks animal to make a move in this maze. This is called by the Maze
    @Override
    public void move(Maze maz) {
        // applying BFS algorithm
        if(q.size()==0&&startRow==currentRow&&startCol==currentCol)
        {
            q.add(new Pair(currentRow,currentCol));
            visited[currentRow][currentCol] = true;
            return;
        }
        Pair p = q.remove();
        currentRow = p.x;
        currentCol = p.y;

        // going counter clockwise-> Down, Right, Up, Left
        if(maz.canMove(currentRow+1,currentCol) && !visited[currentRow+1][currentCol] )
        {
            q.add(new Pair(currentRow+1,currentCol));
            visited[currentRow+1][currentCol] = true;
        }
        if(maz.canMove(currentRow,currentCol+1) && !visited[currentRow][currentCol+1] )
        {
            q.add(new Pair(currentRow,currentCol+1));
            visited[currentRow][currentCol+1] = true;
        }
        if(maz.canMove(currentRow-1,currentCol) && !visited[currentRow-1][currentCol] )
        {
            q.add(new Pair(currentRow-1,currentCol));
            visited[currentRow-1][currentCol] = true;
        }
        if(maz.canMove(currentRow,currentCol-1) && !visited[currentRow][currentCol-1] )
        {
            q.add(new Pair(currentRow,currentCol-1));
            visited[currentRow][currentCol-1] = true;
        }
        numMoves++;
    }

    // moves animal back to starting row/column, wipes # moves to 0
    @Override
    public void reset() {                                       /** Overridden reset method */
        currentRow = startRow;
        currentCol = startCol;
        numMoves = 0;
    }

    // sets column where animal started in maze
    @Override
    public void setStartColumn(int col) {
        startCol = col;
    }               /** Overridden setter */

    // sets row where animal started in maze
    @Override
    public void setStartRow(int row) {
        startRow = row;
    }                   /** Overridden setter */
}
