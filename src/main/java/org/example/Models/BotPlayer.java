package org.example.Models;

public class BotPlayer extends Player {
    private BotLevel botlevel;

    public BotPlayer(char symbol, String name, BotLevel botlevel) {
        super(symbol, name);
        this.botlevel = botlevel;
    }

    @Override
    Pair<Integer,Integer> makeMove(Board board) {
    return null;
    }
}
