public class Player {
  private String name;
  private int score;

 //======================= CONSTRUCTOR =======================//
 /* @discTpe - The type of disc that is being created (Either One or Two) */

 // Developed by Vishal
 public Player(String playerName) {
  this.name = playerName; // Assigning playerName to instance variable this.name
  this.score = 0;
}
 
 //====================== PUBLIC METHODS =======================//
 /* Gets the player's name
  * @return - The name of the player */

 // Developed by Andy
 public String GetName() {
   return name;  
 }
 
 /* Gets the players score 
  * @return - The player's score */
 
 // Developed by Vishal
 public int GetScore() {
   return score;
 }
 
 /* Add scores to the player's exiting score
  * @param score - The score that needs to be added
  *                to the player's score */

 // Developed by Andy
 public void AddScore(int score) {
   this.score += score;
 }
}
