
package br.com.biblioteca.bd;

import br.com.biblioteca.main.BlibiotecaMain;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexao {

    public static Connection conecta() {
        String prefixo = "jdbc:mysql://";
        String host = "localhost/";
        String banco = "biblioteca";
        String user = "root";
        String pass = "root";
        
   
        
        String url = prefixo + host + banco;
        Connection conexao;
                
        try {
            return DriverManager.getConnection(url, user, pass);
            
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null,"erro ao conectar ao banco de dados!");
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
   }
