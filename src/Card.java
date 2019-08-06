public class Card {
    private int value;
    private String suite;
    private boolean faceUp;

    public void Card(int value, String suite, boolean faceUp) {
        this.value = value;
        this.suite = suite;
        this.faceUp = faceUp;
    }

    public int getValue() {
        return value;
    }

    public String getSuite() {
        return suite;
    }

    public boolean isFaceUp() {
        return faceUp;
    }

    public void setFaceUp(boolean faceUp) {
        this.faceUp = faceUp;
    }
}
