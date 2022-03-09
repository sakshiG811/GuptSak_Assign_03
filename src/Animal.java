
/** Name: Sakshi Gupta
 * Date: 08-03-2022
 * Description: Represents all animals that can be put into a maze.
 * Implemented by rat classes.
 */

public interface Animal
{
  // constants to represent directions
  public static final Object UP = "Up";
  public static final Object DOWN = "Down";
  public static final Object LEFT = "Left";
  public static final Object RIGHT = "Right";

  // returns current column animal is in
  int getColumn();
  
  // returns one letter to represent animal
  char getLetter();
  
  // returns animal's name
  String getName();
  
  // returns # moves animal has made in maze so far
  int getNumMoves();
  
  // returns current row animal is in
  int getRow();
  
  // returns column where animal started in maze
  int getStartColumn();
  
  // returns row where animal started in maze
  int getStartRow();
  
  // asks animal to make a move in this maze
  void move(Maze maz);
  
  // moves animal back to starting row/column, wipes # moves to 0
  void reset();

    // sets column where animal started in maze
  void setStartColumn(int col);
  
  // sets row where animal started in maze
  void setStartRow(int row);
}