package GomokuGame.game;
import java.util.Scanner;


public class Board{

    protected int[][] board;


    public Board(int size) {
        this.board = new int[size][size];
    }


    public void createBoard(){
        int n = board.length;
        for(int x = 1; x <= n; x++){
            if(x == 1){
                System.out.print("      " + x + " ");
            }
            else if(x == n){
                System.out.println(" " + x);
            }
            else if(x > 9){
                System.out.print(" " + x + " ");
            }
            else {
                System.out.print("  " + x + " ");
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                switch(board[j][i]){
                    case 0:
                        if(j == 0){
                            if(i > 8){
                                System.out.print(i+1 + "    .   ");
                            }
                            else {
                                System.out.print(i+1 + "     .   ");
                            }
                        }
                        else if(j == board[i].length){
                            System.out.println(".");
                        }
                        else{
                            System.out.print(".   ");
                        }

                        break;
                    case 1:
                        if(j == 0){
                            if(i > 8){
                                System.out.print(i+1 + "    O   ");
                            }
                            else {
                                System.out.print(i+1 + "     O   ");
                            }
                        }
                        else if(j == board[i].length){
                            System.out.println("O");
                        }
                        else{
                            System.out.print("O   ");
                        }
                        //System.out.print("X ");
                        break;
                    case 2:
                        if(j == 0){
                            if(i > 8){
                                System.out.print(i+1 + "    X   ");
                            }
                            else {
                                System.out.print(i+1 + "     X   ");
                            }
                        }
                        else if(j == board[i].length){
                            System.out.println("X");
                        }
                        else{
                            System.out.print("X   ");
                        }
                        //System.out.print("X");
                        break;
                    default:
                        System.out.print("? ");
                        break;
                }
            }
            System.out.println();
        }
        System.out.println();
    }


    public boolean move(int x, int y, int player){
        if(board[x][y] == 0){
            board[x][y] = player;
        }
        else{
            System.out.println();
            System.out.println("Position already occupied!!! Please try again.");
            return true;
        }
        return false;
    }


    public int[][] getBoardInfo(){
        return this.board;
    }
}
