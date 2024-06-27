package TicTacToe;

import java.util.LinkedList;
import java.util.Queue;

public class Game {

    boolean isComplete;
    Queue<Player> players;
    Grid grid;
    int n;

    public void registerPlayer(String name, char key){
        this.players.offer(new Player(name, key));
    }

    public Game(Grid grid){
        this.grid = grid;
        this.players = new LinkedList<>();
        this.isComplete = false;
        this.n = grid.grid.length;
    }

    public boolean insert(int i, int j, Player p){
        char key = p.key;
        if(key != 'X' && key != 'O') {
            System.out.println("Invalid input. Please enter either 'X' or 'O'");
            return false;
        }
        if(i >= n || i<0 || j>=n || j<0){
            System.out.println("Invalid input. Select valid coordinates");
            return false;
        }
        if(grid.grid[i][j] != grid.defaultChar){
            System.out.println("Invalid input. Place already taken");
            return false;
        }


        grid.grid[i][j] = key;
        System.out.println(grid);
        isComplete(p);
        return true;
    }

    public void isComplete(Player p){
        isComplete = checkRowComplete() ||
                checkColComplete() ||
                checkDiagonalCompleteLeft() ||
                checkDiagonalCompleteRight() ||
                allSlotsFilled();
        if(isComplete){
            System.out.println(p.name+ " wins the game !!" );
        }

    }

    private boolean allSlotsFilled(){
        for(int i = 0; i<n;i++){
            for(int j=0;j<n;j++){
                if(grid.grid[i][j] == grid.defaultChar)
                    return false;
            }
        }
        System.out.println("All slots filled!! Game is a draw");
        return true;
    }

    private boolean checkRowComplete(){
        char[][] gridChar = this.grid.grid;
        for(int i =0 ;i<n;i++){
            char startChar = gridChar[i][0];
            if(startChar == grid.defaultChar){
                return false;
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
        char[][] gridChar = this.grid.grid;
        for(int i =0 ;i<n;i++){
            char startChar = gridChar[0][i];
            if(startChar == grid.defaultChar){
                return false;
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
        char[][] gridChar = this.grid.grid;
        char startChar = gridChar[0][0];
        if(startChar == grid.defaultChar){
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
        char[][] gridChar = this.grid.grid;
        char startChar = gridChar[0][n-1];
        if(startChar == grid.defaultChar){
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


}
