
package br.com.biblioteca.views;

import br.com.biblioteca.app.controller.LivroController;
import br.com.biblioteca.bd.Conexao;
import br.com.biblioteca.app.model.Livro;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXDatePicker;


public class LivrosCad extends JPanel implements ActionListener{
    
    //inicializando variáveis
    private JMenuBar jppMenu;
    private JPanel painelInterno;
    private JPanel form;
    private JTextField textNome;
    private JTextField textId;
    private JXDatePicker textDataLancamento;
    private JLabel jlNome;
    private JLabel jlData;
    private Connection conn;
    private Livro livros = new Livro();
        JMenuItem  cad = new JMenuItem("Cadastrar");
        JMenuItem  edit = new JMenuItem("Editar");
        JMenuItem  del = new JMenuItem("Excluir");
        JMenuItem  con = new JMenuItem("Consultar");

    public LivrosCad( String op) {
        

       setLayout(new GridBagLayout());
       
        jppMenu = new JMenuBar();
     
        
        if(op == "cad"){
            jppMenu.add(cad);
            jppMenu.add(con);
        }else
            if(op == "edit"){
                jppMenu.add(edit);
                jppMenu.add(del);
            }
        
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
        
        textId = new JTextField();
        textNome = new JTextField();
        textDataLancamento = new JXDatePicker();
        jlNome = new JLabel("NOME:");
        jlData = new JLabel("DATA LANÇAMENTO:");

        
        textNome.setPreferredSize(new Dimension(200,30));
        textDataLancamento.setPreferredSize(new Dimension(200,30));
        form.add(jlNome );
        form.add(textNome);
        form.add(jlData);
        form.add(textDataLancamento);
        

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
    
    public void setDados(Livro livro){
            
            textId.setText(Integer.toString(livro.getId()));
            textNome.setText(livro.getNome());
            textDataLancamento.setDate(livro.getDataLancamento());
       
        }
        

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()== cad){
            
            LivroController lc = new LivroController();

            livros.setNome(textNome.getText());
            livros.setDataLancamento(textDataLancamento.getDate());
                    
            lc.Cadastar(livros);
        }
        
        if(e.getSource()== edit){
            
            LivroController lc = new LivroController();
            
            livros.setId(Integer.parseInt(textId.getText()));
            livros.setNome(textNome.getText());
            livros.setDataLancamento(textDataLancamento.getDate());
         
            lc.edita(livros);
        }
        
        if(e.getSource()== del){
            
            LivroController lc = new LivroController();
            
            livros.setId(Integer.parseInt(textId.getText()));
            livros.setNome(textNome.getText());
            livros.setDataCadastro(textDataLancamento.getDate());
                    
            lc.excluir(livros);
        }
        if(e.getSource()== con){
            
            Home hm = new Home();
            LivrosList ll = new LivrosList();
            hm.addTab(ll, "Consulta livros");
    
            
        }
    }
    
    
    
}
