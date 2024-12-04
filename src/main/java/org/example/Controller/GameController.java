package org.example.Controller;

import org.example.Exception.InvalidBotCountException;
import org.example.Models.Game;
import org.example.Models.GameStatus;
import org.example.Models.Player;

import java.util.List;

public class GameController {
        public Game createGame(List<Player> players) throws InvalidBotCountException {
           Game game= Game.getGameBuilder()
                    .setPlayers(players)
                    .build();
           return game;
        }
        public GameStatus getGameStatus(Game game){
            return game.getGameStatus();
        }
        public void printBoard(Game game){
            game.printBoard();
        }
        public void makeMove(Game game){
            game.makeMove();
        }
        public Player getWinner(Game game){
            return game.getWinner();
        }
}
