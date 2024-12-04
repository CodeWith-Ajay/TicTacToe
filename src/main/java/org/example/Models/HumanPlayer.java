package org.example.Models;

import java.util.Scanner;

public class HumanPlayer extends Player{
    public HumanPlayer(char symbol, String name) {
        super(symbol, name);
    }

    @Override
    Pair<Integer,Integer> makeMove(Board board) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Its "+ getName()+"'s turn");
        System.out.println("Enter x: ");
        int x = sc.nextInt();


        System.out.println("Enter y: ");
        int y = sc.nextInt();
        return new Pair<>(x,y);
    }
    void undo(){

    }
}
