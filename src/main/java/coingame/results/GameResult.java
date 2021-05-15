package coingame.results;


public class GameResult {

    private String player1Name;

    private String player2Name;

    private String winner;

    private int player1Score;

    private int player2Score;

    private String date;

    public GameResult(String player1Name, String player2Name, String winner, int player1Score, int player2Score, String date) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.winner = winner;
        this.player1Score = player1Score;
        this.player2Score = player2Score;
        this.date = date;
    }

    public GameResult(){}

    public String getPlayer1Name() {
        return player1Name;
    }

    public String getPlayer2Name() {
        return player2Name;
    }

    public String getWinner() {
        return winner;
    }

    public int getPlayer1Score() {
        return player1Score;
    }

    public int getPlayer2Score() {
        return player2Score;
    }

    public String getDate() {
        return date;
    }

    public void setPlayer1Name(String player1Name) {
        this.player1Name = player1Name;
    }

    public void setPlayer2Name(String player2Name) {
        this.player2Name = player2Name;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public void setPlayer1Score(int player1Score) {
        this.player1Score = player1Score;
    }

    public void setPlayer2Score(int player2Score) {
        this.player2Score = player2Score;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
