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

    }
    
    /* Displays the stockpile on the screen
     * @param stockpile - The array that contains Card objects representing the stockpile */
    public void DisplayStockpile(Card[] stockpile) {
      
    }
    
    /* Displays the store on the screen
     * @param store - The array that contains Card objects representing the store */
    public void DisplayWa(Card[][] waste) {
      
    }
  }
