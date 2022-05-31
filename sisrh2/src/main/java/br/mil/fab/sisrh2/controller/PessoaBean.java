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
import br.mil.fab.sisrh2.repository.PessoasRepository;
import br.mil.fab.sisrh2.service.PessoaService;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import br.mil.fab.sisrh2.util.FacesMessages;

@Named(value = "pessoaController")
@ViewScoped
public class PessoaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private PessoaModel pessoa;
    
    @Inject //Injeção de Dependência usando o CDI
    private PessoaService pessoasService;
    
    @Inject
    private FacesMessages messages;
    
    @Inject
    private PessoasRepository pessoasRepository;
    
    private List<PessoaModel> listaPessoas;
    
    private String termoPesquisa;

    public PessoaBean() {
    }

    //Metodos de controle da tabela Pessoa
    //Metodo para Salva Uma pessoa No banco
    public void prepararSalvarPessoa(){
        pessoa = new PessoaModel();
    }
    public void salvarPessoa() {
        pessoasService.salvar(pessoa);
        messages.info("Empresa cadastrada com sucesso!");
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

    public void pesquisar(){
        listaPessoas = pessoasRepository.buscarPessoaPorTexto(termoPesquisa);
        if(listaPessoas.isEmpty()){
            messages.info("Sua Consulta não retornou registro do Banco de Dados.");
        }
    }
    
    public String getTermoPesquisa() {
        return termoPesquisa;
    }

    public void setTermoPesquisa(String termoPesquisa) {
        this.termoPesquisa = termoPesquisa;
    }
    
}
