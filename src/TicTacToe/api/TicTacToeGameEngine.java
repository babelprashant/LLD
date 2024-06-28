package TicTacToe.api;

import TicTacToe.board.TicTacToeBoard;
import TicTacToe.move.Move;
import TicTacToe.move.TicTacToeMove;
import TicTacToe.user.Player;


import java.util.LinkedList;
import java.util.Queue;

public class TicTacToeGameEngine implements GameEngine {

    private Queue<Player> players;
    private TicTacToeBoard ticTacToeBoard;
    private int n;

    @Override
    public boolean isComplete() {
        return ticTacToeBoard.isComplete();
    }

    @Override
    public void registerPlayer(Player p){
        this.players.offer(p);
    }

    public TicTacToeGameEngine(TicTacToeBoard ticTacToeBoard){
        this.ticTacToeBoard = ticTacToeBoard;
        this.players = new LinkedList<>();
        this.n = ticTacToeBoard.getGrid().length;
    }


    public Queue<Player> getPlayers() {
        return players;
    }

    @Override
    public boolean move(Move move) {
        return ticTacToeBoard.move((TicTacToeMove) move);
    }

    public void setPlayers(Queue<Player> players) {
        this.players = players;
    }


    public void setTicTacToeBoard(TicTacToeBoard ticTacToeBoard) {
        this.ticTacToeBoard = ticTacToeBoard;
    }

}
