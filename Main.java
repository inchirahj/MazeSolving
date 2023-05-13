import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class Main 
{

  private static int rows;
  private static int cols;
  private static char [][] maze;
  private static int startYPosition;

  
  public static void main(String[] args) throws Exception 
  {
    // Ask the user to enter a file name.
    
    Scanner in = new Scanner(System.in);
		System.out.print("Enter maze file : ");
		String filename = in.nextLine();
		in.close();

    // Checking if the file exists. If it does, storing the maze that's in the file. 
    
    File file = new File(filename);
    Scanner rd = null;
    try 
      {
        rd = new Scanner(file);
        rows = rd.nextInt();
        cols = rd.nextInt();
        maze = new char[rows][cols];

        rd.nextLine();
        for(int i = 0; i< rows;i++)
        {
          String line = rd.nextLine();
          for(int j = 0; j < cols; j++)
          {
            maze[i][j] = line.charAt(j);
          }
        }
      rd.close();
      }
    catch (FileNotFoundException e)
      {
        System.out.println("File not found.\n");
			  return;
      }

    // Printing the original maze. 

    System.out.println();
    System.out.println("Here is the original maze:");
    print(maze);

    // Find the start position for this maze.
    
    startYPosition(maze, 0, 0);

    // Solve the maze and print it. If it can't be solved, print a message.  
    
    if (explore(maze, startYPosition, 0))
    {
      System.out.println("Here is the solved maze:");
      print(maze);
    }
    else
    {
      System.out.println("The maze cannot be solved!");
    }

  }
  
    // Print the maze
    public static void print(char[][]maze)
      {
          for(int i=0; i<rows; i++)
          {
            System.out.println();
            for(int j=0; j<cols; j++)
              {
                System.out.print(maze[i][j]);
              }
          }
        System.out.println("\n");
      }


    
    // Check if it is an open space or a wall.
    public static boolean isOpen(char[][] maze, int r, int c)
      {
        if (r >= 0 && r < rows && c >= 0 && c < cols)
        {
          return maze[r][c] == ' '; 
        }
        return false;
      }

  
    

    // Find the start of the maze (Y position).
    public static int startYPosition(char[][] maze, int r, int c)
    {
      startYPosition = 0;
      c = 0;
      for (r = 0; r < rows; r++)
        {
          if (isOpen(maze,r,c))
          {
            startYPosition = r;
          }
        }
      return startYPosition;
    }

    

    // Explore the maze to find a path.
    public static boolean explore(char[][] maze, int r, int c)
      {
        if (isOpen(maze, r, c))
        {
          maze[r][c] = '*';
          
          if (c == cols - 1)
          {
            return true;
          }

          // move up
          
          boolean nextMove = explore(maze, r-1, c);

          // move down
          
          if (nextMove == false)
          {
            nextMove = explore(maze, r+1, c);
          }

          // move right

          if (nextMove == false)
          {
            nextMove = explore(maze, r, c+1);
          }
         
          // move left

          if (nextMove == false)
          {
            nextMove = explore(maze, r, c-1);
          }

          return nextMove;
          
        }
        return false;
      }

    
}