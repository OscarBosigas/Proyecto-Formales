/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author oscar
 */
public class JBMenu extends JPanel{
    
    private Controller controller;
    
    public JBMenu(Controller controller){
        this.controller = controller;
        this.setBackground(Color.red);
    }
}
