package GomokuGame.game;
import java.util.Scanner;

public class Player{

    private String name;
    private static Scanner input = new Scanner(System.in);

    public Player(String name){
        this.name = name;
    }
    public void play(){
        System.out.println(name + " is now playing.");
    }

    public int[] move(){
        boolean repeat = false;
        System.out.println(name + " Turn   (If you want to exit the game enter -1)");
        System.out.println("Enter row:");
        int row = input.nextInt();
        if(row == -1){
            return null;
        }

        System.out.println("Enter column:");
        int col = input.nextInt();
        if(col == -1){
            return null;
        }

        if(row > 15 || row < 1 || col > 15 || col < 1){
            repeat = true;
        }
        while(repeat){
            System.out.println("Sorry " + name + ", invalid coordinates please input a " +
                    "number greater than 0 and less than 16");
            System.out.println("Enter row:");
            row = input.nextInt();

            System.out.println("Enter column:");
            col = input.nextInt();
            if(row <= 15 && row >= 1 && col <= 15 && col >= 1){
                repeat = false;
            }
        }

        col -= 1;
        row -= 1;
        return new int[] {col, row};
    }

}
