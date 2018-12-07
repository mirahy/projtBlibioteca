/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.biblioteca.app.service;

import br.com.biblioteca.app.model.Usuario;
import br.com.biblioteca.bd.Conexao;
import br.com.biblioteca.views.UserCad;
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

/**
 *
 * @author mirahyfonseca-cms
 */
public class UsuarioService {
    
    private Connection conn;

    public UsuarioService() {
        conn = Conexao.conecta();
    }

    public void cadastrar (Usuario usuario){
        
        
        
        try {
            if(conn == null || conn.isClosed()){
                JOptionPane.showMessageDialog(null,"erro ao conectar ao banco de dados!");
                
            }
            
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date aux = Date.from(Instant.now());
                String nome = "'"+usuario.getNome()+"'";
                String perfil = ",'"+usuario.getPerfil()+"'";
                //String perfil = ",'"+getCbPerfil().getSelectedItem().toString()+"'";
                String dataCad = ",'"+sdf.format(aux)+"'";

                String sql = "INSERT INTO tbUsuario (nome, perfil, data_cad) VALUES "
                        + "("+nome+perfil+dataCad+")";
                //JOptionPane.showMessageDialog(null,"sql: "+sql);

                Statement stmt = conn.createStatement();
                
                Integer retorno = stmt.executeUpdate(sql);
                
                if(retorno != 0){
                    JOptionPane.showMessageDialog(null,"Usuário cadastrado com sucesso!","CADASTRO",JOptionPane.INFORMATION_MESSAGE);
                    
                }else{
                    JOptionPane.showMessageDialog(null,"Não foi possivel cadastar!","CADASTRO",JOptionPane.ERROR_MESSAGE);
                }
                
                
                
                stmt.close();
                conn.close();
                
                //listagemUser();
                
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editar (Usuario usuario){
        
        try {
                if(conn == null || conn.isClosed()){
                    JOptionPane.showMessageDialog(null,"erro ao conectar ao banco de dados!");
                    
                }


                    String nome = "'"+usuario.getNome()+"'";    
                    String perfil = "'"+usuario.getPerfil()+"'";


                    String sql = "UPDATE  tbUsuario SET nome = "+ nome +", perfil = "+ perfil + " "
                            + "WHERE  idtbUsuario = " + usuario.getId();

                    Statement stmt = conn.createStatement();

                    Integer retorno = stmt.executeUpdate(sql);

                        if(retorno != 0){
                            JOptionPane.showMessageDialog(null,"Usuário "+ nome +" Atualizado com "
                                    + "sucesso!","CADASTRO",JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(null,"Não foi possivel Atualizar!"
                                    + "","CADASTRO",JOptionPane.ERROR_MESSAGE);
                        }

                    stmt.close();
                    conn.close();
                    
                    //listagemUser();
                
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioService.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
    public void excluir (Usuario usuario){
        
        int resp = JOptionPane.showConfirmDialog(null, "Deseja excluir o usuário " + usuario.getNome() + "?");
        
        if(resp == JOptionPane.YES_OPTION){

            try {
                if(conn == null || conn.isClosed()){
                    JOptionPane.showMessageDialog(null,"erro ao conectar ao banco de dados!");
                    
                }

                    String sql = "DELETE FROM  tbUsuario  WHERE  idtbUsuario = " + usuario.getId();                   

                    Statement stmt = conn.createStatement();

                    Integer retorno = stmt.executeUpdate(sql);

                        if(retorno != 0){
                            JOptionPane.showMessageDialog(null,"Usuario "+ usuario.getNome() +" excluido com sucesso!","CADASTRO",JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(null,"Não foi possível excluir!","CADASTRO",JOptionPane.ERROR_MESSAGE);
                        }

                    stmt.close();
                    conn.close();
                    
                    //listagemUser();
                
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioService.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    }
            
    public void consultar (Usuario usuario){
        
    }
                    
    public Usuario consultarProId (String id){
        
        Usuario usuario = new Usuario();

    
    try {
            if(conn == null || conn.isClosed()){
                JOptionPane.showMessageDialog(null,"Erro ao conectar ao banco de dados!");
                
            }
                Integer cond = Integer.parseInt(id);

                String sql = "SELECT idtbUsuario, nome, perfil, data_cad from tbUsuario where idtbUsuario = '" + cond + "'";
        
        try ( 
                Statement stmt = conn.createStatement()) {
                //select
                ResultSet res = stmt.executeQuery(sql);
            
                    while(res.next()){
                        
                    
                    usuario.setId(res.getInt("idtbUsuario"));
                    usuario.setPerfil(res.getString("perfil"));
                    usuario.setNome(res.getString("nome"));

                    
                }
                stmt.close();
            }
        
                conn.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(UserCad.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        return usuario;
            
        
    }
    
}
