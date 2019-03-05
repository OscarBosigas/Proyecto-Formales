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
    
    private Node next;
    private String symbol;

    public Transition(Node next, String symbol) {
        this.next = next;
        this.symbol = symbol;
    }

    public Node getNext() {
        return next;
    }

    public String getSymbol() {
        return symbol;
    }
    
}
