package org.example;

import org.example.Controller.GameController;
import org.example.Exception.InvalidBotCountException;
import org.example.Models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) throws InvalidBotCountException {
        GameController gameController = new GameController();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number human of players: " );
        int numPlayers = scanner.nextInt();
        List<Player>playerList = new ArrayList<>();
        for (int i = 0; i < numPlayers; i++) {
            //need to use 2 hashset to check that name and symbol is unique
            System.out.println("Enter the name of player: ");
            String name = scanner.next();
            System.out.println("Enter the Symbol: ");
            char symbol = scanner.next().charAt(0);
            Player HumanPlayer=new HumanPlayer(symbol,name);
            playerList.add(HumanPlayer);

        }
        System.out.println("Are bots going to play? (Y/N)");
        if(scanner.next().charAt(0) == 'Y'){
            System.out.println("Enter BotLevel: (E/M/H)");
            char level = scanner.next().charAt(0);
            BotLevel botLevel=BotLevel.EASY;
            if(level == 'E'){
                botLevel = BotLevel.EASY;

            }
            else if(level == 'M'){
                botLevel=BotLevel.MEDIUM;

            }
            else if(level == 'H'){
                botLevel=BotLevel.HARD;
            }
            playerList.add(new BotPlayer('B',"Bot-1", botLevel));
        }
    Game game=gameController.createGame(playerList);
        while (gameController.getGameStatus(game)==GameStatus.IN_PROGRESS){
                gameController.printBoard(game);
                gameController.makeMove(game);
        }
        if(gameController.getGameStatus(game)==GameStatus.WON){
            Player winner = gameController.getWinner(game);
            System.out.println(winner.getName()+" with symbol "+winner.getSymbol()+" has won");
            gameController.printBoard(game);

        }
        else{
            System.out.println("Game has drawn");
            gameController.printBoard(game);
        }
    }
}


