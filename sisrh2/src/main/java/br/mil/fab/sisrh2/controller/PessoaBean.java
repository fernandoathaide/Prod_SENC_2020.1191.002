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
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "pessoaController")
@ViewScoped
public class PessoaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private PessoaModel pessoa;
    
    @Inject //Injeção de Dependência usando o CDI
    private PessoaService pessoasService;
    
    private List<PessoaModel> listaPessoas;

    public PessoaBean() {
    }

    //Metodos de controle da tabela Pessoa
    //Metodo para Salva Uma pessoa No banco
    public void salvarPessoa() {
        pessoasService.salvar(pessoa);
    }
    //Metodo para trazer todo do banco Tabela Pessoa
    public void todasPessoas() {
        listaPessoas = pessoasService.getAllPessoas();
        
    }

    //Injeção de dependência modo Tradicional
    public PessoaModel getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaModel pessoa) {
        this.pessoa = pessoa;
    }

    public List<PessoaModel> getListaPessoas() {
        return listaPessoas;
    }
}
