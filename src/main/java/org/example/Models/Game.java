package org.example.Models;

import org.example.Exception.InvalidBotCountException;
import org.example.WinningStrategies.OrderOneWinningStrategy;
import org.example.WinningStrategies.PlayerWonStrategy;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private int currentPlayerIdx;
    private GameStatus gameStatus;
    private  List<Move>moves;
    private PlayerWonStrategy playerWonStrategy;

    private Game(GameBuilder gameBuilder){
        this.players=gameBuilder.players;
        int n=players.size();
        this.board=new Board(n+1);
        this.currentPlayerIdx=0;
        this.gameStatus=GameStatus.IN_PROGRESS;
        this.moves=new ArrayList<>();
        this.playerWonStrategy=new OrderOneWinningStrategy(n+1);
    }
    public static GameBuilder getGameBuilder(){
        return new Game.GameBuilder();
    }
    public void printBoard(){
        this.board.printBoard();
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getCurrentPlayerIdx() {
        return currentPlayerIdx;
    }

    public void setCurrentPlayerIdx(int currentPlayerIdx) {
        this.currentPlayerIdx = currentPlayerIdx;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public void makeMove() {
        Player player=players.get(currentPlayerIdx);
        Pair<Integer,Integer>pair=player.makeMove(this.board);
        this.board.setPlayer(pair.getKey(),pair.getValue(),player);
        Move move=new Move(player,this.board.getCell(pair.getKey(),pair.getValue()));
        this.moves.add(move);
        if(playerWonStrategy.checkIfWon(this.board.getCell(pair.getKey(),pair.getValue()))){
            this.gameStatus=GameStatus.WON;
            return;
        }
        if(moves.size()==(players.size()+1)*(players.size()+1)){
            this.gameStatus=GameStatus.DRAW;
            return;

        }
        this.currentPlayerIdx= (this.currentPlayerIdx+1) % this.players.size();
    }

    private boolean ifWon() {
        return true;
    }

    public Player getWinner() {
        return this.players.get(currentPlayerIdx);
    }

    public static class GameBuilder{

       private List<Player> players;

       public GameBuilder setPlayers(List<Player> players) {
           this.players = players;
           return this;
       }
       public Game build() throws InvalidBotCountException {
           int botCount = 0;
           for (Player player : players) {
               if(player instanceof BotPlayer){
                   botCount++;
               }
               if(botCount>1){
                   throw new InvalidBotCountException("only one Bot is allowed");
               }
           }return new Game(this);

       }
    }

}
