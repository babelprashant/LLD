package TicTacToe.board;

import TicTacToe.move.Move;
import TicTacToe.move.TicTacToeMove;
import TicTacToe.user.TicTacToePlayer;

import java.util.Arrays;

public class TicTacToeBoard extends Board{

    private char[][] grid;
    public static final char defaultChar = '_';
    int n;
    boolean isComplete;

    public TicTacToeBoard(int n){
        grid = new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(grid[i], defaultChar);
        }
        this.n = n;
    }

    public char[][] getGrid(){
        return this.grid;
    }

    public char getGrid(int i, int j){
        return this.getGrid()[i][j];
    }

    @Override
    public boolean move(Move move){
        TicTacToeMove ticTacToeMove = (TicTacToeMove) move;
        char key = ticTacToeMove.getTicTacToePlayer().getKey();
        int i = ticTacToeMove.getI();
        int j = ticTacToeMove.getJ();
        if(key != 'X' && key != 'O') {
            System.out.println("Invalid input. Please enter either 'X' or 'O'");
            return false;
        }
        if(i >= n || i<0 || j>=n || j<0){
            System.out.println("Invalid input. Select valid coordinates");
            return false;
        }
        if(getGrid()[i][j] != defaultChar){
            System.out.println("Invalid input. Place already taken");
            return false;
        }


        getGrid()[i][j] = key;
        System.out.println(this);
        isThereAWinner(ticTacToeMove.getTicTacToePlayer());
        if(areAllSlotsFilled()){
            System.out.println("Game Over :( ");
        };
        return true;
    }

    private boolean areAllSlotsFilled(){
        boolean allSlotsFilled = allSlotsFilled();
        isComplete = isComplete || allSlotsFilled;
        return allSlotsFilled;
    }

    private void isThereAWinner(TicTacToePlayer p){
        isComplete = checkRowComplete() ||
                checkColComplete() ||
                checkDiagonalCompleteLeft() ||
                checkDiagonalCompleteRight();
        if(isComplete){
            this.setComplete(true);
            System.out.println(p.getName()+ " wins the game!!");
        }

    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    private boolean allSlotsFilled(){
        for(int i = 0; i<n;i++){
            for(int j=0;j<n;j++){
                if(getGrid(i, j) == defaultChar)
                    return false;
            }
        }
        System.out.println("All slots filled!! Game is a draw");
        return true;
    }

    private boolean checkRowComplete(){
        char[][] gridChar = getGrid();
        for(int i =0 ;i<n;i++){
            char startChar = gridChar[i][0];
            if(startChar == defaultChar){
                continue;
            }
            boolean complete = true;
            for(int j=1;j<n;j++){
                if(gridChar[i][j] != startChar){
                    complete = false;
                    break;
                }
            }
            if(complete){
                return true;
            }
        }
        return false;
    }

    private boolean checkColComplete(){
        char[][] gridChar = getGrid();
        for(int i =0 ;i<n;i++){
            char startChar = gridChar[0][i];
            if(startChar == defaultChar){
                continue;
            }
            boolean complete = true;
            for(int j=1;j<n;j++){
                if(gridChar[j][i] != startChar){
                    complete = false;
                    break;
                }
            }
            if(complete){
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonalCompleteRight(){
        int i = 1;
        boolean isComplete = true;
        char[][] gridChar = getGrid();
        char startChar = gridChar[0][0];
        if(startChar == defaultChar){
            return false;
        }
        while(i < n){
            if(gridChar[i][i] != startChar){
                isComplete = false;
                break;
            }
            i++;
        }
        return isComplete;
    }

    private boolean checkDiagonalCompleteLeft(){
        int i = 1;
        boolean isComplete = true;
        char[][] gridChar = getGrid();
        char startChar = gridChar[0][n-1];
        if(startChar == defaultChar){
            return false;
        }
        while(i < n){
            if(gridChar[i][n-1-i] != startChar){
                isComplete = false;
                break;
            }
            i++;
        }
        return isComplete;
    }

    public boolean isComplete() {
        return isComplete;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                sb.append(grid[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
