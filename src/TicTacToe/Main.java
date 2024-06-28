package TicTacToe;

import TicTacToe.api.GameEngine;
import TicTacToe.api.TicTacToeGameEngine;
import TicTacToe.board.TicTacToeBoard;
import TicTacToe.move.TicTacToeMove;
import TicTacToe.user.TicTacToePlayer;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicTacToeBoard ticTacToeBoard = new TicTacToeBoard(3);
        GameEngine gameEngine = new TicTacToeGameEngine(ticTacToeBoard);

        System.out.println("Enter player 1 name");
        String name1 = sc.nextLine();
        gameEngine.registerPlayer(new TicTacToePlayer(name1, 'X'));
        System.out.println("Enter player 2 name");
        String name2 = sc.nextLine();
        gameEngine.registerPlayer(new TicTacToePlayer(name2, 'O'));
        System.out.println(ticTacToeBoard);
        while(!gameEngine.isComplete()){
            TicTacToePlayer p = (TicTacToePlayer) gameEngine.getPlayers().poll();
            gameEngine.getPlayers().offer(p);
            System.out.println("Insert coordinates for key " +p.getKey() + " for "+ p.getName() );
            String[] str = sc.nextLine().split(" ");
            int i = Integer.parseInt(str[0]);
            int j = Integer.parseInt(str[1]);
            boolean isValidMove = gameEngine.move(new TicTacToeMove(i, j, p));
            while(!isValidMove){
                str = sc.nextLine().split(" ");
                i = Integer.parseInt(str[0]);
                j = Integer.parseInt(str[1]);
                isValidMove = gameEngine.move(new TicTacToeMove(i, j, p));
            }

        }
    }
}
