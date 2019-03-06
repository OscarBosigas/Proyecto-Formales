/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struct;

import struct.Automaton;
import struct.Stade;

/**
 *
 * @author Felipe Cristancho
 */
public class Test {
    
    
    
    public static void main(String[] args) {
        Automaton automaton = new Automaton();
        Stade root = new Stade("q0", false);
        automaton.setInitialStade(root);
//        root.setInitial(true);
        Stade q1 = new Stade("q1", false);
        Stade q2 = new Stade("q2",true);
        Stade q3 = new Stade("q3",true);
        Stade q4 = new Stade ("q4",false);
        automaton.setRoot(root);
        automaton.transicion(root, q1, "a");
        automaton.transicion(q1, q1, "a");
        automaton.transicion(q1, q2, "b");
        automaton.transicion(q2, q1, "a");
        automaton.transicion(root, q3, "c");
        automaton.transicion(q2, q4, "b");
        String palabra = "aabaaaaaba";
        
        try {           
            automaton.validateString(palabra);
            automaton.getListNodes().add(0, root);
            automaton.printList();
        } catch (Exception ex) {
            
        }
       
    }
}
