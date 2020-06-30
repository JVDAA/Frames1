/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsfinicio.repository;

import br.com.jsfinicio.model.ProfessorModel;
import br.com.jsfinicio.util.Conexao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JVDAA
 */
public class ProfessorRepository extends Conexao {
    
    public void salvar(ProfessorModel professorModel){
        super.inicializa();
        super.getSess().saveOrUpdate(professorModel);
        super.executar();
    }
    
    public List<ProfessorModel> buscarTodos(){
        List<ProfessorModel> listaDeProfessores = new ArrayList<>();
        super.inicializa();
        listaDeProfessores = super.getSess().createQuery("from ProfessorModel").list();
        super.executar();
        return listaDeProfessores;
    }
    
    public List<ProfessorModel> buscarPorNome(String nome){
        List<ProfessorModel> listaDeProfessores = new ArrayList<>();
        super.inicializa();
        listaDeProfessores = super.getSess().createQuery("from ProfessorModel where UPPER(nome) like '%" + nome.toUpperCase() + "%'").list();
        super.executar();
        return listaDeProfessores;
    }
   
     public ProfessorModel buscarPorID(long idPessoa){
        ProfessorModel professor = new ProfessorModel();
        super.inicializa();
        professor = (ProfessorModel) super.getSess().get(ProfessorModel.class, idPessoa);
        super.executar();
        return professor;
    }
    
    public void excluirPorID(long idPessoa){      
        super.inicializa();
        ProfessorModel professor = (ProfessorModel) super.getSess().get(ProfessorModel.class, idPessoa);
        super.getSess().delete(professor);
        super.executar();
    }
}
