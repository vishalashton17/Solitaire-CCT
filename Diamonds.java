// Developed by Andy
public class Diamonds extends Card {
    String scoreType;
    /* To instantiate a Diamonds object
    * @param number          - The number of this card
    * @param pattern         - The pattern of this card
    * @param color           - The color of this card 
    * @param scoreType       - The score type of the card, used to calculate score */
  public Diamonds( int number, String pattern, String color, String scoreType ) {
    super(number, pattern, color);
    this.scoreType = scoreType;
    }
    /* To calcualte the score
    * @param scoreType       - The score type of the card, used to calculate score
    * @returns score         - The score calculated from scoreType*/
  public int CalcScore() {
    int score;
    score = scoreType.length();
    return score;
  }
}
