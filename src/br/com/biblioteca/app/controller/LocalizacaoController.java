/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.biblioteca.app.controller;

import br.com.biblioteca.app.model.Localizacao;
import br.com.biblioteca.app.service.LivroService;
import br.com.biblioteca.app.service.LocalizacaoService;
import br.com.biblioteca.views.Home;
import br.com.biblioteca.views.LocalizaCad;

/**
 *
 * @author mirahyfonseca-cms
 */
public class LocalizacaoController {
    
    LocalizacaoService ls = new LocalizacaoService();
    Localizacao localizacao = new Localizacao();
    LocalizaCad localizaCad ;
    Home hm;

    public LocalizacaoController() {
    }
    
    
     public void cadastar(Localizacao localizacao ){

        ls.cadastrar(localizacao);
        
    }
    
    public void consultaId(String id ){
       hm = new Home();
       localizaCad = new LocalizaCad("edit");
       localizacao = ls.consultarProId(id);
       localizaCad.setDados(localizacao);
       hm.addTab(localizaCad, "Localizacao");
        
    }
    
    public void edita(Localizacao localizacao ){
        
        ls.editar(localizacao);
        
    }
    
    public void excluir(Localizacao localizacao){
        
        ls.excluir(localizacao);
        
    }
    
}
