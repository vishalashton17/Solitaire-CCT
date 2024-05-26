public abstract class Card {
  private int number;
  private String pattern;
  private String color;
  private int facing; // to store if the card is facing up or down. 0 is facing down. 1 is facing up
  //============== Constructor ===============
/* Default constructor for initiating a Car object */

/* To instantiate a Card object
* @param number          - The number of this card
* @param pattern         - The pattern of this card
* @param color           - The color of this card */
public Card( int number, String pattern, String color) {
  this.number = number;
  this.pattern = pattern;
  this.color = color;
  facing = 0;
}
//============= Public Methods ================   
/* Get the Card number
 * @return - The car code */
public int GetNumber() {
  return number;
}
/* Get the Card pattern
 * @return - The card pattern */
public String GetPattern() {
  return pattern;
}   
/* Get the Card color
 * @return - The card color */
public String GetColor() {
  return color;
}
  /* Get where the Card is facing
 * @return - The where card facing 0 for down, 1 for up. */
public int GetFacing() {
  return facing;
}

/* Get where the Card is facing
  * @return - The where card facing 0 for down, 1 for up. */
  public void SetFacing() {
    facing = 1;
  }
  
/* Get the Card color
 * @return - The score */
public abstract int CalcScore();


public boolean CanMoveOnto(Card targetCard, Card toCard) {
  // Check if the target card is null or if it's facing down
 if (targetCard == null || targetCard.GetFacing() == 0) {
     return false; // Cannot move onto a null or face-down card
 }

 // Special case for Ace and King
 if ((this.number == 1 && toCard.GetNumber() == 13) || (this.number == 13 && toCard.GetNumber() == 1)) {
     return true; // Ace can be placed on a King and vice versa
 }

 // Check if the target card's number is one less than this card's number
 if (toCard.GetNumber() - targetCard.GetNumber() == 1) {

     // Check if the colors are opposite
     if ((toCard.GetColor().equals("red") && this.color.equals("black")) || 
         (toCard.GetColor().equals("black") && this.color.equals("red"))) {
         return true; // Can move onto the target card
     }
 }

 return false; // Cannot move onto the target card
}

}
