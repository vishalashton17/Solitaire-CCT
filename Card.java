// Developed by Andy
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
  public int GetColor() {
    return facing;
  }
  /* Get the Card color
   * @return - The score */
  public abstract int CalcScore();
  
}
