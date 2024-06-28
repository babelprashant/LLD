package TicTacToe.api;

import TicTacToe.board.Board;
import TicTacToe.move.Move;
import TicTacToe.move.TicTacToeMove;
import TicTacToe.user.Player;

import java.util.Queue;

public interface GameEngine {

    boolean isComplete();
    void registerPlayer(Player p);
    Queue<Player> getPlayers();
    boolean move(Move move);
}
