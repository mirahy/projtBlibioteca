
package br.com.biblioteca.views;

import br.com.biblioteca.app.controller.UsuarioController;
import br.com.biblioteca.bd.Conexao;
import br.com.biblioteca.app.model.Usuario;
import br.com.biblioteca.app.model.UsuarioTableMobel;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class UserList  extends JPanel implements ActionListener{
    
    private JMenuBar jppMenu;
    private JPanel painelInterno;
    private JTable tabelaUser;
    JScrollPane barraRolagem;
    private Connection conn;
    private List<Usuario> Usuarios;

    public UserList() {
        
        setLayout(new GridBagLayout());
       
       jppMenu = new JMenuBar();
       
      
        jppMenu.setLayout(new FlowLayout(FlowLayout.LEFT));
        posicionarElemento(0, 0, 1, 1, 1, 1, jppMenu);
        
            
            Usuarios = new ArrayList<>();
            tabelaUser = new JTable();
            conn = Conexao.conecta();
            tabelaUser.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            tabelaUser.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        
        try {
            if(conn == null || conn.isClosed()){
                JOptionPane.showMessageDialog(null,"Erro ao conectar ao banco de dados!");
                System.exit(-1);
            }
            
                String sql = "SELECT idtbUsuario, nome, perfil, data_cad from tbUsuario";

                Statement stmt = conn.createStatement();
                
                //select
                ResultSet res = stmt.executeQuery(sql);
                

                
                while(res.next()){                    
                    
                    Usuario u = new Usuario();
                    u.setId(res.getInt("idtbUsuario"));
                    u.setNome(res.getString("nome"));
                    u.setPerfil(res.getString("perfil"));
                    Calendar c2 = Calendar.getInstance();
                    c2.setTime(res.getTimestamp("data_cad"));
                    u.setDataCad(c2);
                    
                    
                    Usuarios.add(u);
                }
                
                
                UsuarioTableMobel modelo = new UsuarioTableMobel();
                modelo.setListaUsuarios(Usuarios);
                
                tabelaUser.setModel(modelo);
                
                stmt.close();
                conn.close();
                
        } catch (SQLException ex) {
            Logger.getLogger(UserList.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tabelaUser.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2) {
                    int row = tabelaUser.getSelectedRow();
                    String id = String.valueOf(tabelaUser.getValueAt(row, 0));
                    UsuarioController uc = new UsuarioController();
                    uc.consultaId(id);

                }
            }
            
        });
        
        
        barraRolagem = new JScrollPane(tabelaUser);
      
        
   
        painelInterno = new JPanel();
        painelInterno.setLayout(new GridLayout(1, 1));;
        painelInterno.setBackground(Color.red);
        this.painelInterno.add(barraRolagem);
        posicionarElemento(0, 1, 1, 1, 1, 150, painelInterno);
        
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
