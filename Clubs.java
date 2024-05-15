// Developed by Vishal
public class Clubs extends Card {
    char scoreType;
    /* To instantiate a Clubs object
    * @param number          - The number of this card
    * @param pattern         - The pattern of this card
    * @param color           - The color of this card 
    * @param scoreType       - The score type of the card, used to calculate score */
  public Clubs( int number, String pattern, String color, char scoreType ) {
    super(number, pattern, color);
    this.scoreType = scoreType;
    }
    /* To calcualte the score
    * @param scoreType       - The score type of the card, used to calculate score
    * @returns score         - The score calculated from scoreType*/
  public int CalcScore(char scoreType) {
    int score;
    score = scoreType/10;
    return score;
  }
}
