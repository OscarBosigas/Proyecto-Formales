/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struct;

/**
 *
 * @author Felipe Cristancho
 */
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
