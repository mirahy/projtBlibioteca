/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.biblioteca.user;

import java.awt.GridLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;

/**
 *
 * @author IFMS
 */
public class Abas extends JFrame{
    
    public static void main(String[] args) {
		Abas tab = new Abas();
		tab.setVisible(true);
	}
	public Abas() {
		super();
		getContentPane().setLayout(null);
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
		this.setTitle("Testando eventos das abas");
		//this.setResizable(false);
                getContentPane().setLayout(new GridLayout());
		final JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setBounds(0, 0, 502, 371);
		getContentPane().add(tabbedPane);
		final JPanel panel = new JPanel();
		panel.setLayout(null);
		tabbedPane.addTab("Tab 1", null, panel, null);
		final JSlider slider = new JSlider();
		slider.setBounds(133, 144, 200, 16);
		panel.add(slider);
		final JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		tabbedPane.addTab("Tab 2", null, panel_1, null);
		final JCheckBox checkBox = new JCheckBox();
		checkBox.setBounds(170, 130, 118, 24);
		checkBox.setText("New JCheckBox");
		panel_1.add(checkBox);
		final JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		tabbedPane.addTab("Tab 3", null, panel_2, null);
		final JRadioButton radioButton = new JRadioButton();
		radioButton.setText("New JRadioButton");
		radioButton.setBounds(180, 141, 129, 24);
		panel_2.add(radioButton);
	}
    
}
