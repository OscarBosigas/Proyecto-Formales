/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import javax.swing.JDialog;

/**
 *
 * @author oscar
 */
public class JDTransitions extends JDialog{
    
    private Controller controller;
    
    public JDTransitions(Controller controller){
        this.controller = controller;
        init();
    }
    
    private void init(){
        this.setTitle("Agregacion Transiciones");
        this.setSize(500, 500);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
    }
}
