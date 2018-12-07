
package br.com.biblioteca.app.controller;

import br.com.biblioteca.app.model.Usuario;
import br.com.biblioteca.app.service.UsuarioService;
import br.com.biblioteca.views.Home;
import br.com.biblioteca.views.UserCad;


public class UsuarioController {
    
    UsuarioService us = new UsuarioService();
    Usuario usuario = new Usuario();
    UserCad userCad ;
    Home hm;
    
    public UsuarioController() {
        
    }
    
    
    public void cadastar(Usuario usuario ){

        us.cadastrar(usuario);
        
    }
    
    public void consultaId(String id ){
       hm = new Home();
       userCad = new UserCad("edit");
       usuario = us.consultarProId(id);
       userCad.setDados(usuario);
       hm.addTab(userCad, "Usuario");
        
    }
    
    public void edita(Usuario usuario ){
        
        us.editar(usuario);
        
    }
    
    public void excluir(Usuario usuario ){
        
        us.excluir(usuario);
        
    }
}
