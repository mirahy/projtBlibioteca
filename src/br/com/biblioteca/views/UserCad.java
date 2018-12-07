
package br.com.biblioteca.views;

import br.com.biblioteca.app.controller.UsuarioController;
import br.com.biblioteca.bd.Conexao;
import br.com.biblioteca.app.model.Usuario;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class UserCad extends JPanel implements ActionListener{
   
    //inicializando variáveis
    private JMenuBar jppMenu;
    private JPanel painelInterno;
    private JPanel form;
    private JTextField textNome;
    private JTextField textId;
    private JComboBox cBoxPerfil;
    private JLabel jlNome;
    private JLabel jlPerfil;
    private Connection conn;
    private Usuario user = new Usuario(); ;
    
        JMenuItem  cad = new JMenuItem("Cadastrar");
        JMenuItem  edit = new JMenuItem("Editar");
        JMenuItem  del = new JMenuItem("Excluir");
        JMenuItem  con = new JMenuItem("Consultar");

    public UserCad( String op ) throws HeadlessException {
        
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
        cBoxPerfil = new JComboBox(new String[] { "Aluno", "Blibiotecario" });
        jlNome = new JLabel("NOME:");
        jlPerfil = new JLabel("PERFIL:");
        jlNome.setText("Nome:");

        
        textNome.setPreferredSize(new Dimension(200,30));
        cBoxPerfil.setPreferredSize(new Dimension(200,30));
        form.add(jlNome );
        form.add(textNome);
        form.add(jlPerfil);
        form.add(cBoxPerfil);
        

        
        
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
            
            UsuarioController uc = new UsuarioController();
            
            user.setNome(textNome.getText());
            user.setPerfil(cBoxPerfil.getSelectedItem().toString());
                    
            uc.cadastar(user);
        }
        
        if(e.getSource()== edit){
            
            UsuarioController uc = new UsuarioController();
            
            user.setId(Integer.parseInt(textId.getText()));
            user.setNome(textNome.getText());
            user.setPerfil(cBoxPerfil.getSelectedItem().toString());
                    
            uc.edita(user);
        }
        
        if(e.getSource()== del){
            
            UsuarioController uc = new UsuarioController();
            
            user.setId(Integer.parseInt(textId.getText()));
            user.setNome(textNome.getText());
            user.setPerfil(cBoxPerfil.getSelectedItem().toString());
                    
            uc.excluir(user);
        }
        if(e.getSource()== con){
            
            Home hm = new Home();
            UserList ul = new UserList();
            hm.addTab(ul, "Consulta usuários");
    
            
        }
    }
    
    
     public void setDados(Usuario usuario){
         
                    textId.setText(Integer.toString(usuario.getId()));
                    textNome.setText(usuario.getNome());
                    cBoxPerfil.getModel().setSelectedItem(usuario.getPerfil());
                    

        }

    public JTextField getTextNome() {
        return textNome;
    }

    public void setTextNome(JTextField textNome) {
        this.textNome = textNome;
    }

    public JComboBox getcBoxPerfil() {
        return cBoxPerfil;
    }

    public void setcBoxPerfil(JComboBox cBoxPerfil) {
        this.cBoxPerfil = cBoxPerfil;
    }


    public JLabel getJlNome() {
        return jlNome;
    }

    public void setJlNome(JLabel jlNome) {
        this.jlNome = jlNome;
    }

    public JLabel getJlPerfil() {
        return jlPerfil;
    }

    public void setJlPerfil(JLabel jlPerfil) {
        this.jlPerfil = jlPerfil;
    }

    public JTextField getTextId() {
        return textId;
    }

    public void setTextId(JTextField textId) {
        this.textId = textId;
    }
    
    
}
