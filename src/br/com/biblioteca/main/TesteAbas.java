/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.biblioteca.main;

import br.com.biblioteca.livros.CadastroLivros;
import br.com.biblioteca.localizacao.CadastroLocalizacao;
import br.com.biblioteca.user.CadUser;
import br.com.biblioteca.user.CadastroUsuario;
import br.com.biblioteca.user.ListUser;
import br.com.biblioteca.user.ListagemUsuarios;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author IFMS
 */
public class TesteAbas extends JFrame implements ActionListener{
        // 
        private Container container;
        private JTabbedPane jtp;
        private JMenuBar jpMenu;
    
        // Define e adiciona dois menus drop down na barra de menus
        JMenu userMenu = new JMenu("Usuário");
        JMenu bookMenu = new JMenu("Livros");
        JMenu locationMenu = new JMenu("Localização");
        
        
        // Cria e adiciona um item simples para o menu
        JMenuItem  cad = new JMenuItem("Cadastrar");
        JMenuItem  edit = new JMenuItem("Editar");
        JMenuItem  del = new JMenuItem("Excluir");
        JMenuItem  con = new JMenuItem("Consultar");
        JMenuItem  bookcad = new JMenuItem("Cadastrar");
        JMenuItem  bookedit = new JMenuItem("Editar");
        JMenuItem  bookdel = new JMenuItem("Excluir");
        JMenuItem  bookcon = new JMenuItem("Consultar");
        JMenuItem  loccad = new JMenuItem("Cadastrar");
        JMenuItem  locedit = new JMenuItem("Editar");
        JMenuItem  locdel = new JMenuItem("Excluir");
        JMenuItem  loccon = new JMenuItem("Consultar");
        

    public TesteAbas() throws HeadlessException {
        
        container = getContentPane();
        container.setLayout(new GridBagLayout());
        jtp = new JTabbedPane();
        jpMenu = new JMenuBar();
        
        
       
        jpMenu.add(userMenu);
        jpMenu.add(bookMenu);
        jpMenu.add(locationMenu);
        
        
        userMenu.add(cad);
        userMenu.add(edit);
        userMenu.add(del);
        userMenu.addSeparator();
        userMenu.add(con);
        bookMenu.add(bookcad);
        bookMenu.add(bookedit);
        bookMenu.add(bookdel);
        bookMenu.addSeparator();
        bookMenu.add(bookcon);
        locationMenu.add(loccad);
        locationMenu.add(locedit);
        locationMenu.add(locdel);
        locationMenu.addSeparator();
        locationMenu.add(loccon);
        
        cad.addActionListener(this);
        edit.addActionListener(this);
        del.addActionListener(this);
        con.addActionListener(this);
        bookcad.addActionListener(this);
        bookedit.addActionListener(this);
        bookdel.addActionListener(this);
        bookcon.addActionListener(this);
        loccad.addActionListener(this);
        locedit.addActionListener(this);
        locdel.addActionListener(this);
        loccon.addActionListener(this);
       

       
       posicionarElemento(0, 0, 1, 1, 1, 1, jpMenu);
       posicionarElemento(0, 1, 1, 1, 1, 150, jtp);
       
       
        
       this.setSize(850,650);
       this.getContentPane().setBackground(Color.DARK_GRAY);
       this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       this.setTitle("Blibioteca");
       this.setLocationRelativeTo(null);
       this.setVisible(true);
        
       
    }

   
    
    public static void main(String[] args) {
        TesteAbas ta = new TesteAbas();
        
        
    }
    
     void posicionarElemento(int x, int y, int largura, int altura,
            double scalaX, double scalaY, Component elemento){
        
        GridBagConstraints restricoes = new GridBagConstraints();
        
        restricoes.gridx       = x;
        restricoes.gridy       = y;
        restricoes.gridwidth   = largura;
        restricoes.gridheight  = altura;
        restricoes.weightx     = scalaX;
        restricoes.weighty     = scalaY;
        restricoes.fill        = GridBagConstraints.BOTH;
        restricoes.anchor      = GridBagConstraints.CENTER;
        
        container.add(elemento, restricoes);
        
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //--- inicio try
         
        if(e.getSource()== cad){
            CadUser caduser = new CadUser();
            jtp.addTab("Cadastro de Usuários", caduser );
            jtp.setSelectedComponent(caduser);
        }
        if(e.getSource()== edit || e.getSource()== del || e.getSource()== con ){                        
            ListUser list = new ListUser();
            jtp.addTab("Consulta de Usuários", list);
            jtp.setSelectedComponent(list);
        }
        
        //--fim try
    }
     
    
}
