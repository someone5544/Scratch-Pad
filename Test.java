import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Test
{
  // Variables.
  private int _cols;
  private int _rows;
  private int _gen;
  private char[][] _board;

  public Test() throws FileNotFoundException
  {
    // Ask user for file and initialize board.
    String fileName;
    Scanner kb = new Scanner(System.in);
    //System.out.print("Please enter the file name: ");
    //fileName = kb.next();
    fileName = "C:\\Users\\Miku\\Documents\\GitHub\\Scratch-Pad\\Readable.txt";
    File file = new File(fileName);
    Scanner scanFile = new Scanner(file);
    _cols = scanFile.nextInt();
    _rows = scanFile.nextInt();
    scanFile.nextLine();
    _board = new char[_rows][_cols];
    for(int i = 0; i<_rows; i++)
    {
      String line = scanFile.nextLine();
      String[] pieces = line.split(" ");
      for(int j = 0; j<_cols; j++)
      {
        _board[i][j] = pieces[j].charAt(0);
      }
    }
    _gen = 1;
    System.out.println("Initialized game board.");
  }

  public int getColumns()
  {
    return _cols;
  }

  public int getRows()
  {
    return _rows;
  }

  public char getCell(int col, int row)
  {
    if(col >= _cols || row >= _rows)
    {
      return '\0';
    }
    if(col < 0 || row < 0)
    {
      return '\0';
    }
    return _board[row][col];
  }

  public void setCell(int col, int row, char val)
  {
    _board[row][col] = val;
  }

  public void computeNextGeneration(int gens)
  {
    char[][] tempArray = new char[_rows][_cols];
    // Loop through board.
    for(int i = 0; i<_rows; i++)
    {
      for(int j = 0; j<_cols; j++)
      {
        int alive = findAliveNeighbors(j, i);
        if(getCell(j, i) == 'X')
        {
          // Cell is alive.
          if(alive < 2)
          {
            // Loneliness.
            tempArray[i][j] = '0';
          }
          else if(alive > 3)
          {
            // Overpop.
            tempArray[i][j] = '0';
          }
        }
        else if(getCell(j, i) == '0')
        {
          if(alive == 3)
          {
            tempArray[i][j] = 'X';
          }
        }
      }
    }
    // Combine changes.
    for(int i = 0; i<_rows; i++)
    {
      for(int j = 0; j<_cols; j++)
      {
        if(tempArray[i][j] != '\0')
        {
          setCell(j, i, tempArray[i][j]);
        }
      }
    }
    gens--;
    _gen++;
    // Print generation.
    print();
    // Compute next generation.
    if(gens > 1)
    {
      computeNextGeneration(gens);
    }
  }

  public void printArr(char[][] arr)
  {
    for(int i = 0; i<_rows; i++)
    {
      for(int j = 0; j<_cols; j++)
      {
        System.out.print(arr[i][j]);
        System.out.print(" ");
      }
      System.out.println();
    }
    System.out.println();
  }

  public void print()
  {
    // Print game board.
    System.out.println("Generation " + _gen + "\n");
    for(int i = 0; i<_rows; i++)
    {
      for(int j = 0; j<_cols; j++)
      {
        System.out.print(_board[i][j]);
        System.out.print(" ");
      }
      System.out.println();
    }
    System.out.println();
  }

  private int findAliveNeighbors(int col, int row)
  {
    int alive = 0;
    // Check left and right.
    if(getCell(col-1, row) == 'X')
    {
      alive++;
    }
    if(getCell(col+1, row) == 'X')
    {
      alive++;
    }
    // Up and down.
    if(getCell(col, row-1) == 'X')
    {
      alive++;
    }
    if(getCell(col, row+1) == 'X')
    {
      alive++;
    }
    // Diagonal.
    if(getCell(col-1, row-1) == 'X')
    {
      alive++;
    }
    if(getCell(col-1, row+1) == 'X')
    {
      alive++;
    }
    if(getCell(col+1, row-1) == 'X')
    {
      alive++;
    }
    if(getCell(col+1, row+1) == 'X')
    {
      alive++;
    }
    return alive;
  }

  public static void main(String[] args) throws FileNotFoundException
  {
    Test testGame = new Test();
    testGame.print();
    testGame.computeNextGeneration(15);
  }
}
