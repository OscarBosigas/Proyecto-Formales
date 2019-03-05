/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struct;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Felipe Cristancho
 */
public class Graph {
    
    private Node root;
    private List<Node> listNodes = new ArrayList<>();

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
    
    public void transicion(Node actual, Node next, String Symbol) {
        Transition transicion = new Transition(next, Symbol);
        actual.setTransition(transicion);
    }
    
    public boolean validateString(String text, Node raiz,int index) throws Exception{
        Node actual = raiz;
        String aux = text;
        if (aux.equals("") && actual.isIsFinal()) {
            return true;
        }else if (aux.equals("") && !actual.isIsFinal()) {
            return false;
        }
        if (!aux.equals("")) {
           if (getLetter(aux).equals(actual.getTransition().get(index).getSymbol())&& index < actual.getTransition().size()) {
                actual = actual.getTransition().get(index).getNext();
                index = 0;
                aux = convert(aux);
                validateString(aux, actual,index);
                listNodes.add(0, actual);
            }else{
                index++;
                validateString(aux, actual,index);
            } 
        }       
        return true;
    }
    
    public String convert(String text){
        String result = "";
        for (int i = 1; i < text.length(); i++) {
            result += text.charAt(i);
        }
        return result;
    }
    
    public void printList(){
        for (int i = 0; i < listNodes.size(); i++) {
            System.out.println(listNodes.get(i).getName());
        }
    }

    public List<Node> getListNodes() {
        return listNodes;
    }
    
    public String getLetter(String text){
        return String.valueOf(text.charAt(0));
    }
    
}
