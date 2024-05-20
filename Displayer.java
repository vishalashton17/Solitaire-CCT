// Developed by Vishal

public class Displayer {
    //======================= CONSTRUCTOR =======================//
    public Displayer() {

    }
    
    //====================== PUBLIC METHOD =======================//
    /* Displays the game title screen */
    public void GameHeader() {
        System.out.println("===============================");
        System.out.println("|    WELCOME TO SOLITAIRE!    |");
        System.out.println("===============================");
    }
    
    /* Display the player's score on the screen 
     * @param o - Object that represents player o  
     * @param x - Object that represents player x */
    public void ScoreBoard(Player one, Player two) {
        System.out.println("CURRENT SCORE");
        System.out.println();
        System.out.println("Player One: " + one.GetScore() + " points");
        System.out.println("Player Two: " + two.GetScore() + " points");
    }
    
    /* Display the current round number
     * @param roundNum - The current round's number */
    public void ShowRound(int roundNum) {
        System.out.println("= ROUND " + roundNum + " **********");
    }
    
    /* Displays the game board on the screen
     * @param board - The 2D array that contains Card objects representing the board */
    public void DisplayBoard(Card[][] board) {
        System.out.print("BOARD");
        System.out.print("==============================================");
        for(int i = 0; i<13 ; i++){
            System.out.println(i);
            for (int k = 0; k<7; k++){
                if (board[i][k] == null){
                    System.out.print(k +" EMPTY " +i);
                }
                else {
                System.out.println(board[i][k].GetNumber());
                System.out.println(board[i][k].GetColor());
                System.out.println(board[i][k].GetPattern());
                System.out.print("------------------------------------------------");
                }
            }
        }
    }
    
    /* Displays the stockpile on the screen
     * @param stockpile - The array that contains Card objects representing the stockpile */
    public void DisplayStockpile(Card[] stockpile, int currCardPos) {
      System.out.print("STOCKPILE");
      System.out.println(stockpile[currCardPos].GetNumber());
      System.out.println(stockpile[currCardPos].GetColor());
      System.out.println(stockpile[currCardPos].GetPattern());

    }
    
    /* Displays the store on the screen
     * @param store - The array that contains Card objects representing the store */
    public void DisplayWaste(Card[][] waste) {
        System.out.print("WASTE");
        System.out.print("==============================================");
        for(int i = 0; i<13 ; i++){
            System.out.println("");
            for (int k = 0; k<4; k++){
                if (waste[i][k] == null){
                    System.out.print(k +" EMPTY " +i);
                }
                else{
                System.out.println(waste[i][k].GetNumber());    
                System.out.println(waste[i][k].GetColor());
                System.out.println(waste[i][k].GetPattern());
                }
            }
        }
    }
  }
