
package br.com.biblioteca.views;

import br.com.biblioteca.app.controller.LocalizacaoController;
import br.com.biblioteca.bd.Conexao;
import br.com.biblioteca.app.model.Localizacao;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class LocalizaCad extends JPanel implements ActionListener{
    
    
    //inicializando variáveis
    private JMenuBar jppMenu;
    private JPanel painelInterno;
    private JPanel form;
    private JTextField textEstante;
    private JTextField textPrateleira;
    private JTextField textColuna;
    private JTextField textId;
    private JLabel jlEstante;
    private JLabel jlPrateleira;
    private JLabel jlColuna;
    private Connection conn;
    private Localizacao localizacao = new Localizacao();
    
        JMenuItem  cad = new JMenuItem("Cadastrar");
        JMenuItem  edit = new JMenuItem("Editar");
        JMenuItem  del = new JMenuItem("Excluir");
        JMenuItem  con = new JMenuItem("Consultar");

    public LocalizaCad( String op ) {
        
        
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
        textEstante = new JTextField();
        textPrateleira = new JTextField();
        textColuna = new JTextField();
        jlEstante = new JLabel("ESTANTE: ");
        jlPrateleira = new JLabel("Prateleira: ");
        jlColuna = new JLabel("COLUNA: ");
        
        textEstante.setPreferredSize(new Dimension(200,30));
        textPrateleira.setPreferredSize(new Dimension(200,30));
        textColuna.setPreferredSize(new Dimension(200,30));
        form.add(jlEstante);
        form.add(textEstante);
        form.add(jlPrateleira);
        form.add(textPrateleira);
        form.add(jlColuna);
        form.add(textColuna);
        
        
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
        
        if(e.getSource()== cad){
            
            LocalizacaoController lc = new LocalizacaoController();
            
            localizacao.setColuna(textColuna.getText());
            localizacao.setEstante(textEstante.getText());
            localizacao.setPrateleira(textPrateleira.getText());
                    
            lc.cadastar(localizacao);
        }
        
        if(e.getSource()== edit){
            
            LocalizacaoController lc = new LocalizacaoController();
            
            localizacao.setId(Integer.parseInt(textId.getText()));
            localizacao.setColuna(textColuna.getText());
            localizacao.setEstante(textEstante.getText());
            localizacao.setPrateleira(textPrateleira.getText());
                    
            lc.edita(localizacao);
        }
        
        if(e.getSource()== del){
            
            LocalizacaoController lc = new LocalizacaoController();
            
            localizacao.setId(Integer.parseInt(textId.getText()));
            localizacao.setColuna(textColuna.getText());
            localizacao.setEstante(textEstante.getText());
            localizacao.setPrateleira(textPrateleira.getText());
                    
            lc.excluir(localizacao);
        }
        if(e.getSource()== con){
            
            Home hm = new Home();
            LocalizaList ll = new LocalizaList();
            hm.addTab(ll, "Consulta usuários");
    
            
        }
    }
    
    
    public void setDados(Localizacao localizacao){
            
            textId.setText(Integer.toString(localizacao.getId()));
            textColuna.setText(localizacao.getColuna());
            textEstante.setText(localizacao.getEstante());
            textPrateleira.setText(localizacao.getPrateleira());
            
        }

    
    
}
