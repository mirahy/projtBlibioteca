
package br.com.biblioteca.views;

import br.com.biblioteca.app.controller.LivroController;
import br.com.biblioteca.bd.Conexao;
import br.com.biblioteca.app.model.LivroTableMobel;
import br.com.biblioteca.app.model.Livro;
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


public class LivrosList extends JPanel implements ActionListener{
    
    private JMenuBar jppMenu;
    private JPanel painelInterno;
    private JTable tabelaLivros;
    JScrollPane barraRolagem;
    private Connection conn;
    private List<Livro> livros;

    public LivrosList( ) {
        
        setLayout(new GridBagLayout());
       
       jppMenu = new JMenuBar();
       
       
        jppMenu.setLayout(new FlowLayout(FlowLayout.LEFT));
        posicionarElemento(0, 0, 1, 1, 1, 1, jppMenu);
        
        livros = new ArrayList<>();
        tabelaLivros = new JTable();
        conn = Conexao.conecta();
        tabelaLivros.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabelaLivros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        
         try {
            if(conn == null || conn.isClosed()){
                JOptionPane.showMessageDialog(null,"Erro ao conectar ao banco de dados!");
                System.exit(-1);
            }
               

                String sql = "SELECT idtbLivro, nome, data_lancamento, data_cad from tbLivro";
                

                Statement stmt = conn.createStatement();
                
                //select
                ResultSet res = stmt.executeQuery(sql);
                

                
                while(res.next()){

                    Livro l = new Livro();
                    l.setId(res.getInt("idtbLivro"));
                    l.setNome(res.getString("nome"));
                    //Calendar c = Calendar.getInstance();
                    //c.setTime(res.getDate("data_lancamento"));
                    l.setDataLancamento(res.getDate("data_lancamento"));
                    //Calendar c1 = Calendar.getInstance();
                    //c1.setTime(res.getTimestamp("data_cad"));
                    l.setDataCadastro(res.getTimestamp("data_cad"));
                    
                    livros.add(l);
                }
                
                LivroTableMobel modelo = new LivroTableMobel();
                modelo.setListaLivros(livros);
                
                tabelaLivros.setModel(modelo);
               
                
                stmt.close();
                conn.close();
                
        } catch (SQLException ex) {
            Logger.getLogger(LivrosList.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tabelaLivros.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2) {
                    int row = tabelaLivros.getSelectedRow();
                    String id = String.valueOf(tabelaLivros.getValueAt(row, 0));
                    LivroController lc = new LivroController();
                    lc.consultaId(id);
                }
            }
            
        });
        
        barraRolagem = new JScrollPane(tabelaLivros);
        
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
