/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.biblioteca.app.controller;

import br.com.biblioteca.app.model.Livro;
import br.com.biblioteca.app.service.LivroService;
import br.com.biblioteca.views.Home;
import br.com.biblioteca.views.LivrosCad;

/**
 *
 * @author mirahyfonseca-cms
 */
public class LivroController {
    
    LivroService ls = new LivroService();
    Livro livro = new Livro();
    LivrosCad livroCad ;
    Home hm;

    public LivroController() {
        
    }
    
     public void Cadastar(Livro livro ){

        ls.cadastrar(livro);
        
    }
    
    public void consultaId(String id ){
       hm = new Home();
       livroCad= new LivrosCad("edit");
       livro = ls.consultarProId(id);
       livroCad.setDados(livro);
       hm.addTab(livroCad, "Livro");
        
    }
    
    public void edita(Livro livro ){
        
        ls.editar(livro);
        
    }
    
    public void excluir(Livro livro ){
        
        ls.excluir(livro);
        
    }
    
}
