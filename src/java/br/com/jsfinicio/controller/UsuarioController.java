/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsfinicio.controller;

import br.com.jsfinicio.model.PessoaModel;
import br.com.jsfinicio.repository.UsuarioRepository;
import br.com.jsfinicio.util.Usuario;
import java.io.IOException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author JVDAA
 */
@ManagedBean
@ViewScoped
public class UsuarioController {
    
    private Usuario usuario;
    private UsuarioRepository usuarioRepository;
    private String msg;

    public UsuarioController() {
        
        this.usuario = new Usuario();
        this.usuarioRepository = new UsuarioRepository();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public void login() throws IOException {
        
        List<PessoaModel> listaDePessoas = this.usuarioRepository.buscar(this.usuario.getLogin());
        if (listaDePessoas == null || listaDePessoas.isEmpty()) {
            //avisem que não encontraram ninguém com o login x
            msg = "Nenhum usuário possui este login!";
        } else {
            //pego a posição 0, pois só teremos um usuário com o login inserido
            //vocês deverão garantir que não teremos login´s iguais no banco de dados
            if (listaDePessoas.get(0).getSenha().equals(this.usuario.getSenha())) {
                //como o login e senha estão corretos posso então salvar o usuário como logado com sucesso
                //devem avisar que foi logado com sucesso !!
                usuario.setNome(listaDePessoas.get(0).getNome());
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("currentUser", this.usuario);//usuario.getLogin());
                FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
                msg = "Logado com sucesso!";
            }else{
                //Avisem que apesar do login estar correto a senha não está.
                msg = "A senha não corresponde a este login!";
            }
        }
    }
    
    public void logout() throws IOException {
        
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("currentUser");
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }    

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioRepository getUsuarioRepository() {
        return usuarioRepository;
    }

    public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
}
