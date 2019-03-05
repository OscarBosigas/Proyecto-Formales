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
public class Node {
    
    private String name;
    private List<Transition> listTransition;
    private boolean isInitial;
    private boolean isFinal;

    public Node(String name,boolean isFinal) {
        listTransition = new ArrayList<Transition>();
        this.name = name;
        this.isFinal = isFinal;
    }

    public Node(){}
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Transition> getTransition() {
        return listTransition;
    }
    
    public void setTransition(Transition transition) {
        this.listTransition.add(transition);
    }

    public boolean isIsInitial() {
        return isInitial;
    }

    public void setIsInitial(boolean isInitial) {
        this.isInitial = isInitial;
    }

    public boolean isIsFinal() {
        return isFinal;
    }

    public void setIsFinal(boolean isFinal) {
        this.isFinal = isFinal;
    }

    
}
