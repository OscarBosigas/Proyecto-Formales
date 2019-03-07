package view;

import javax.swing.JFrame;

import controller.Controller;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import javax.swing.JPanel;

public class JFrameWindow extends JFrame {

    private static final long serialVersionUID = 1L;

    private Controller controller;
    private JPUp jPUp;
    private JPanel aux1, aux2, south;
    private JLabel icon;
    private JPLeft jPLeft;
    private JBMenu jBMenu;

    public JFrameWindow(Controller controller) {
        this.controller = controller;
        this.jPUp = new JPUp(controller);
        this.jPLeft = new JPLeft(controller);
        jBMenu = new JBMenu(controller);
        init();
    }

    private void init() {
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLayout(new BorderLayout());

        this.setUndecorated(true);

        aux1 = new JPanel(new GridLayout(1, 1));
        this.add(aux1, BorderLayout.NORTH);

        aux1.add(jPUp);

        aux2 = new JPanel(new BorderLayout());
        aux2.add(jBMenu, BorderLayout.NORTH);
        
        south = new JPanel();
        
        this.add(aux2, BorderLayout.CENTER);
        this.add(jPLeft, BorderLayout.WEST);
        this.add(south, BorderLayout.SOUTH);

    }

    public void change1() {
        jPUp.changeButton1();
        jPLeft.setPreferredSize(new Dimension(100,800));
    }

    public void change2() {
        jPUp.changeButton2();        
        jPLeft.setPreferredSize(new Dimension(300,1000));
    }

    public void changeCenter1(){
        
    }
    
    public void changeCenter2(){
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/img/parque.JPG"));
        icon.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(800, 450, Image.SCALE_DEFAULT)));
        aux2.add(icon);
        this.add(aux2, BorderLayout.CENTER);
    }
}
