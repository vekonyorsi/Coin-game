package coingame.results;

/**
 * This class is representing the gamresult by playing two players.
 */
public class GameResult {

    private String player1Name;

    private String player2Name;

    private String winner;

    private int player1Score;

    private int player2Score;

    private String date;

    /**
     * Create an instance of {@code GameResult} object.
     * Initializes the two player's name, the winner's name,
     * the two players' score and the date.
     *
     * @param player1Name Name of the first player.
     * @param player2Name Name of the second player.
     * @param winner Name of the winner.
     * @param player1Score Score of the first player.
     * @param player2Score Score of the second player.
     * @param date The date when the game is played.
     */
    public GameResult(String player1Name, String player2Name, String winner, int player1Score, int player2Score, String date) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.winner = winner;
        this.player1Score = player1Score;
        this.player2Score = player2Score;
        this.date = date;
    }

    /**
     * Constructor with no arg.
     */
    public GameResult(){}

    /**
     * Getter of the {@code Player1Name}.
     *
     * @return the first player's name.
     */
    public String getPlayer1Name() {
        return player1Name;
    }

    /**
     * Getter of the {@code Player2Name}.
     *
     * @return the second player's name.
     */
    public String getPlayer2Name() {
        return player2Name;
    }

    /**
     * Getter of the {@code Winner}.
     *
     * @return the winner player's name.
     */
    public String getWinner() {
        return winner;
    }

    /**
     * Getter of the {@code Player1Score}.
     *
     * @return the first player's score.
     */
    public int getPlayer1Score() {
        return player1Score;
    }

    /**
     * Getter of the {@code Player2Score}.
     *
     * @return the second player's score.
     */
    public int getPlayer2Score() {
        return player2Score;
    }

    /**
     * Getter of the {@code Date}.
     *
     * @return the date when the game is played.
     */
    public String getDate() {
        return date;
    }

}
