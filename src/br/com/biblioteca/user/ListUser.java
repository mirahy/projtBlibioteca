/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.biblioteca.user;

import br.com.biblioteca.bd.Conexao;
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
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 *
 * @author myrah
 */
public class ListUser  extends JPanel implements ActionListener{
    
    private JMenuBar jppMenu;
    private JPanel painelInterno;
    private JTable tabelaUser;
    JTable tabela;
    JScrollPane barraRolagem;
    private Connection conn;
    private List<Usuario> Usuarios;

    public ListUser() {
        
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
        
//        Object [][] dados = {
//        {"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"},
//        {"João da Silva", "48 8890-3345", "joaosilva@hotmail.com"},
//        {"Pedro Cascaes", "48 9870-5634", "pedrinho@gmail.com"}
//    };
//     
//    String [] colunas = {"Nome", "Telefone", "Email"}; 
//    
//    tabela = new JTable(dados, colunas);
            
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
            Logger.getLogger(ListagemUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tabelaUser.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2) {
                    int row = tabelaUser.getSelectedRow();
                    String id = String.valueOf(tabelaUser.getValueAt(row, 0));
                    CadastroUsuario user = new CadastroUsuario();
                    user.setDados(id);
                    user.setVisible(true);
                    setVisible(false);
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
