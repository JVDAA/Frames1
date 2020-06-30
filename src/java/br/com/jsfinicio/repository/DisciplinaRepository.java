    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsfinicio.repository;

import br.com.jsfinicio.model.DisciplinaModel;
import br.com.jsfinicio.util.Conexao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JVDAA
 */
public class DisciplinaRepository extends Conexao {
    
    public void salvar(DisciplinaModel disciplinaModel){
        super.inicializa();
        super.getSess().saveOrUpdate(disciplinaModel);
        super.executar();
    }
    
    public List<DisciplinaModel> buscarTodos(){
        List<DisciplinaModel> listaDeDisciplinas = new ArrayList<>();
        super.inicializa();
        listaDeDisciplinas = super.getSess().createQuery("from DisciplinaModel").list();
        super.executar();
        return listaDeDisciplinas;
    }
    
    public List<DisciplinaModel> buscarPorNome(String nome){
        List<DisciplinaModel> listaDeDisciplinas = new ArrayList<>();
        super.inicializa();
        listaDeDisciplinas = super.getSess().createQuery("from DisciplinaModel where UPPER(nome) like '%" + nome.toUpperCase() + "%'").list();
        super.executar();
        return listaDeDisciplinas;
    }
   
     public DisciplinaModel buscarPorID(int idDisciplina){
        DisciplinaModel disciplina = new DisciplinaModel();
        super.inicializa();
        disciplina = (DisciplinaModel) super.getSess().get(DisciplinaModel.class, idDisciplina);
        super.executar();
        return disciplina;
    }
    
    public void excluirPorID(int idDisciplina){
        super.inicializa();
        DisciplinaModel disciplina = (DisciplinaModel) super.getSess().get(DisciplinaModel.class, idDisciplina);
        super.getSess().delete(disciplina);
        super.executar();
    }
}
