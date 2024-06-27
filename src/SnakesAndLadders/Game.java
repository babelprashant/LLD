package SnakesAndLadders;

import java.util.*;

public class Game {

    Queue<Player> players;
    Map<Player, Integer> playerPosition;
    Board board;
    Dice dice;
    Boolean isGameOver;

    public Game(){
        this.dice = new Dice();
        this.playerPosition = new HashMap<>();
        this.board = new Board();
        this.players = new LinkedList<>();
        this.isGameOver = false;
    }

    public void addLadder(int head, int tail){
        this.board.addLadder(head, tail);
    }

    public void addSnake(int head, int tail){
        this.board.addSnake(head, tail);
    }

    public void registerPlayer(String name){
        Player player = new Player(name);
        this.players.offer(player);
        this.playerPosition.put(player, 0);
    }

    public void rollDice(Player p){
        int diceNum = this.dice.roll();
        int oldPos = playerPosition.get(p);
        int newPos = oldPos + diceNum;
        if(newPos > 100){
            System.out.println("Invalid roll since it is above 100");
            return;
        }
        if(newPos == 100) {
            System.out.println(p.name + " wins the game!!   :) ");
            this.isGameOver = true;
            return;
        }
        int adjustedPos = this.board.getAdjustedPosition(newPos);
        playerPosition.put(p, adjustedPos);
        System.out.println(p.name + " moved from "+ oldPos + " to " + adjustedPos);
    }

    public boolean isGameOver(){
        return this.isGameOver;
    }
}
