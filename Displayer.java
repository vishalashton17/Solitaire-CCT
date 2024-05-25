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
        System.out.println("");
        System.out.println("BOARD");
        System.out.println("===================================================================================================");
        for(int i = 0; i<13 ; i++){
            // printing the number of the cards
            //1
            if ( board[i][0] != null && board[i][0].GetFacing() == 0){
                System.out.print("| Facing down ");
            }
            else if (board[i][0] != null){
                System.out.printf("| %10d  ", board[i][0].GetNumber());
            }
            else {
                System.out.print("|             ");
            }
            // 2
            if ( board[i][1] != null && board[i][1].GetFacing() == 0){
                System.out.print("| Facing down ");
            }
            else if (board[i][1] != null){
                System.out.printf("| %10d  ", board[i][1].GetNumber());
            }
            else {
                System.out.print("|             ");
            }
            //3
            if ( board[i][2] != null && board[i][2].GetFacing() == 0){
                System.out.print("| Facing down ");
            }
            else if (board[i][2] != null){
                System.out.printf("| %10d  ", board[i][2].GetNumber());
            }
            else {
                System.out.print("|             ");
            }
            // 4
            if ( board[i][3] != null && board[i][3].GetFacing() == 0){
                System.out.print("| Facing down ");
            }
            else if (board[i][3] != null){
                System.out.printf("| %10d  ", board[i][3].GetNumber());
            }
            else {
                System.out.print("|             ");
            }
            // 5
            if ( board[i][4] != null && board[i][4].GetFacing() == 0){
                System.out.print("| Facing down ");
            }
            else if (board[i][4] != null){
                System.out.printf("| %10d  ", board[i][4].GetNumber());
            }
            else {
                System.out.print("|             ");
            }
            // 6
            if ( board[i][5] != null && board[i][5].GetFacing() == 0){
                System.out.print("| Facing down ");
            }
            else if (board[i][5] != null){
                System.out.printf("| %10d  ", board[i][5].GetNumber());
            }
            else {
                System.out.print("|             ");
            }
            // 7
            if ( board[i][6] != null && board[i][6].GetFacing() == 0){
                System.out.print("| Facing down ");
                System.out.print("|" );
                System.out.println("");
            }
            else if (board[i][6] != null) {
                System.out.printf("| %10d  ", board[i][6].GetNumber());
                System.out.print("|" );
                System.out.println("");
            }
            else {
                System.out.print("|             |");
                System.out.println("");
            }



            // printing the color of the cards
            //1
            if ( board[i][0] != null && board[i][0].GetFacing() == 0){
                System.out.print("| Facing down ");
            }
            else if (board[i][0] != null){
                System.out.printf("| %10s  ", board[i][0].GetColor());
            }
            else {
                System.out.print("|             ");
            }

            //2

            if ( board[i][1] != null && board[i][1].GetFacing() == 0){
                System.out.print("| Facing down ");
            }
            else if (board[i][1] != null){
                System.out.printf("| %10s  ", board[i][1].GetColor());
            }
            else {
                System.out.print("|             ");
            }

            //3

            if ( board[i][2] != null && board[i][2].GetFacing() == 0){
                System.out.print("| Facing down ");
            }
            else if (board[i][2] != null){
                System.out.printf("| %10s  ", board[i][2].GetColor());
            }
            else {
                System.out.print("|             ");
            }

            //4

            if ( board[i][3] != null && board[i][3].GetFacing() == 0){
                System.out.print("| Facing down ");
            }
            else if (board[i][3] != null){
                System.out.printf("| %10s  ", board[i][3].GetColor());
            }
            else {
                System.out.print("|             ");
            }

            //5

            if ( board[i][4] != null && board[i][4].GetFacing() == 0){
                System.out.print("| Facing down ");
            }
            else if (board[i][4] != null){
                System.out.printf("| %10s  ", board[i][4].GetColor());
            }
            else {
                System.out.print("|             ");
            }

            //6

            if ( board[i][5] != null && board[i][5].GetFacing() == 0){
                System.out.print("| Facing down ");
            }
            else if (board[i][5] != null){
                System.out.printf("| %10s  ", board[i][5].GetColor());
            }
            else {
                System.out.print("|             ");
            }

            //7
            if ( board[i][6] != null && board[i][6].GetFacing() == 0){
                System.out.print("| Facing down ");
                System.out.print("|" );
                System.out.println("");
            }
            else if (board[i][6] != null) {
                System.out.printf("| %10s  ", board[i][6].GetColor());
                System.out.print("|" );
                System.out.println("");
            }
            else {
                System.out.print("|             |");
                System.out.println("");
            }

            // printing the pattern of the cards
            if ( board[i][0] != null && board[i][0].GetFacing() == 0){
                System.out.print("| Facing down ");
            }
            else if (board[i][0] != null){
                System.out.printf("| %10s  ", board[i][0].GetPattern());
            }
            else {
                System.out.print("|             ");
            }

            //2

            if ( board[i][1] != null && board[i][1].GetFacing() == 0){
                System.out.print("| Facing down ");
            }
            else if (board[i][1] != null){
                System.out.printf("| %10s  ", board[i][1].GetPattern());
            }
            else {
                System.out.print("|             ");
            }

            //3

            if ( board[i][2] != null && board[i][2].GetFacing() == 0){
                System.out.print("| Facing down ");
            }
            else if (board[i][2] != null){
                System.out.printf("| %10s  ", board[i][2].GetPattern());
            }
            else {
                System.out.print("|             ");
            }

            //4

            if ( board[i][3] != null && board[i][3].GetFacing() == 0){
                System.out.print("| Facing down ");
            }
            else if (board[i][3] != null){
                System.out.printf("| %10s  ", board[i][3].GetPattern());
            }
            else {
                System.out.print("|             ");
            }

            //5

            if ( board[i][4] != null && board[i][4].GetFacing() == 0){
                System.out.print("| Facing down ");
            }
            else if (board[i][4] != null){
                System.out.printf("| %10s  ", board[i][4].GetPattern());
            }
            else {
                System.out.print("|             ");
            }

            //6

            if ( board[i][5] != null && board[i][5].GetFacing() == 0){
                System.out.print("| Facing down ");
            }
            else if (board[i][5] != null){
                System.out.printf("| %10s  ", board[i][5].GetPattern());
            }
            else {
                System.out.print("|             ");
            }

            //7
            if ( board[i][6] != null && board[i][6].GetFacing() == 0){
                System.out.print("| Facing down ");
                System.out.print("|" );
                System.out.println("");
            }
            else if (board[i][6] != null) {
                System.out.printf("| %10s  ", board[i][6].GetPattern());
                System.out.print("|" );
                System.out.println("");
            }
            else {
                System.out.print("|             |");
                System.out.println("");
            }
            System.out.println("===================================================================================================");

                
        }
    }
    
    /* Displays the stockpile on the screen
     * @param stockpile - The array that contains Card objects representing the stockpile */
    public void DisplayStockpile(Card[] stockpile, int currCardPos) {
      System.out.println("STOCKPILE");
      System.out.println("==============");
      System.out.print("| ");
      System.out.printf("%10d", stockpile[currCardPos].GetNumber());
      System.out.print(" |");
      System.out.println("");
      System.out.print("| ");
      System.out.printf("%10s", stockpile[currCardPos].GetPattern());
      System.out.print(" |");
      System.out.println("");
      System.out.print("| ");
      System.out.printf("%10s", stockpile[currCardPos].GetColor());
      System.out.print(" |");
      System.out.println("");
      System.out.println("==============");

    }
    
    /* Displays the store on the screen
     * @param store - The array that contains Card objects representing the store */
    public void DisplayWaste(Card[][] waste) {
        System.out.println("WASTE");
        System.out.println("==============================================");
        for(int i = 0; i<4 ; i++){
            for (int k = 0; k<13; k++) {
                if (waste[k][i] != null) {
                }
                else if( (waste[k][i] == null) && !(k == 0)) {
                    if( (waste[k][i] == null) && !(k == 0) && waste[k-1][i] != null) {
                        System.out.println("==============");
                        System.out.print("| ");
                        System.out.printf("%10d", waste[k-1][i].GetNumber());
                        System.out.print(" |");
                        System.out.println("");
                        System.out.print("| ");
                        System.out.printf("%10s", waste[k-1][i].GetPattern());
                        System.out.print(" |");
                        System.out.println("");
                        System.out.print("| ");
                        System.out.printf("%10s", waste[k-1][i].GetColor());
                        System.out.print(" |");
                        System.out.println("");
                        System.out.println("==============");
                    }
                    break;
                }
                else {
                    System.out.println("=========");
                    System.out.print("| ");
                    System.out.print("Empty");
                    System.out.print(" |");
                    System.out.println("");
                    System.out.print("| ");
                    System.out.print("      |");
                    System.out.println("");
                    System.out.print("| ");
                    System.out.print("      |");
                    System.out.println("");
                    System.out.println("=========");
                }
            }
            System.out.println("");
        }
    }
  }
