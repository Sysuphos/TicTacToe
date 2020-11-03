package Yannick;

public class Joueur {
    String name;
    Boolean isWinner;
    Boolean isPlaying;

    public Joueur(String name) {
        this.name = name;
        isWinner = false;
        isPlaying = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getWinner() {
        return isWinner;
    }

    public void setWinner(Boolean winner) {
        isWinner = winner;
    }

    public Boolean getPlaying() {
        return isPlaying;
    }

    public void setPlaying(Boolean playing) {
        isPlaying = playing;
    }
}
