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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;

@Named(value = "pessoaController")
@ViewScoped
public class PessoaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private PessoaModel selectedPessoa;
    
    @Inject //Injeção de Dependência usando o CDI
    private PessoaService pessoasService;
    
    @Inject
    private FacesMessages messages;
    
    @Inject
    private PessoasRepository pessoasRepository;
    
    private List<PessoaModel> listaPessoas;
    
    private String termoPesquisa;
        
    private List<PessoaModel> selectedPessoas;

    public PessoaBean() {
    }

    //Metodos de controle da tabela Pessoa
    //Metodo para Salva Uma pessoa No banco
    public void openNewPessoa(){
        this.selectedPessoa = new PessoaModel();
    }
    public void salvarPessoa() {
        pessoasService.salvar(selectedPessoa);
        atualizarTela();
        
         addMessage("Pessoa cadastrada com sucesso!");
        
        //RequestContext.getCurrentInstance().update(Arrays.asList( "frm:pessoaDataTable", "frm:messages" ));
    }
    //Metodo para trazer todo do banco Tabela Pessoa
    public void todasPessoas() {
        listaPessoas = pessoasService.getAllPessoas();
        
    }
    
    //Injeção de dependência modo Tradicional
    public PessoaModel getPessoa() {
        return selectedPessoa;
    }

    public void setPessoa(PessoaModel pessoa) {
        this.selectedPessoa = pessoa;
    }

    public List<PessoaModel> getListaPessoas() {
        return listaPessoas;
    }

    public void pesquisar(){
        listaPessoas = pessoasRepository.buscarPessoaPorTexto(termoPesquisa);
        if(listaPessoas.isEmpty()){
            addMessage("Sua Consulta não retornou registro do Banco de Dados.");
        }
    }
    
    
    public void addMessage(String summary) {
        //FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        //FacesContext.getCurrentInstance().addMessage(null, message);
//        /messages.info(summary);
        PrimeFaces.current().ajax().update("frm:pessoaDataTable", "frm:messages");
    }
    
    private void atualizarTela(){
        todasPessoas();
    }
    
    
    public String getTermoPesquisa() {        return termoPesquisa;
    }

    public void setTermoPesquisa(String termoPesquisa) {
        this.termoPesquisa = termoPesquisa;
    }

    public PessoaModel getSelectedPessoa() {
        return selectedPessoa;
    }

    public void setSelectedPessoa(PessoaModel selectedPessoa) {
        this.selectedPessoa = selectedPessoa;
    }

    public List<PessoaModel> getSelectedPessoas() {
        return selectedPessoas;
    }

    public void setSelectedPessoas(List<PessoaModel> selectedPessoas) {
        this.selectedPessoas = selectedPessoas;
    }

   
     public void deletePessoa() {
        this.pessoasRepository.deletar(selectedPessoa);
        this.selectedPessoa = null;
        atualizarTela();
        //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Pessoa Removida!"));
        //PrimeFaces.current().ajax().update("frm:messages", "frm:pessoaDataTable");
    }

    
     public boolean hasSelectedPessoas() {
        return this.selectedPessoas != null && !this.selectedPessoas.isEmpty();
    }
    
}
