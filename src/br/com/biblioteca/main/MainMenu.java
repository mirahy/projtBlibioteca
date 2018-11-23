/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.biblioteca.main;

import br.com.biblioteca.user.CadastroUsuario;
import br.com.biblioteca.user.ListagemUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author IFMS
 */
public class MainMenu extends JMenuBar implements ActionListener{
    
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
        
        

        @SuppressWarnings("Convert2Lambda")
    public MainMenu() {
        
        
        add(userMenu);
        add(bookMenu);
        add(locationMenu);
        
        
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
        
        


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
         try {
         //--- inicio try    
         
        if(e.getSource()== cad){            
             CadastroUsuario cu = new CadastroUsuario();
             cu.setVisible(true);
         }
        
        if(e.getSource()== edit || e.getSource()== del || e.getSource()== con ){                        
            ListagemUsuarios lu = new ListagemUsuarios();
            lu.setVisible(true);
         }
        
        //--fim try
        
        } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

 
}
