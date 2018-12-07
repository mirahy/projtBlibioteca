
package br.com.biblioteca.app.service;

import br.com.biblioteca.app.model.Livro;
import br.com.biblioteca.bd.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class LivroService {
    
    private Connection conn;

    public LivroService() {
        conn = Conexao.conecta();
    }
    
    public void cadastrar (Livro livro){
        
        
        
       try {
            if(conn == null || conn.isClosed()){
                JOptionPane.showMessageDialog(null,"erro ao conectar ao banco de dados!");
                
            }
            
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date aux = livro.getDataLancamento();
                Date aux1 = Date.from(Instant.now());
                String nome = "'"+livro.getNome()+"'";    
                String data = ",'"+sdf.format(aux)+"'";
                String datacad = ",'"+sdf1.format(aux1)+"'";

                String sql = "INSERT INTO tbLivro (nome, data_lancamento, data_cad) VALUES "
                        + "("+nome+data+datacad+")";
                

                Statement stmt = conn.createStatement();
                
                Integer retorno = stmt.executeUpdate(sql);
                
                if(retorno != 0){
                    JOptionPane.showMessageDialog(null,"Livro cadastrado com sucesso!","CADASTRO",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null,"Não foi possivel cadastar!","CADASTRO",JOptionPane.ERROR_MESSAGE);
                }
                
                stmt.close();
                conn.close();
                
                
                
        } catch (SQLException ex) {
            Logger.getLogger(LivroService.class.getName()).log(Level.SEVERE, null, ex);
        }
           
       }
    
    public void editar (Livro livro){
        
        try {
            if(conn == null || conn.isClosed()){
                JOptionPane.showMessageDialog(null,"erro ao conectar ao banco de dados!");
                
            }
            
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                Date aux = livro.getDataLancamento();
                String nome = "'"+livro.getNome()+"'";    
                String data = "'"+sdf.format(aux)+"'";
                

                String sql = "UPDATE  tbLivro SET nome = "+ nome +", data_lancamento = "+ data + "WHERE  idtbLivro = " + livro.getId();
                

                Statement stmt = conn.createStatement();
                
                Integer retorno = stmt.executeUpdate(sql);
                
                if(retorno != 0){
                    JOptionPane.showMessageDialog(null,"Livro "+ nome +" Atualizado com sucesso!","CADASTRO",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null,"Não foi possivel Atualizar!","CADASTRO",JOptionPane.ERROR_MESSAGE);
                }
                
                stmt.close();
                conn.close();
                
               
                
        } catch (SQLException ex) {
            Logger.getLogger(LivroService.class.getName()).log(Level.SEVERE, null, ex);
        }
       }

    
    public void excluir (Livro livro){
        
        int resp = JOptionPane.showConfirmDialog(null,"Deseja excluir o livro " + livro.getNome() + "?");
         if(resp == JOptionPane.YES_OPTION){
        
        try {
            if(conn == null || conn.isClosed()){
                JOptionPane.showMessageDialog(null,"erro ao conectar ao banco de dados!");
                
            }
            

                String sql = "DELETE FROM  tbLivro WHERE  idtbLivro = " + livro.getId();
               

                Statement stmt = conn.createStatement();
                
                Integer retorno = stmt.executeUpdate(sql);
                
                if(retorno != 0){
                    JOptionPane.showMessageDialog(null,"Livro "+ livro.getNome() +" excluido com sucesso!","CADASTRO",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null,"NÃ£o foi possivel excluir!","CADASTRO",JOptionPane.ERROR_MESSAGE);
                }
                
                stmt.close();
                conn.close();
                
       ;
                
        } catch (SQLException ex) {
            Logger.getLogger(LivroService.class.getName()).log(Level.SEVERE, null, ex);
        }
         }
    }
            
    public void consultar (Livro livro){
        
    }
                    
    public Livro consultarProId (String id){
        
        Livro livro = new Livro();

    
    try {
            if(conn == null || conn.isClosed()){
                JOptionPane.showMessageDialog(null,"Erro ao conectar ao banco de dados!");
                
            }
                Integer cond = Integer.parseInt(id);

                String sql = "SELECT idtbLivro, nome, data_lancamento, data_cad from tblivro where idtbLivro = '" + cond + "'";
        
        try ( 
                Statement stmt = conn.createStatement()) {
                //select
                ResultSet res = stmt.executeQuery(sql);
            
                    while(res.next()){
                        
                    
                    livro.setId(res.getInt("idtbLivro"));
                    livro.setNome(res.getString("nome"));
                    livro.setDataLancamento(res.getDate("data_lancamento"));

                    
                }
                stmt.close();
            }
        
                conn.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(LivroService.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        return livro;
            
        
    }
    
}
