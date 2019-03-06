package struct;

public class Transition {
    
    private Stade next;
    private String character;

    public Transition(Stade next, String character) {
        this.next = next;
        this.character = character;
    }

    public Stade getNext() {
        return next;
    }

    public String getCharacter() {
        return character;
    }
    
}
