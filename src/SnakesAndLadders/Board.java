package SnakesAndLadders;


import java.util.HashMap;
import java.util.Map;

public class Board {

    Map<Integer, Integer> snakeMap;
    Map<Integer, Integer> ladderMap;

    public Board(){
        snakeMap = new HashMap<>();
        ladderMap = new HashMap<>();
    }

    public int getAdjustedPosition(int pos){
        if(snakeMap.get(pos) != null){
            System.out.println("Snake hit");
            return snakeMap.get(pos);
        }else if(ladderMap.get(pos) != null){
            System.out.println("Got a ladder!!");
            return ladderMap.get(pos);
        }
        return pos;

    }

    public void addSnake(int head, int tail){
        //add validation
        snakeMap.put(head, tail);
    }

    public void addLadder(int head, int tail){
        //add validation
        ladderMap.put(head, tail);
    }

}
