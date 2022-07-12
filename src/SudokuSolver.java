import java.util.*;

 /** 
 * This program takes in a 2d array for the sudoku puzzle and solves it.
 * @author William Morgan
 * @version 1.0
 */

public class SudokuSolver {

    /**
     * This number represents the size of the sudoku puzzle.
     */
    private static final int GRID_SIZE = 9;

    /**
     * This variable is used to store the 2d array of the sudoku puzzle.
     */
    public static int[][] puzzle = { {0,0,6,0,0,0,0,0,1},
                                     {0,7,0,0,6,0,0,5,0},
                                     {8,0,0,1,0,3,2,0,0},
                                     {0,0,5,0,4,0,8,0,0},
                                     {0,4,0,7,0,2,0,9,0},
                                     {0,0,8,0,1,0,7,0,0},
                                     {0,0,1,2,0,5,0,0,3},
                                     {0,6,0,0,7,0,0,8,0},
                                     {2,0,0,0,0,0,4,0,0} };

    /**
     * main method is used to take in the 2d array and solve it.
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //newPuzzle(input);
        printPuzzle();
        System.out.println("Solving puzzle...");
        if (solve()) {
            System.out.println("Solved!");
        } else {
            System.out.println("Unsolvable :(");
        }
        printPuzzle();
    }
    
    /**
     * This method is used to take in input for the puzzle board
     * @param input
     */
    public static void newPuzzle(Scanner input) {
        for (int i = 0; i < GRID_SIZE; i ++) {
            for (int j = 0; j < GRID_SIZE; j ++) {
                System.out.print("Please enter the number in the " + (i + 1) + " row and " + (j + 1) + " column: (enter 0 for empty cell)");
                while (!input.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                    input.next();
                }
                puzzle[i][j] = input.nextInt();
            }
        }
    }

    /**
     * This method is used to print the puzzle board.
     */
    public static void printPuzzle() {
        for (int i = 0; i < GRID_SIZE; i ++) {
            for (int j = 0; j < GRID_SIZE; j ++) {
                System.out.print(puzzle[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * This method is used to solve the puzzle.
     */
    private static boolean solve() {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (puzzle[row][col] == 0) {
                    for (int num = 1; num <= GRID_SIZE; num++) {
                        if (isValid(row, col, num)) {
                            puzzle[row][col] = num;
                            if (solve()) {
                                return true;
                            } else {
                                puzzle[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * This method is used to check the row of the current cell.
     */
    private static boolean checkRow(int row, int number) {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (puzzle[row][i] == number) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method is used to check the column of the current cell.
     */
    private static boolean checkColumn(int col, int number) {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (puzzle[i][col] == number) {
                return false;
            }
        }
        return true;

    }

    /**
     * This method is used to check the 3x3 box of the current cell.
     */
    private static boolean checkBox(int row, int col, int number) {
        int boxRow = row - row % 3;
        int boxCol = col - col % 3;
        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (puzzle[i][j] == number) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * This method is used to consolidate the each check method
     */
    private static boolean isValid(int row, int col, int number) {
        return(checkRow(row, number) && checkColumn(col, number) && checkBox(row, col, number));
    }

}