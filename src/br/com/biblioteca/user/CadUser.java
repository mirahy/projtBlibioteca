/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.biblioteca.user;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author mirahyfonseca-cms
 */
public class CadUser extends JPanel implements ActionListener{
   
    private JMenuBar jppMenu;
    private JPanel painelInterno;
    private JPanel form;
    JTextField nome;
    JComboBox perfil;
    JLabel jlNome;
    JLabel jlPerfil;
    

    public CadUser() throws HeadlessException {
        
       setLayout(new GridBagLayout());
       
       jppMenu = new JMenuBar();
       
       
        JMenuItem  cad = new JMenuItem("Cadastrar");
        JMenuItem  edit = new JMenuItem("Editar");
        JMenuItem  del = new JMenuItem("Excluir");
        JMenuItem  con = new JMenuItem("Consultar");
        
        jppMenu.add(cad);
        jppMenu.add(edit);
        jppMenu.add(del);
        jppMenu.add(con);
        
        cad.addActionListener(this);
        edit.addActionListener(this);
        del.addActionListener(this);
        con.addActionListener(this);
        
        
        jppMenu.setLayout(new FlowLayout(FlowLayout.LEFT));
        posicionarElemento(0, 0, 1, 1, 1, 1, jppMenu);
        
        painelInterno = new JPanel();
        painelInterno.setLayout(null);
        posicionarElemento(0, 1, 1, 1, 1, 150, painelInterno);
        
        form = new JPanel();
        form.setSize(210,300);
        form.setLayout(new FlowLayout(FlowLayout.LEFT));
        painelInterno.add(form);
        
        
        nome = new JTextField();
        perfil = new JComboBox(new String[] { "Aluno", "Blibiotecario" });
        jlNome = new JLabel("NOME:");
        jlPerfil = new JLabel("PERFIL:");
        jlNome.setText("Nome:");

        
        nome.setPreferredSize(new Dimension(200,30));
        perfil.setPreferredSize(new Dimension(200,30));
        form.add(jlNome );
        form.add(nome);
        form.add(jlPerfil);
        form.add(perfil);
        

        
        
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
        
        add(elemento, restricoes);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("ok");
    }
    
    
}
