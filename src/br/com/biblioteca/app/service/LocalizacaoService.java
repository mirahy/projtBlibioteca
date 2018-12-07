
package br.com.biblioteca.app.service;

import br.com.biblioteca.app.model.Localizacao;
import br.com.biblioteca.bd.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LocalizacaoService {
    
    private Connection conn;

    public LocalizacaoService() {
        
        conn = Conexao.conecta();
        
    }
    
    public void cadastrar (Localizacao localizacao){
        

       try {
            if(conn == null || conn.isClosed()){
                JOptionPane.showMessageDialog(null,"erro ao conectar ao banco de dados!");
                
            }
            
                
                String estante = "'"+localizacao.getEstante()+"'";    
                String prateleira = ",'"+localizacao.getPrateleira()+"'";
                String coluna = ",'"+localizacao.getColuna()+"'";

                String sql = "INSERT INTO tblocalizacao (estante, prateleira, coluna) VALUES "
                        + "("+estante+prateleira+coluna+")";
                

                Statement stmt = conn.createStatement();
                
                Integer retorno = stmt.executeUpdate(sql);
                
                if(retorno != 0){
                    JOptionPane.showMessageDialog(null,"Localização cadastrada com sucesso!","CADASTRO",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null,"Não foi possivel cadastar!","CADASTRO",JOptionPane.ERROR_MESSAGE);
                }
                
                stmt.close();
                conn.close();
                
                
                
        } catch (SQLException ex) {
            Logger.getLogger(LocalizacaoService.class.getName()).log(Level.SEVERE, null, ex);
        }
           
       }
    
    public void editar (Localizacao localizacao){
        
        try {
            if(conn == null || conn.isClosed()){
                JOptionPane.showMessageDialog(null,"erro ao conectar ao banco de dados!");
                
            }
            
                
                String estante = "'"+localizacao.getEstante()+"'";    
                String prateleira = "'"+localizacao.getPrateleira()+"'";
                String coluna = "'"+localizacao.getColuna()+"'";
                

                String sql = "UPDATE  tbLocalizacao SET estante = "+ estante +", "
                        + "prateleira = "+ prateleira + ",coluna = "+ coluna + ""
                        + "WHERE  idtbLocalizacao = " + localizacao.getId();
                JOptionPane.showMessageDialog(null, sql);

                Statement stmt = conn.createStatement();
                
                Integer retorno = stmt.executeUpdate(sql);
                
                if(retorno != 0){
                    JOptionPane.showMessageDialog(null,"localização atualizada com sucesso!","CADASTRO",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null,"Não foi possivel Atualizar!","CADASTRO",JOptionPane.ERROR_MESSAGE);
                }
                
                stmt.close();
                conn.close();
                
               
                
        } catch (SQLException ex) {
            Logger.getLogger(LivroService.class.getName()).log(Level.SEVERE, null, ex);
        }
       }

    
    public void excluir (Localizacao localizacao){
        
        int resp = JOptionPane.showConfirmDialog(null,"Deseja excluir a localização da Prateleira: "+ localizacao.getPrateleira()+"?");
         if(resp == JOptionPane.YES_OPTION){
        
        try {
            if(conn == null || conn.isClosed()){
                JOptionPane.showMessageDialog(null,"erro ao conectar ao banco de dados!");
                
            }
            

                String sql = "DELETE FROM  tbLocalizacao WHERE  idtbLocalizacao = " + localizacao.getId();
               

                Statement stmt = conn.createStatement();
                
                Integer retorno = stmt.executeUpdate(sql);
                
                if(retorno != 0){
                    JOptionPane.showMessageDialog(null,"Localização excluida com sucesso!","CADASTRO",JOptionPane.INFORMATION_MESSAGE);
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
            
    public void consultar (Localizacao localizacao){
        
    }
                    
    public Localizacao consultarProId (String id){
        
        Localizacao localizacao = new Localizacao();

    
    try {
            if(conn == null || conn.isClosed()){
                JOptionPane.showMessageDialog(null,"Erro ao conectar ao banco de dados!");
                
            }
                Integer cond = Integer.parseInt(id);

                String sql = "SELECT idtbLocalizacao, estante, prateleira, coluna from tblocalizacao where"
                        + " idtbLocalizacao = '" + cond + "'";
        
        try ( 
                Statement stmt = conn.createStatement()) {
                //select
                ResultSet res = stmt.executeQuery(sql);
            
                    while(res.next()){
                        
                    
                    localizacao.setId(res.getInt("idtbLocalizacao"));
                    localizacao.setColuna(res.getString("coluna"));
                    localizacao.setEstante(res.getString("estante"));
                    localizacao.setPrateleira(res.getString("prateleira"));

                    
                }
                stmt.close();
            }
        
                conn.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(LivroService.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        return localizacao;
            
        
    }
    
    
}
