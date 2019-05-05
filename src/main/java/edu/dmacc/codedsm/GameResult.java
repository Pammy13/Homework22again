package edu.dmacc.codedsm;

public class GameResult {

    private String player;
    private Integer score;

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof GameResult)) {
            return false;
        }

        GameResult gameResult = (GameResult) o;

        return gameResult.player.equals(player) &&
                gameResult.score.equals(score);
    }
}
