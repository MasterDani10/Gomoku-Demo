package GomokuGame.game;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
public class GameUI{

    private final Gomoku game;
    private final Scanner input;
    private final PrintStream output;

    public GameUI(Gomoku game, InputStream inputStream, PrintStream outputStream){
        this.game = game;
        this.input = new Scanner(inputStream);
        this.output = outputStream;
    }
    public void welcomeUser(){
        output.print("Welcome to Gomoku / Omok");
    }
    public int promptForGameMode(){
        boolean repeat = true;
        int choice;
        output.println("Select a game mode: ");
        output.println("(1) Human");
        output.println("(2) Strategy");
        choice = input.nextInt();
        output.println();

        if(choice == 1 || choice == 2){
            repeat = false;
        }

        while(repeat) {
            output.println("Sorry, please enter 1 or 2 to Select a game mode: ");
            output.println("(1) Human");
            output.println("(2) Strategy");
            choice = input.nextInt();
            output.println();
            if(choice == 1 || choice == 2){
                repeat = false;
            }


        }

        switch(choice){
            case 1:
//                return GameType.Human();
                return 1;
            case 2:
//                return GameType.Strategy();
                return 2;
            default:
                output.println("Invalid choice, going to Human mode");
//                return GameType.Human();
                return -1;
        }
    }

    public void placeStone(int x, int y, int movePlayer1) {

        game.getBoard().createBoard();
    }

}
