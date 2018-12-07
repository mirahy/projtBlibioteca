/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.biblioteca.app.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author IFMS
 */
public class LivroTableMobel extends AbstractTableModel{
    
    private List<String> cabecalho;
    private List<Livro> listaLivros;

    public LivroTableMobel() {
        
        cabecalho = new ArrayList<>();
        listaLivros = new ArrayList<>();
        
        cabecalho.add("Id");
        cabecalho.add("Nome");
        cabecalho.add("Data laçamento");
        cabecalho.add("Data cadastro");
    }

    

    @Override
    public String getColumnName(int column) {
        return cabecalho.get(column);
    }
    

    @Override
    public int getRowCount() {
        return listaLivros.size();
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
                return listaLivros.get(rowIndex).getId();
            case 1:
                //retoornar nome
                return listaLivros.get(rowIndex).getNome();
            case 2:
                //retornar data
                //Calendar c = listaAlunos.get(rowIndex).getDataNascimento();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                
                return sdf.format(listaLivros.get(rowIndex).getDataLancamento().getTime()) ;
               case 3:
                //retornar data cadastro
                
                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                
                return sdf1.format(listaLivros.get(rowIndex).getDataCadastro().getTime()) ;
                default:
                    return null;
        }

    }

    public List<Livro> getListaLivros() {
        return listaLivros;
    }

    public void setListaLivros(List<Livro> listaLivros) {
        this.listaLivros = listaLivros;
    }
    
}
