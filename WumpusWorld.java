// https://www.javatpoint.com/the-wumpus-world-in-artificial-intelligence
// https://www.geeksforgeeks.org/ai-the-wumpus-world-description/
// https://programsinengineering.blogspot.com/2017/02/wumpus-world-problem-implementation.html 

import java.util.Scanner;
public class WumpusWorld {
  private static final char stench = 'S';
  private static final char breeze = 'B';
  private static final char wumpus = 'W';
  private static final char agent = 'A';
  private static final char gold = 'G';
  private static final char pit = 'P';
  private static final char empty = ' ';
  private static char[][] board;
  private static int row;
  private static int column;
  private static boolean wumpusKilled = false;
  private static boolean isGold = false;
  private static int arrows = 1;
  private static void generateCheck() {
    if (board[row][column] == wumpus && !wumpusKilled) {
      System.out.println("Wumpus is killed!");
      System.exit(0);
    } else if (board[row][column] == wumpus && wumpusKilled) {
      System.out.println("Wumpus is dead.");
    } else if (board[row][column] == pit) {
      System.out.println("Pit is done");
      System.exit(0);
    }
  }

  private static void initalizeBoard() {
    board = new char[4][4];
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        board[i][j] = empty;
      }
    }
    int wumpusRow = (int)(Math.random() * 4);
    int wumpusCol = (int)(Math.random() * 4);
    board[wumpusRow][wumpusCol] = wumpus;
    int goldRow = (int)(Math.random() * 4);
    int goldCol = (int)(Math.random() * 4);
    board[goldRow][goldCol] = gold;
    for (int i = 0; i < 3; i++) {
      int pitRow = (int)(Math.random() * 4);
      int pitCol = (int)(Math.random() * 4);
      board[pitRow][pitCol] = pit;
    }
    row = (int)(Math.random() * 4);
    column = (int)(Math.random() * 4);
    board[row][column] = agent;

    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        if (board[i][j] == wumpus || board[i][j] == pit) {
          if (i > 0) {
            if (board[i - 1][j] == empty) {
              board[i - 1][j] = stench;
            }
            if (board[i - 1][j] == agent) {
              System.out.println("you feel a stench!");
            }
          }
        }
        if (i < 3) {
          if (board[i + 1][j] == empty) {
            board[i + 1][j] = breeze;
          }
          if (board[i + 1][j] == agent) {
            System.out.println("you feel a breeze!");
          }
        } else if (board[i][j] == pit) {
          if (i > 0) {
            if (board[i - 1][j] == empty) {
              board[i - 1][j] = breeze;
            }
            if (board[i - 1][j] == agent) {
              System.out.println("you feel a breeze!");
            }
          }
          if (i < 3) {
            if (board[i + 1][j] == empty) {
              board[i + 1][j] = breeze;
            }
            if (board[i + 1][j] == agent) {
              System.out.println("you feel a breeze!");
            }
          }
          if (j > 0) {
            if (board[i][j - 1] == empty) {
              board[i][j - 1] = breeze;
            }
            if (board[i][j - 1] == agent) {
              System.out.println("you feel a breeze!");
            }
          }
          if (j < 3) {
            if (board[i][j + 1] == empty) {
              board[i][j + 1] = breeze;
            }
            if (board[i][j + 1] == agent) {
              System.out.println("you feel a breeze!");
            }
          }
        }
      }
    }
  }
  private static void print() {
    System.out.println("S stands for stench");
    System.out.println("B stands for breeze");
    System.out.println("W stands for wumpus ");
    System.out.println("A stands for agent");
    System.out.println("G stands for gold ");
    System.out.println("P stands for pit ");
    System.out.println("-------------------");
    for (int i = 0; i < 4; i++) {
      System.out.print("| ");
      for (int j = 0; j < 4; j++) {
        System.out.print(board[i][j] + " | ");
      }
      System.out.println();
      System.out.println("-------------------");
    }
  }

  private static void generateMoving(int rowShift, int colShift) {
    if (row + rowShift < 0 || row + rowShift > 3 || column + colShift < 0 || column + colShift > 3) {
      System.out.println("move isn't right!");
      return;
    }
    board[row][column] = empty;
    row += rowShift;
    column += colShift;
    board[row][column] = agent;
    generateCheck();
  }
  private static void generatePickUp() {
    if (board[row][column] == gold) {
      isGold = true;
      System.out.println("You picked up gold");
    } else {
      System.out.println("No gold here");
    }
  }


  private static void shootArrow(int rowShift, int colShift) {
    if (arrows <= 0) {
      System.out.println("You finshed the arrows!");
      return;
    }

    if (row + rowShift < 0 || row + rowShift > 3 || column + colShift < 0 || column + colShift > 3) {
      System.out.println("Move cannot be made try again!");
      return;
    }

    int arrowRow = row; int arrowCol = column;
    while (arrowRow >= 0 && arrowRow <= 3 && arrowCol >= 0 && arrowCol <= 3) {
      if (board[arrowRow][arrowCol] == wumpus) {
        wumpusKilled = true;
        System.out.println("Wumpus dead");
        board[arrowRow][arrowCol] = empty;
        break;
      }
      arrowRow += rowShift;
      arrowCol += colShift;
    }

    arrows--;
  }

  private static void makeMove() { // Asks the user for input 
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter a direction, just the capitalized first letter Up/Down/Left/Right/Gold/Shoot ");
    String input = scanner.nextLine(); 
    char move = input.charAt(0);
    switch (move) {
    case 'U': // up
      generateMoving(-1, 0);
      break;
    case 'D': //down
      generateMoving(1, 0);
      break;
    case 'L': //left
      generateMoving(0, -1);
      break;
    case 'R': //right
      generateMoving(0, 1);
      break;
    case 'G': // picking up gold 
      generatePickUp();
      break;
    case 'S':
      if (input.length() < 2) {
        System.out.println("Shoot is not correct");
        break;
      }
      char direction = input.charAt(1);
      switch (direction) {
      case 'U':
        shootArrow(-1, 0);
        break;
      case 'D':
        shootArrow(1, 0);
        break;
      case 'L':
        shootArrow(0, -1);
        break;
      case 'R':
        shootArrow(0, 1);
        break;
      default:
        System.out.println("Direction not available, Try Again");
        break;
      }
      break;
    default:
      System.out.println("Move isn't valid");
      break;
    }
  }
  public static void main(String[] args) {
    initalizeBoard();
    print();
    while (true) {
      if (isGold && row == 0 && column == 0) {
        System.out.println("Winner!");
        break;
      }
      if (board[row][column] == wumpus || board[row][column] == pit) {
        System.out.println("Game lost");
        break;
      }
      makeMove();
      print();
    }
  }

}