// Developed by Andy
public class Player {
    private String name;
    private int score;
   
   //======================= CONSTRUCTOR =======================//
   /* @discTpe - The type of disc that is being created (Either O or X) */
   public Player(String name) {
     this.name = name;
   }
   
   //====================== PUBLIC METHOD =======================//
   /* Gets the player's name
    * @return - The name of the player */
   public String GetName() {
     return name;   // Dummy return value, needs to be changed
   }
   
   /* Gets the players score 
    * @return - The player's score */
   public int GetScore() {
     return score;   // Dummy return value, needs to be changed
   }
   
   /* Add scores to the player's exiting score
    * @param score - The score that needs to be added
    *                to the player's score */
   public void AddScore(int score) {
     this.score += score;
   }
 }
