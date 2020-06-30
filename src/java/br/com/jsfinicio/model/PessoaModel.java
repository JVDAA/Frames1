/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsfinicio.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author JVDAA
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pessoa")
public abstract class PessoaModel implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idpessoa;
    
    @Column(nullable = false, length = 100)
    private String nome;
    
    @Column(nullable = false, length = 100)
    private String email;
    
    @Column(nullable = false)
    private int idade;
    
    @Column(nullable = false, length = 11)
    private long cpf;
    
    @Column(nullable = false, length = 20)
    private String rg;
    
    @Column(nullable = true, length = 20)
    private String login;
    
    @Column(nullable = true, length = 10)
    private String senha;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idEstado", insertable=true, updatable=true)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE)
    private EstadoModel estadoOrigem;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idCidade", insertable=true, updatable=true)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE)
    private CidadeModel cidadeOrigem;

    public CidadeModel getCidadeOrigem() {
        return cidadeOrigem;
    }

    public void setCidadeOrigem(CidadeModel cidadeOrigem) {
        this.cidadeOrigem = cidadeOrigem;
    }
    
    public CidadeModel getCidade() {
        return cidadeOrigem;
    }
    
     public void setCidade(CidadeModel cidadeOrigem) {
        this.cidadeOrigem = cidadeOrigem;
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public EstadoModel getEstadoOrigem() {
        return estadoOrigem;
    }

    public void setEstadoOrigem(EstadoModel estadoOrigem) {
        this.estadoOrigem = estadoOrigem;
    }

    public EstadoModel getEstado() {
        return estadoOrigem;
    }

    public void setEstado(EstadoModel estadoOrigem) {
        this.estadoOrigem = estadoOrigem;
    }
    
    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public long getIdpessoa() {
        return idpessoa;
    }

    public void setIdpessoa(long idpessoa) {
        this.idpessoa = idpessoa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
