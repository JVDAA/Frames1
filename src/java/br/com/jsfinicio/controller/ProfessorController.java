/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsfinicio.controller;

import br.com.jsfinicio.model.ProfessorModel;
import br.com.jsfinicio.model.EstadoModel;
import br.com.jsfinicio.model.CidadeModel;
import br.com.jsfinicio.repository.ProfessorRepository;
import br.com.jsfinicio.repository.EstadoRepository;
import br.com.jsfinicio.repository.CidadeRepository;
import br.com.jsfinicio.util.Conexao;
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
public class ProfessorController extends Conexao{

    private ProfessorModel professorModel;
    private EstadoModel estadoModel;
    private EstadoRepository estadoRepository;
    private CidadeModel cidadeModel;
    private CidadeRepository cidadeRepository;
    private ProfessorRepository professorRepository;
    private List<ProfessorModel> listaDeProfessores;

    public ProfessorController() {
        
        this.estadoRepository = new EstadoRepository();
        this.cidadeRepository = new CidadeRepository();
        this.professorModel = new ProfessorModel();
        this.estadoModel = new EstadoModel();
        this.cidadeModel = new CidadeModel();
        this.professorRepository = new ProfessorRepository();
        this.listaDeProfessores = new ArrayList<>();
    }

    public void salvar() {
        
        try {
            this.estadoModel = this.estadoRepository.buscarPorID(this.estadoModel.getIdEstado());
            this.cidadeModel = this.cidadeRepository.buscarPorID(this.cidadeModel.getIdCidade());
            this.professorModel.setEstado(this.estadoModel);
            this.professorModel.setCidade(this.cidadeModel);
            this.professorRepository.salvar(this.professorModel);
            this.professorModel = new ProfessorModel();
        } 
        catch (Exception e) {
        }
    }

    public void buscarTodos() {
        this.listaDeProfessores = this.professorRepository.buscarTodos();
    }

    public void buscarPorNome() {
        this.listaDeProfessores = this.professorRepository.buscarPorNome(this.professorModel.getNome());
    }

    public void excluirPorID(long idpessoa) {
        this.professorRepository.excluirPorID(idpessoa);
    }

    public String editarPorID(long idpessoa) throws IOException {
        this.professorModel = this.professorRepository.buscarPorID(idpessoa);

        return "editarProfessor.xhtml?faces-redirect=true";
    }

    public CidadeModel getCidadeModel() {
        return cidadeModel;
    }

    public void setCidadeModel(CidadeModel cidadeModel) {
        this.cidadeModel = cidadeModel;
    }

    public CidadeRepository getCidadeRepository() {
        return cidadeRepository;
    }

    public void setCidadeRepository(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    public EstadoRepository getEstadoRepository() {
        return estadoRepository;
    }

    public void setEstadoRepository(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    public EstadoModel getEstadoModel() {
        return estadoModel;
    }

    public void setEstadoModel(EstadoModel estadoModel) {
        this.estadoModel = estadoModel;
    }

    public ProfessorModel getProfessorModel() {
        return professorModel;
    }

    public void setProfessorModel(ProfessorModel professorModel) {
        this.professorModel = professorModel;
    }

    public ProfessorRepository getProfessorRepository() {
        return professorRepository;
    }

    public void setProfessorRepository(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<ProfessorModel> getListaDeProfessores() {
        return listaDeProfessores;
    }

    public void setListaDeProfessores(List<ProfessorModel> listaDeProfessores) {
        this.listaDeProfessores = listaDeProfessores;
    }
}
