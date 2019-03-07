/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author oscar
 */
public class JBMenu extends JPanel{
    
    private Controller controller;
    private JButton jBAdd, jBRun;
    
    public JBMenu(Controller controller){
        this.controller = controller;
        this.setLayout(new GridLayout(1, 2));
        init();
    }
    
    private void init(){
        jBAdd = new JButton("Agregar Automata");
        jBAdd.addActionListener(controller);
        jBAdd.setActionCommand("Agregar A");
        this.add(jBAdd);
        
        jBRun = new JButton("Comenzar");
        jBRun.addActionListener(controller);
        jBRun.setActionCommand("Comenzar");
        this.add(jBRun);
    }
}
