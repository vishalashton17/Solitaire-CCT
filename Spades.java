// Developed by Andy
public class Spades extends Card {
    double scoreType;
    /* To instantiate a Spades object
    * @param number          - The number of this card
    * @param pattern         - The pattern of this card
    * @param color           - The color of this card 
    * @param scoreType       - The score type of the card, used to calculate score */
  public Spades( int number, String pattern, String color, double scoreType ) {
    super(number, pattern, color);
    this.scoreType = scoreType;
    }

  public int CalcScore() {
    int score;
    score = (int)Math.pow(scoreType + 10, 2 );
    return score;
  }
}
