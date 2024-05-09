// Developed by Andy
public abstract class Card {
    private int number;
    private String pattern;
    private String color;
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
}
//============= Public Methods ================   
  /* Get the Card number
   * @return - The car code */
  public int GetNumber() {
    return number;
  }
  /* Get the Card pattern
   * @return - The car code */
  public String GetPattern() {
    return pattern;
  }
  /* Get the Card color
   * @return - The car code */
  public String GetColor() {
    return color;
  }
  public abstract int CalcScore();
  
}
