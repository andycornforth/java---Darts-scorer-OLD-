
package darts;

/**
 *
 * @author Andy
 */
public class Player {

    private String name;
    private int score, legs, visits, lastScore1 = 0, lastScore2 = 0,
            lastScore3 = 0, startScore;

    public Player(int i) {
        name = "player " + i;
        score = 501;
        startScore = 501;
        legs = 0;
    }
    
    public Player(int i, int ii) {
        name = "player " + i;
        score = ii;
        startScore = ii;
        legs = 0;
    }


    public String getStringScore() {
        String result;
        if (score == 0) {
            result = "YOU WIN";
        } else {
            result = "" + score;
        }
        return result;
    }

    public String getStringLegs() {
        String result;
        result = "" + legs;
        return result;
    }

    /*
     * Deals with players visit to the board
     */
    public boolean visit(int i) {

        boolean result = false;
        // if score is valid
        if (i > 0 && i <= 180) {
            // if score does not bust player
            if ((score - i) > 1) {
                result = true;
                score = score - i;// create new score
            } else if ((score - i) == 0) { // if player wins leg
                if (i <= 170) {
                    result = true;
                    score = 0;
                    legs += 1;
                }
            }
        }
        visits += 1;
        lastScores(i);
        return result;
    }

    /*
     * calculates 3 dart average for leg
     */
    public String average() {
        int result = 0;
        int reverseScore = 0;

        reverseScore = startScore - score;
        if (reverseScore == 0) {
            result = 0;
        } else {
            result = (reverseScore / visits);
        }
        return "" + result;
    }

    private void lastScores(int i) {
        lastScore3 = lastScore2;
        lastScore2 = lastScore1;
        lastScore1 = i;
    }
    
    /*
     * Getters and Setters
     */

    public String getLastScore1() {
        String result = "";

        if (lastScore1 != 0) {
            if (lastScore1 > 99) {
                result = "" + lastScore1 + " !!";
            } else {
                result = "" + lastScore1;
            }
        }
        return result;
    }

    public String getLastScore2() {
        String result = "";

        if (lastScore2 != 0) {
            result = "" + lastScore2;
        }
        return result;
    }

    public String getLastScore3() {
        String result = "";

        if (lastScore3 != 0) {
            result = "" + lastScore3;
        }
        return result;
    }

    public int getVisits() {
        return visits;
    }
    
    public void loseLeg(){
        
    }
    
    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getLegs() {
        return legs;
    }
    
    
    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        visits = 0;
        this.score = score;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }
}
