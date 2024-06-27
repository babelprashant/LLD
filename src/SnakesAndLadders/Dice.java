package SnakesAndLadders;

import java.util.Random;

public class Dice {

    int maxNum;
    int minNum;
    Random rand;

    public Dice(){
        this.maxNum = 6;
        this.minNum = 1;
        rand = new Random();
    }

    public int roll(){
        int diceNum = this.rand.nextInt(this.maxNum) + 1;
        System.out.println("Dice number is : "+ diceNum);
        return diceNum;
    }
}
