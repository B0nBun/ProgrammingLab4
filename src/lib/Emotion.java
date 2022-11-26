package lib;

public enum Emotion {
    Fear("Fear"),
    Panic("Panic"),
    Ecstasy("Ecstasy");

    private String name;
    
    private Emotion(String s) {
        this.name = s;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
