package TicTacToe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Grid grid = new Grid(3);
        Game game = new Game(grid);

        System.out.println("Enter player 1 name");
        String name1 = sc.nextLine();
        game.registerPlayer(name1, 'X');
        System.out.println("Enter player 2 name");
        String name2 = sc.nextLine();
        game.registerPlayer(name2, 'O');
        System.out.println(grid);
        while(!game.isComplete){
            Player p = game.players.poll();
            game.players.offer(p);
            System.out.println("Insert coordinates for key " +p.key + " for "+ p.name );
            String[] str = sc.nextLine().split(" ");
            int i = Integer.parseInt(str[0]);
            int j = Integer.parseInt(str[1]);
            boolean isValidMove = game.insert(i , j, p);
            while(!isValidMove){
                str = sc.nextLine().split(" ");
                i = Integer.parseInt(str[0]);
                j = Integer.parseInt(str[1]);
                isValidMove = game.insert(i , j, p);
            }

        }


    }
}
