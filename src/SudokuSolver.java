import java.util.*;

 /** 
 * This program takes in a 2d array for the sudoku puzzle and solves it.
 * @author William Morgan
 * @version 1.0
 */

public class SudokuSolver {
    /**
     * This variable is used to store the 2d array of the sudoku puzzle.
     */
    public static int[][] puzzle = new int[9][9];

    /**
     * main method is used to take in the 2d array and solve it.
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        newPuzzle(input);
        
    }
    
    /**
     * This method is used to take in input for the puzzle board
     * @param input
     */
    public static void newPuzzle(Scanner input) {
        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
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
        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                System.out.print(puzzle[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * This method is used to solve the puzzle.
     */
    public static void solve() {
        int row = 0;
        int col = 0;
        int num = 0;
        int count = 0;
        while (count < 81) {
            if (puzzle[row][col] == 0) {
                for (int i = 1; i <= 9; i ++) {
                    if (checkRow(row, i) && checkCol(col, i) && checkBox(row, col, i)) {
                        puzzle[row][col] = i;
                        count ++;
                        if (count == 81) {
                            break;
                        }
                    }
                }
                if (puzzle[row][col] == 0) {
                    puzzle[row][col] = 0;
                    count --;
                }
            }
            col ++;
            if (col == 9) {
                col = 0;
                row ++;
            }
        }
    }

    /**
     * This method is used to check the row of the current cell.
     */
    public static void checkRow(int row, int cell) {

    }

    /**
     * This method is used to check the column of the current cell.
     */
    public static void checkColumn(int col, int cell) {

    }

    /**
     * This method is used to check the 3x3 box of the current cell.
     */
    public static void checkBox(int row, int col, int cell) {

    }

}