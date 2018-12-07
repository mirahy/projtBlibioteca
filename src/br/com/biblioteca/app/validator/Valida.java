/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.biblioteca.app.validator;

import javax.swing.JOptionPane;

/**
 *
 * @author mirahyfonseca-cms
 */
public final class Valida {
    
   public Integer validaNome(String nome){
       
       if(nome.length()<2){
           JOptionPane.showMessageDialog(null, "Digite seu nome!");
           return 0;
       }
       return 1;
           
    }
   
   public Integer validaNomeLivro(String nome){
       
       if(nome.length()<2){
           JOptionPane.showMessageDialog(null, "Digite o nome do livro!");
           return 0;
       }
       return 1;
           
    }
   
   public Integer validaLocalizacao(String nome){
       
       if(nome.length()<3){
           JOptionPane.showMessageDialog(null, "Informe todos os campos!");
           return 0;
       }
       return 1;
           
    }
    
}
