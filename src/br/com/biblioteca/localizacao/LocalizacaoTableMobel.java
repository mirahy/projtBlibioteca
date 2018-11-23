/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.biblioteca.localizacao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author IFMS
 */
public class LocalizacaoTableMobel extends AbstractTableModel{
    
    private List<String> cabecalho;
    private List<Localizacao> listaLocalizacao;

    public LocalizacaoTableMobel() {
        
        cabecalho = new ArrayList<>();
        listaLocalizacao = new ArrayList<>();
        
        cabecalho.add("Id");
        cabecalho.add("Estante");
        cabecalho.add("Prateleira");
        cabecalho.add("Coluna");
    }

    

    @Override
    public String getColumnName(int column) {
        return cabecalho.get(column);
    }
    

    @Override
    public int getRowCount() {
        return listaLocalizacao.size();
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
                return listaLocalizacao.get(rowIndex).getId();
            case 1:
                //retornar estante
                return listaLocalizacao.get(rowIndex).getEstante();
            case 2:
                //retornar preteleira
                return listaLocalizacao.get(rowIndex).getPrateleira();
            case 3:
                //retornar coluna
                return listaLocalizacao.get(rowIndex).getColuna();
                default:
                    return null;
        }

    }

    public List<Localizacao> getListaLocalizacao() {
        return listaLocalizacao;
    }

    public void setListaLocalizacao(List<Localizacao> listaLocalizacao) {
        this.listaLocalizacao = listaLocalizacao;
    }

    
    
}
