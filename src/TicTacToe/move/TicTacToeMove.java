package TicTacToe.move;

import TicTacToe.user.TicTacToePlayer;

public class TicTacToeMove implements Move{

    int i;
    int j;

    TicTacToePlayer ticTacToePlayer;

    public TicTacToeMove(int i, int j, TicTacToePlayer p) {

        this.j = j;
        this.i = i;
        this.ticTacToePlayer = p;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public TicTacToePlayer getTicTacToePlayer() {
        return ticTacToePlayer;
    }

    public void setTicTacToePlayer(TicTacToePlayer ticTacToePlayer) {
        this.ticTacToePlayer = ticTacToePlayer;
    }
}
