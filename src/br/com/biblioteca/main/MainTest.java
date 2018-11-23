/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.biblioteca.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author IFMS
 */
public class MainTest extends JFrame{
    
    JPanel jpMenu, jpDesktop;
    MainMenu jm;

    public MainTest() throws HeadlessException {
        
        jpMenu     = new JPanel();
        jpDesktop  = new JPanel();
        jm         = new MainMenu();
        
       
       // adicionando barra ao frame
       jpMenu.setSize(600, 25);
       jpMenu.setLayout(new BorderLayout());
       jpMenu.add(jm, BorderLayout.NORTH);
       add(jpMenu, BorderLayout.NORTH);
       
       
       //jpDesktop.setSize(600,375 );
       add(jpDesktop, BorderLayout.CENTER);
       jpDesktop.setLayout(null);
       
       final JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setBounds(0, 0, 502, 371);
		getContentPane().add(tabbedPane);
                tabbedPane.addTab("Tab 1", null, jpDesktop, null);
                

        //setando configurações do frame
       this.setSize(600,400);
       this.getContentPane().setBackground(Color.DARK_GRAY);
       this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       this.setTitle("Blibioteca");
       this.setLayout( new BorderLayout());
       this.setLocationRelativeTo(null);
       this.setVisible(true);
        
       
    }
    
    public static void main(String[] args) {
        
        MainTest mt = new MainTest();
        
        
       
    }
   
    
    
}
