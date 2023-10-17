package GomokuGame.game;

public class Gomoku {

   private Player player1;
   private Player player2;
   private GameType gameType;
   public Board board = new Board(15);
   int[][] b1 = board.getBoardInfo();
   private GameUI gameUI;

   private ComputerOpponent com;

   public Gomoku(){
       this.player1 = new Player("Player 1");
       this.player2 = new Player("Player 2");
       this.gameUI = new GameUI(this, System.in, System.out);
       this.com = new ComputerOpponent();
   }


    public void startGame(){
       gameUI.welcomeUser();


       //gameType = (GameType) gameUI.promptForGameMode();
        int choice = gameUI.promptForGameMode();
       if(choice == 1) {


           board.createBoard();

           while (true) {
               int[] movePlayer1 = player1.move();
               if(movePlayer1 == null){
                   System.out.println("Thank You For Playing!");
                   return;
               }
               boolean repeat = false;
               repeat = board.move(movePlayer1[0], movePlayer1[1], 1);
               while(repeat == true){
                   movePlayer1 = player1.move();
                   repeat = board.move(movePlayer1[0], movePlayer1[1], 1);

               }
               gameUI.placeStone(movePlayer1[0], movePlayer1[1], 1);
               if (findWinner()) {
                   System.out.println("Player 1 wins!");
                   System.out.println("Thank You For Playing!");
                   return;
               }
               if (endGame()) {
                   System.out.println("Its a draw!");
                   System.out.println("Thank You For Playing!");
                   return;
               }
               int[] movePlayer2 = player2.move();
               if(movePlayer2 == null){
                   System.out.println("Thank You For Playing!");
                   return;
               }
               boolean repeat2 = false;
               repeat2 = board.move(movePlayer2[0], movePlayer2[1], 2);
               while(repeat2 == true){
                   movePlayer2 = player2.move();
                   repeat2 = board.move(movePlayer2[0], movePlayer2[1], 2);

               }
               gameUI.placeStone(movePlayer2[0], movePlayer2[1], 2);

               if (findWinner()) {
                   System.out.println("Player 2 wins!");
                   System.out.println("Thank You For Playing!");
                   return;
               }
               if (endGame()) {
                   System.out.println("Its a draw!");
                   System.out.println("Thank You For Playing!");
                   return;

               }
           }
       }
       else{
           board.createBoard();
           boolean repeat = true;
           while (repeat) {
               int[] movePlayer1 = player1.move();
               if(movePlayer1 == null){
                   System.out.println("Thank You For Playing!");
                   break;
               }


               repeat = playerTurn(movePlayer1);
               if(repeat == false){break;}
               repeat = computerTurn(1, movePlayer1);
               if(repeat == false){break;}
               movePlayer1 = player1.move();
               if(movePlayer1 == null){
                   System.out.println("Thank You For Playing!");
                   break;
               }
               repeat = playerTurn(movePlayer1);
               if(repeat == false){break;}
               repeat = computerTurn(2, movePlayer1);
               if(repeat == false){break;}
               movePlayer1 = player1.move();
               if(movePlayer1 == null){
                   System.out.println("Thank You For Playing!");
                   break;
               }
               repeat = playerTurn(movePlayer1);
               if(repeat == false){break;}
               repeat = computerTurn(3, movePlayer1);
               if(repeat == false){break;}
               movePlayer1 = player1.move();
               if(movePlayer1 == null){
                   System.out.println("Thank You For Playing!");
                   break;
               }
               repeat = playerTurn(movePlayer1);
               if(repeat == false){break;}
               repeat = computerTurn(4, movePlayer1);
               if(repeat == false){break;}
               if(movePlayer1 == null){
                   System.out.println("Thank You For Playing!");
                   break;
               }

           }
       }
   }
   public boolean playerTurn(int[] movePlayer1){

       board.move(movePlayer1[0], movePlayer1[1], 1);
       gameUI.placeStone(movePlayer1[0], movePlayer1[1], 1);
       if (findWinner()) {
           System.out.println("Player 1 wins!");
           return false;
       }
       if (endGame()) {
           System.out.println("Its a draw!");
           return false;
       }
       return true;
   }

   public boolean computerTurn(int x, int[] movePlayer1){
       int[] moveComputer = {0};
       if(x == 1){
           moveComputer = com.nextMove(movePlayer1);
       }
       if(x == 2){
           moveComputer = com.nextMove2(movePlayer1);
       }
       if(x == 3){
           moveComputer = com.nextMove3(movePlayer1);
       }
       if(x == 4){
           moveComputer = com.nextMove4(movePlayer1);
       }
       board.move(moveComputer[0], moveComputer[1], 2);
       gameUI.placeStone(moveComputer[0], moveComputer[1], 2);

       if (findWinner()) {
           System.out.println("Player 2 wins!");
           return false;
       }
       if (endGame()) {
           System.out.println("Its a draw!");
           return false;

       }
       return true;
   }


    public boolean findWinner() {
        for (int i = 0; i < b1.length; i++) {
            for (int j = 0; j < b1[i].length; j++) {
                if (b1[i][j] != 0 &&
                        (checkDirection(b1, i, j, 1, 0) ||
                                checkDirection(b1, i, j, 0, 1) ||
                                checkDirection(b1, i, j, 1, 1) ||
                                checkDirection(b1, i, j, 1, -1))) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean checkDirection(int[][] board, int x, int y, int dx, int dy) {
        int n = board.length;
        int player = board[x][y];

        for (int i = 0; i < 5; i++){
            int newX = x + dx * i;
            int newY = y + dy * i;
            if (newX < 0 || newX >= n || newY < 0 || newY >= n || board[newX][newY] != player) {
                return false;
            }
        }
        return true;
    }
   public boolean endGame(){
       for (int i = 0; i < board.board.length ; i++) {
           for (int j = 0; j < board.board[i].length; j++) {
               if(board.board[i][j] == 0){
                   return false;
               }
           }
       }
       return true;
   }
   public Board getBoard(){
       return this.board;
   }

}
