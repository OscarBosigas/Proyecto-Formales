package view;

import controller.Controller;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPUp extends JPanel {

	private static final long serialVersionUID = 1L;

	private Controller controller;
	private JButton min, max, close;
	private JLabel icon;
	private JLabel title;
	private JPanel east, west;

	public JPUp(Controller controller) {
		this.controller = controller;
		init();
	}

	private void init() {
		this.setLayout(new BorderLayout());

		min = new JButton("MIN");
		min.setSize(20, 20);
		min.setActionCommand("COMMAND_MIN");
		min.addActionListener(controller);
		min.setFocusable(false);
		min.setBackground(Color.yellow);
		min.setForeground(Color.black);

		max = new JButton("MAX");
		max.setSize(20, 20);
		max.setActionCommand("COMMAND_MAX1");
		max.addActionListener(controller);
		max.setFocusable(false);
		max.setBackground(Color.yellow);
		max.setForeground(Color.black);

		close = new JButton("SALIR");
		close.setSize(20, 20);
		close.setActionCommand("COMMAND_EXIT");
		close.addActionListener(controller);
                close.setBackground(Color.black);
                close.setForeground(Color.white);
		close.setFocusable(true);

		icon = new JLabel();
		ImageIcon imageIcon = new ImageIcon(getClass().getResource(""));
		icon.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
		title = new JLabel("PROYECTO FORMALES");
                title.setFont(new Font("Arial", 10, 20));
		title.setForeground(Color.white);

		east = new JPanel(new FlowLayout());
		east.setBackground(Color.decode("#5cb85c"));
		west = new JPanel(new FlowLayout());
		west.setBackground(Color.decode("#5cb85c"));
		west.setForeground(Color.white);

		west.add(icon);
		west.add(title);

		east.add(min);
		east.add(max);
		east.add(close);

		this.add(east, BorderLayout.EAST);
		this.add(west, BorderLayout.WEST);
		this.setBackground(Color.decode("#5cb85c"));

	}

	/**
	 * Metodo que cambia el comando de accion del boton de maximizar a el
	 * comando 2
	 */
	public void changeButton1() {
		max.setActionCommand("COMMAND_MAX2");
	}

	/**
	 * Metodo que cambia el ccomando de accion del boton de maximizar a el
	 * comando 1
	 */
	public void changeButton2() {
		max.setActionCommand("COMMAND_MAX1");
	}

}
