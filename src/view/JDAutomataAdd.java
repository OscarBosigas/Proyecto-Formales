/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import struct.Stade;

/**
 *
 * @author oscar
 */
public class JDAutomataAdd extends JDialog{
    
    private Controller controller;
    private JButton add, cancel, transitions;
    private JTextField states;
    private JCheckBox  fin;
    private JLabel op1, estado;
    private List<Stade> list;
    
    public JDAutomataAdd(Controller controller){
        this.controller = controller;
        list = new ArrayList<>();
        init();
    }
    
    private void init() {
        this.setTitle("Agregacion Estados");
        this.setSize(300, 300);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        
        add = new JButton("Agregar Estado");
        add.addActionListener(controller);
        add.setActionCommand("Agregar E");
        add.setBounds(10, 150, 130, 50);
        this.add(add);
        
        cancel = new JButton("Cancelar");
        cancel.addActionListener(controller);
        cancel.setActionCommand("cancel");        
        cancel.setBounds(145, 150, 130, 50);
        this.add(cancel);
        
        transitions = new JButton("Ir a transiciones");
        transitions.addActionListener(controller);
        transitions.setActionCommand("Transitions");
        transitions.setEnabled(false);
        transitions.setBounds(10, 210, 265, 40);
        this.add(transitions);
        
        estado = new JLabel("Estado");
        estado.setBounds(20,20,100,20);
        this.add(estado);
        
        states = new JTextField();
        states.setBounds(120, 20, 130,20);
        this.add(states);
        
        op1 = new JLabel("Final");
        op1.setBounds(20,70,100,20);
        this.add(op1);
        
               
        fin = new JCheckBox();
        fin.setBounds(180,70,20,20);
        this.add(fin);
               
        
    }
        
    public Stade addState(){
        String name = this.estado.getText();
        boolean x = this.fin.isSelected();
        Stade s = new Stade(name, x);
        this.transitions.setEnabled(true);
        return s;
    }
    
    public void addAll(Stade s){
        this.list.add(s);
    }
    
    public void clean(){
        this.fin.setSelected(false);
        this.states.setText("");
    }
   
}
