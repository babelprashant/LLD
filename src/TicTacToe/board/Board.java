package TicTacToe.board;

import TicTacToe.move.Move;

public abstract class Board {

    public abstract boolean move(Move move);
    public abstract boolean isComplete();
}
