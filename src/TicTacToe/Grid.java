package TicTacToe;

import java.util.Arrays;

public class Grid {

    char[][] grid;
    public static final char defaultChar = '_';

    public Grid(int n){
        grid = new char[n][n];
        for(int i=0;i<n;i++){

            Arrays.fill(grid[i], defaultChar);
        }
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
