package GomokuGame;
import java.util.Scanner;
public class GameUI{

    private final Gomoku game;
    private final Scanner input;

    public GameUI(Gomoku game){
        this.game = game;
        this.input = new Scanner(System.in);
    }
    public void welcomeUser(){
        System.out.println("Welcome to Gomoku / Omok");
    }
    public int promptForGameMode(){
        boolean repeat = true;
        int choice;
        System.out.println("Select a game mode: ");
        System.out.println("(1) Human");
        System.out.println("(2) Strategy");
        choice = input.nextInt();
        System.out.println();

        if(choice == 1 || choice == 2){
            repeat = false;
        }

        while(repeat) {
            System.out.println("Sorry, please enter 1 or 2 to Select a game mode: ");
            System.out.println("(1) Human");
            System.out.println("(2) Strategy");
            choice = input.nextInt();
            System.out.println();
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
                System.out.println("Invalid choice, going to Human mode");
//                return GameType.Human();
                return -1;
        }
    }

    public void placeStone(int x, int y, int movePlayer1) {
        game.getBoard().createBoard();
    }

}
