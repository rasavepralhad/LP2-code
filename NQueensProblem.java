import java.util.Arrays; 
 
public class NQueensProblem { 
    private int[] solution; 
    private int boardSize; 
    private boolean[] attackedColumns; 
    private boolean[] attackedDiagonals1; 
    private boolean[] attackedDiagonals2; 
    private int solutionsCount; 
 
    public NQueensProblem(int n) { 
        boardSize = n; 
        solution = new int[boardSize]; 
        attackedColumns = new boolean[boardSize]; 
        attackedDiagonals1 = new boolean[2 * boardSize - 1]; 
        attackedDiagonals2 = new boolean[2 * boardSize - 1]; 
        solutionsCount = 0; 
    } 
 
    public void solve() { 
        placeQueen(0); 
        System.out.println("Total solutions: " + solutionsCount); 
    } 
 
    private void placeQueen(int row) { 
        if (row == boardSize) { 
            solutionsCount++; 
            System.out.println("Solution " + solutionsCount + ": " + Arrays.toString(solution)); 
            return; 
        } 
 
        for (int col = 0; col < boardSize; col++) { 
            if (!isAttacked(row, col)) { 
                placeQueenAt(row, col); 
                placeQueen(row + 1); 
                removeQueenAt(row, col); 
            } 
        } 
    } 
 
    private boolean isAttacked(int row, int col) { 
        return attackedColumns[col] || attackedDiagonals1[row + col] || attackedDiagonals2[row - col + 
boardSize - 1]; 
    } 
 
    private void placeQueenAt(int row, int col) { 
        solution[row] = col; 
        attackedColumns[col] = true; 
        attackedDiagonals1[row + col] = true; 
        attackedDiagonals2[row - col + boardSize - 1] = true; 
    } 
 
    private void removeQueenAt(int row, int col) { 
        attackedColumns[col] = false; 
        attackedDiagonals1[row + col] = false; 
        attackedDiagonals2[row - col + boardSize - 1] = false; 
    } 
 
public static void main(String[] args) { 
int n = 8; // Change this to the desired board size 
NQueensProblem nQueens = new NQueensProblem(n); 
nQueens.solve(); 
} 
} 