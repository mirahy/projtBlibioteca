/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.biblioteca.app.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author IFMS
 */
public class UsuarioTableMobel extends AbstractTableModel{
    
    private List<String> cabecalho;
    private List<Usuario> listaUsuarios;

    public UsuarioTableMobel() {
        
        cabecalho = new ArrayList<>();
        listaUsuarios = new ArrayList<>();
        
        cabecalho.add("Id");
        cabecalho.add("Nome");
        cabecalho.add("Perfil");
        cabecalho.add("Data Cadastro");
    }

    

    @Override
    public String getColumnName(int column) {
        return cabecalho.get(column);
    }
    

    @Override
    public int getRowCount() {
        return listaUsuarios.size();
    }

    @Override
    public int getColumnCount() {
        return cabecalho.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        switch(columnIndex){
            case 0:
                // retornar id
                return listaUsuarios.get(rowIndex).getId();
            case 1:
                //retornar nome
                return listaUsuarios.get(rowIndex).getNome();
            case 2:
                //retornar perfil
                return listaUsuarios.get(rowIndex).getPerfil();
            case 3:
                //retornar data cadastro
                //Calendar c = listaAlunos.get(rowIndex).getDataNascimento();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                
                return sdf.format(listaUsuarios.get(rowIndex).getDataCad().getTime()) ;
                default:
                    return null;
        }

    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
}
