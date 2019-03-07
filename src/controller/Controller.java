/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import struct.Automaton;
import struct.Stade;
import view.JDAutomataAdd;
import view.JDTransitions;
import view.JFrameWindow;

/**
 *
 * @author oscar
 */
public class Controller implements ActionListener {

    private JFrameWindow jFrameWindow;
    private JDAutomataAdd jDAutomataAdd;
    private JDTransitions jDTransitions;
    private Automaton automaton;

    public Controller() {
        jFrameWindow = new JFrameWindow(this);
        jDAutomataAdd = new JDAutomataAdd(this);
        jDTransitions = new JDTransitions(this);
        automaton = new Automaton();
        jFrameWindow.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

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
                break;
            case "Agregar A":
                jDAutomataAdd.setVisible(true);
                break;
            case "Agregar E":
                Stade s = jDAutomataAdd.addState();
                if(automaton.isRoot()){
                    automaton.setRoot(s);
                }else{
                    jDAutomataAdd.addAll(s);
                }
                jDAutomataAdd.clean();
                break;
            case "Transitions":
                jDAutomataAdd.setVisible(false);
                jDTransitions.setVisible(true);
                break;
            default:
                break;
        }
    }

}
