/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsfinicio.repository;

import br.com.jsfinicio.model.AreaModel;
import br.com.jsfinicio.util.Conexao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JVDAA
 */
public class AreaRepository extends Conexao {
    
    public void salvar(AreaModel areaModel){
        super.inicializa();
        super.getSess().saveOrUpdate(areaModel);
        super.executar();
    }
    
    public List<AreaModel> buscarTodos(){
        List<AreaModel> listaDeAreas = new ArrayList<>();
        super.inicializa();
        listaDeAreas = super.getSess().createQuery("from AreaModel").list();
        super.executar();
        return listaDeAreas;
    }
    
    public List<AreaModel> buscarPorNome(String descricao){
        List<AreaModel> listaDeAreas = new ArrayList<>();
        super.inicializa();
        listaDeAreas = super.getSess().createQuery("from AreaModel where UPPER(descricao) like '%" + descricao.toUpperCase() + "%'").list();
        super.executar();
        return listaDeAreas;
    }
   
     public AreaModel buscarPorID(int idArea){
        AreaModel area = new AreaModel();
        super.inicializa();
        area = (AreaModel) super.getSess().get(AreaModel.class, idArea);
        super.executar();
        return area;
    }
    
    public void excluirPorID(int idArea){
        super.inicializa();
        AreaModel area = (AreaModel) super.getSess().get(AreaModel.class, idArea);
        super.getSess().delete(area);
        super.executar();
    }
    
}
