package br.com.jsfinicio.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author JVDAA
 */
@Entity
@Table(name = "estado")
public class EstadoModel implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEstado;

    @Column(length = 75, nullable = false)
    private String nome;

    @Column(length = 5, nullable = false)
    private String uf;

    @OneToMany(mappedBy = "estadoOrigem", fetch = FetchType.LAZY)
    @Cascade(CascadeType.SAVE_UPDATE)
    private List<PessoaModel> listaDePessoas;
    
    @OneToMany(mappedBy = "estado", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private List<CidadeModel> listaDeCidades;

    public List<CidadeModel> getListaDeCidades() {
        return listaDeCidades;
    }

    public void setListaDeCidades(List<CidadeModel> listaDeCidades) {
        this.listaDeCidades = listaDeCidades;
    }

    public List<PessoaModel> getListaDePessoas() {
        return listaDePessoas;
    }

    public void setListaDePessoas(List<PessoaModel> listaDePessoas) {
        this.listaDePessoas = listaDePessoas;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
