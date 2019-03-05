/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struct;

import java.util.logging.Level;
import java.util.logging.Logger;
import struct.Graph;
import struct.Node;
import struct.Transition;

/**
 *
 * @author Felipe Cristancho
 */
public class Test {
    
    
    
    public static void main(String[] args) {
        Graph grafo = new Graph();
        Node root = new Node("q0", false);
        root.setIsInitial(true);
        Node q1 = new Node("q1", false);
        Node q2 = new Node("q2",true);
        Node q3 = new Node("q3",true);
        Node q4 = new Node ("q4",false);
        grafo.setRoot(root);
        
        grafo.transicion(root, q1, "a");
        grafo.transicion(q1, q1, "a");
        grafo.transicion(q1, q2, "b");
        grafo.transicion(q2, q1, "a");
        grafo.transicion(root, q3, "c");
        grafo.transicion(q2, q4, "b");
        
        String palabra = "aabaaaaaba";
        
        try {           
            grafo.validateString(palabra, root,0);
            grafo.getListNodes().add(0, root);
            grafo.printList();
        } catch (Exception ex) {
            
        }
       
    }
}
