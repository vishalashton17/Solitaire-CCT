// Developed by Andy
public class Hearts extends Card {
    int scoreType;
    /* To instantiate a Hearts object
    * @param number          - The number of this card
    * @param pattern         - The pattern of this card
    * @param color           - The color of this card 
    * @param scoreType       - The score type of the card, used to calculate score */
  public Hearts( int number, String pattern, String color, int scoreType ) {
    super(number, pattern, color);
    this.scoreType = scoreType;
    }
    /* To calcualte the score
    * @param scoreType       - The score type of the card, used to calculate score
    * @returns score         - The score calculated from scoreType*/
  public int CalcScore(int scoreType) {
    int score;
    score = (int)Math.pow(scoreType + 10, 2 );
    return score;
  }
}
