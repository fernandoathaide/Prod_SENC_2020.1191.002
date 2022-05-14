/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.mil.fab.sisrh2.controller;

//import javax.enterprise.context.RequestScoped;
//import javax.inject.Named;

/**
 *
 * @author fernando
 */


import br.mil.fab.sisrh2.model.PessoaModel;
import br.mil.fab.sisrh2.service.PessoaService;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "pessoaController")
@RequestScoped
public class PessoaBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private PessoaModel pessoa;
    
    @Inject //Injeção de Dependência usando o CDI
    private PessoaService pessoasService;
    
    public PessoaBean(){
        pessoa = new PessoaModel();
    }
    
    //Metodo para Salva Uma pessoa No banco
    public void salvarPessoa(){
        pessoasService.salvar(pessoa);
    } 

    //Injeção de dependência modo Tradicional
    public PessoaModel getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaModel pessoa) {
        this.pessoa = pessoa;
    }    
    
}
