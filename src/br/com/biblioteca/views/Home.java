
package br.com.biblioteca.views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Home extends JFrame implements ActionListener{
        // inicializando componentes
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
        
        //construtor do frame
    public Home() throws HeadlessException {
        // setando e instanciando componentes
        container = getContentPane();
        container.setLayout(new GridBagLayout());
        jtp = new JTabbedPane();
        jpMenu = new JMenuBar();
        
        
        //adicionando dropdows ao menu
        jpMenu.add(userMenu);
        jpMenu.add(bookMenu);
        jpMenu.add(locationMenu);
        
        //adicinando itens nos dropdows
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
        
        //captura de eventos dos itens
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
       

       //posicianando o menu e o JTabbedPane
       posicionarElemento(0, 0, 1, 1, 1, 1, jpMenu);
       posicionarElemento(0, 1, 1, 1, 1, 150, jtp);
       
       
       //parametros de JFrame
       this.setSize(850,650);
       this.getContentPane().setBackground(Color.DARK_GRAY);
       this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       this.setTitle("Blibioteca");
       this.setLocationRelativeTo(null);
       this.setVisible(true);
        
       
    }

   
    //main
    public static void main(String[] args) {
          //instanciando o frame Home
          new Home();
    }
    
    
     public void posicionarElemento(int x, int y, int largura, int altura,
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
     
     public void addTab(JPanel jp, String nome){
         
         jtp.addTab(nome, jp);
         jtp.setSelectedComponent(jp);
         
     }


    @Override
    public void actionPerformed(ActionEvent e) {
      
         //instrução para o item cadastrar do menu usuario
        if(e.getSource()== cad){
            UserCad cadUser = new UserCad("cad");
            jtp.addTab("Usuários", cadUser );
            jtp.setSelectedComponent(cadUser);
        }
        
        
        // instrução para os itens editar, excluir e consultar do menu usuario
        if(e.getSource()== edit || e.getSource()== del || e.getSource()== con ){                        
            UserList listUser = new UserList();
            jtp.addTab("Consulta Usuários", listUser);
            jtp.setSelectedComponent(listUser);
        }
        
        
        //instrução para o item cadastrar do menu livro
        if(e.getSource()== bookcad){
            LivrosCad cadLivros = new LivrosCad("cad");
            jtp.addTab("Livros", cadLivros );
            jtp.setSelectedComponent(cadLivros);
        }
        
        
        // instrução para os itens editar, excluir e consultar do menu livro
        if(e.getSource()== bookedit || e.getSource()== bookdel || e.getSource()== bookcon ){                        
            LivrosList listLivros = new LivrosList();
            jtp.addTab("Consulta Livros", listLivros);
            jtp.setSelectedComponent(listLivros);
        }
        
        
        //instrução para o item cadastrar do menu localização
        if(e.getSource()== loccad){
            LocalizaCad cadLocaliza = new LocalizaCad("cad");
            jtp.addTab("Localização", cadLocaliza );
            jtp.setSelectedComponent(cadLocaliza);
        }
        
        
        // instrução para os itens editar, excluir e consultar do menu localização
        if(e.getSource()== locedit || e.getSource()== locdel || e.getSource()== loccon ){                        
            LocalizaList listLocaliza = new LocalizaList();
            jtp.addTab("Consulta Localização", listLocaliza);
            jtp.setSelectedComponent(listLocaliza);
        }
        
        
    }
     
    
}
