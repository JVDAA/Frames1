/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsfinicio.controller;

import br.com.jsfinicio.model.AreaModel;
import br.com.jsfinicio.repository.AreaRepository;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author JVDAA
 */
@ManagedBean
@SessionScoped
public class AreaController {

    private AreaModel areaModel;
    private AreaRepository areaRepository;
    private List<AreaModel> listaDeAreas;

    public AreaController() {
        
        this.areaModel = new AreaModel();
        this.areaRepository = new AreaRepository();
        this.listaDeAreas = new ArrayList<>();
    }

    public void salvar() {
        
        try {
            this.areaRepository.salvar(this.areaModel);
            this.areaModel = new AreaModel();
        } 
        catch (Exception e) {
        }
    }

    public void buscarTodos() {
        this.listaDeAreas = this.areaRepository.buscarTodos();
    }

    public void buscarPorNome() {
        this.listaDeAreas = this.areaRepository.buscarPorNome(this.areaModel.getDescricao());
    }

    public void excluirPorID(int idArea) {
        this.areaRepository.excluirPorID(idArea);
    }

    public String editarPorID(int idArea) throws IOException {
        this.areaModel = this.areaRepository.buscarPorID(idArea);

        return "editarArea.xhtml?faces-redirect=true";
    }
    
    public AreaModel getAreaModel() {
        return areaModel;
    }

    public void setAreaModel(AreaModel areaModel) {
        this.areaModel = areaModel;
    }

    public AreaRepository getAreaRepository() {
        return areaRepository;
    }

    public void setAreaRepository(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    public List<AreaModel> getListaDeAreas() {
        return listaDeAreas;
    }

    public void setListaDeAreas(List<AreaModel> listaDeAreas) {
        this.listaDeAreas = listaDeAreas;
    }
}
