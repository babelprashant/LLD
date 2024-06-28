package TicTacToe.user;

public class TicTacToePlayer implements Player {
    private String name;
    private char key;
    public TicTacToePlayer(String name, char key){
        this.name = name;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getKey() {
        return key;
    }

    public void setKey(char key) {
        this.key = key;
    }
}
