/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import struct.Automaton;
import struct.Stade;
import view.JFrameWindow;

/**
 *
 * @author oscar
 */
public class Controller implements ActionListener{

    private JFrameWindow jFrameWindow;
    public ArrayList<Stade> stades;
    public Automaton automaton;
    
    public Controller(){
        stades = new ArrayList();
        automaton = new Automaton();
        jFrameWindow = new JFrameWindow(this);
        jFrameWindow.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
         switch(e.getActionCommand()){
            
            case "COMMAND_EXIT":
			int resp = JOptionPane.showConfirmDialog(null, "Desea salir?");
			if (resp == 0) {
				System.exit(0);
			}
			break;
		case "COMMAND_MIN":
			jFrameWindow.setState(Frame.ICONIFIED);
			break;
		case "COMMAND_MAX2":
			jFrameWindow.setExtendedState(Frame.MAXIMIZED_BOTH);
			jFrameWindow.change2();
			break;
		case "COMMAND_MAX1":
			jFrameWindow.setSize(1000, 500);
			jFrameWindow.setLocationRelativeTo(null);
			jFrameWindow.change1();
	
            default:
            break;
        }
    }
    
    public Stade getStadeByName(String name){
        for (Stade stade : stades) {
            if (stade.getName().equals(name)){
                return stade;
            }
        }
        return null;
    }
    
    public void addStade(Stade s){
        stades.add(s);
        System.out.println(stades);
    }
    
    public void setInitial(Stade s){
        addStade(s);
        System.out.println("qwertyuio-----------------------------------------------"+ s.getName());
        automaton.setInitialStade(s);
        automaton.setRoot(s);
    }
    
    public void addRelation(String nodea, String nodeb , String symbol){
       Stade a = getStadeByName(nodea);
        System.out.println(a.toString());
        Stade b = getStadeByName(nodeb);
        automaton.transicion(a, b, symbol);
    }
    
     public void verifyWord(String word){
        
         System.out.println("wfvergvertgvertv"+ automaton.getRoot().getTransition().size() );
         try{
            automaton.validateString(word);
//            automaton.getListNodes().add(0, root);
            automaton.printList();
         }catch(Exception c){
              System.err.println(c);
              JOptionPane.showMessageDialog(null, "Error: "+c);
         }
    }
}
