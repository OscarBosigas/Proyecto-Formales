/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import struct.Stade;

/**
 *
 * @author oscar
 */
public class JBMenu extends JPanel {

    private final Controller controller;
    private JButton newAutoButton;
    private JButton newRelButton;
    private JButton verButton;
    private JButton addNodeButton;
    
    private javax.swing.JList<String> jList1;
    private JScrollPane jScrollPane1;
    
    private JTextField nodeNameTF;
    private JTextField symbolNameTF;
    private JTextField verTF;
    
    private DefaultListModel model1;
    private boolean firstBoolean;
    private boolean firstFinalBoolean;
    private boolean firstReal;
    
    private JCheckBox isInitial;
    private JCheckBox isFinal;
    private ArrayList<String> nodes;
    private JComboBox nodeAComboB;
    private JComboBox nodeBComboB;

    public JBMenu(Controller controller) {
        GridSystem gridSystem = new GridSystem(this);

        model1 = new DefaultListModel();
        jScrollPane1 = new JScrollPane();
        jList1 = new javax.swing.JList<>();
        
        nodeNameTF = new JTextField();
        symbolNameTF = new JTextField();
        verTF = new JTextField();
        
      
        isInitial = new JCheckBox();
        isFinal = new JCheckBox();
        
        addNodeButton = new JButton();
        newAutoButton = new JButton("Nuevo automata");
        newRelButton = new JButton("Nueva relacion");
        verButton = new JButton("Verificar palabra");
        
        nodeAComboB = new JComboBox();
        nodeBComboB = new JComboBox();
        
        firstBoolean = true;
        firstReal = true;
        firstFinalBoolean = true;
        
        isInitial.setText("Inicial");
        isInitial.setBackground(null);
        isFinal.setText("Final");
         isFinal.setBackground(null);

        model1.addElement("Q = {}");
        model1.addElement("L= {}");
        model1.addElement("F = {}");
        model1.addElement("SO = {}");
        model1.addElement("SA = {}");

        addNodeButton.setText("add node");

        nodeBComboB.setVisible(false);
        symbolNameTF.setVisible(false);
        newRelButton.setVisible(false);
        
        nodeAComboB.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(nodeAComboB.getItemCount() > 1){
                    nodeBComboB.setVisible(true);
                }
            }
        });
        
        nodeBComboB.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(nodeAComboB.getItemCount() > 1){
                   symbolNameTF.setVisible(true);
                   newRelButton.setVisible(true);
                }
                
            }
        });
        
        verButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String palabra = verTF.getText();
                controller.verifyWord(palabra);
            }
        }
        );

        newRelButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a = model1.getElementAt(2) + "";
                String b = a.substring(0, a.length() - 1);
                
                String c = model1.getElementAt(1) + "";
                String d = c.substring(0, c.length() - 1);
                model1.remove(2);
                model1.remove(1);
              String nodeA = String.valueOf(nodeAComboB.getSelectedItem());  
              String nodeB = String.valueOf(nodeBComboB.getSelectedItem());  
                String node = nodeA+"  -"+symbolNameTF.getText()+"-> "+nodeB;
               controller.addRelation(nodeA, nodeB, symbolNameTF.getText());
                if (firstReal) {
                    model1.add(1, d + symbolNameTF.getText() + "}");
                    model1.add(2, b + node + "}");
                    firstReal = false;
                } else {
                    model1.add(1, d +  "," +symbolNameTF.getText() + "}");
                    model1.add(2, b + "," + node + "}");
                }
            }
        });
                
                addNodeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String a = model1.getElementAt(0) + "";
                String b = a.substring(0, a.length() - 1);
                model1.remove(0);
                String node = nodeNameTF.getText();
                if (firstBoolean) {
                    model1.add(0, b + node + "}");

                    firstBoolean = false;
                } else {
                    model1.add(0, b + "," + nodeNameTF.getText() + "}");
                }
                nodeAComboB.addItem(nodeNameTF.getText());
                nodeBComboB.addItem(nodeNameTF.getText());

                String c = model1.getElementAt(4) + "";
                String d = c.substring(0, c.length() - 1);

                if (isFinal.isSelected()) {
                    model1.remove(4);
                    if (firstFinalBoolean) {
                        model1.add(4, d + nodeNameTF.getText() + "}");
                        firstFinalBoolean = false;
                    } else {
                        model1.add(4, d + "," + nodeNameTF.getText() + "}");
                    }
                    
                }
                jList1.setModel(model1);
                jList1.setSelectedIndex(3);
                String aa = model1.getElementAt(3) + "";
                String bb = aa.substring(0, aa.length() - 1);

               
                /////////////////////////////////////////////// validación para el modelo 
                
                if (isInitial.isSelected()) {
                    model1.remove(3);
                    model1.add(3, bb + nodeNameTF.getText() + "}");
                    isInitial.setSelected(false);
                    isInitial.setEnabled(false);
                     controller.setInitial(new Stade(nodeNameTF.getText(), false));
                }else  if(isFinal.isSelected()){
                    Stade fin =new Stade(nodeNameTF.getText(), true);
                    controller.addStade(fin);
                }else{
                    controller.addStade(new Stade(nodeNameTF.getText(), false));
                }
                
            }
        });

        newAutoButton.addActionListener(controller);
        newAutoButton.setForeground(Color.WHITE);
//      newAutoButton.setBackground(ConstantsUI.BTN_COLOR);

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {"_________ Formalismo del automata ________"};

            @Override
            public int getSize() {
                return strings.length;
            }

            @Override
            public String getElementAt(int i) {
                return strings[i];
            }
        });

        jScrollPane1.setViewportView(jList1);
        jScrollPane1.setSize(400, 500);

        nodeNameTF.setText("Q0");
        nodeNameTF.setSize(300, 50);

        this.controller = controller;
        this.setBackground(Color.DARK_GRAY);
        
        
        
        
       JPanel a = new JPanel();
        a.setLayout(new GridLayout(2, 2));
        a.add(isInitial);
        a.add(isFinal);
        
        
        
        JPanel b = new JPanel();
        b.setLayout(new GridLayout(2, 2));
        b.add(nodeAComboB);
        b.add(nodeBComboB);
       b.add(Box.createRigidArea(new Dimension(0, 1)));
        b.add(nodeBComboB);
         b.add(symbolNameTF);
         b.add(newRelButton);
         b.setBackground(null);
         
         JPanel c = new JPanel();
        c.setLayout(new GridLayout(2, 2));
        c.add(verTF);
        c.add(verButton);
        

       gridSystem.addExternalBorder(100, 100, 100, 100);
//        add(newAutoButton, gridSystem.insertComponent(1, 0, 1, 100));
gridSystem.addExternalBorder(100, 100, 100, 100);
        add(jScrollPane1, gridSystem.insertComponent(1, 4, 5, 10));
  gridSystem.addExternalBorder(1, 1, 1, 1);
        add(addNodeButton, gridSystem.insertComponent(2, 0, 2, 10));
        add(nodeNameTF, gridSystem.insertComponent(2, 4, 6, 10));
     gridSystem.addExternalBorder(1, 1, 1, 1);
        add(a, gridSystem.insertComponent(3, 4, 4, 10));
       gridSystem.addExternalBorder(1, 1, 1, 1);
//        add(isFinal, gridSystem.insertComponent(3, 11, 11, 10));
       gridSystem.addExternalBorder(1, 1, 1, 1);
        add(b, gridSystem.insertComponent(6, 0, 1, 10));
//gridSystem.addExternalBorder(1, 1, 1, 1);
//        add(nodeBComboB, gridSystem.insertComponent(6, 2, 2, 10));
//       gridSystem.addExternalBorder(1, 1, 1, 1);
//        add(symbolNameTF, gridSystem.insertComponent(6, 5, 5, 10));
   
//        add(verTF, gridSystem.insertComponent(7, 1, 1, 10));
        gridSystem.addExternalBorder(1, 1, 1, 1);
        
        add(c, gridSystem.insertComponent(7, 5, 5, 10));
    }
}
