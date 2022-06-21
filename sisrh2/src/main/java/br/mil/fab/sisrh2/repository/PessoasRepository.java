/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.mil.fab.sisrh2.repository;

/**
 *
 * @author fernando
 */
import br.mil.fab.sisrh2.model.PessoaModel;
import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class PessoasRepository implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;
    
    public PessoasRepository(){}
    
    public PessoasRepository(EntityManager manager){
        this.manager = manager;
    }
    
    //Buscar Pessoas por ID
    public PessoaModel getIdPessoa(long id){
        return manager.find(PessoaModel.class, id);
    }
    
    //Pesquisar por nome Usando JPQL e Retornando um Array List
    public List<PessoaModel> buscarPessoaPorTexto(String texto){
        String jpql = "from PessoaModel where nome like :termoPesquisa";
        TypedQuery<PessoaModel> query = manager.createQuery(jpql, PessoaModel.class);
        
        query.setParameter("termoPesquisa", texto + "%");
        
        return query.getResultList();
    }
    public List<PessoaModel> todasPessoas() {
         return manager.createQuery("from PessoaModel", PessoaModel.class).getResultList();
    }
    
    public PessoaModel inserir(PessoaModel pessoa){
        return manager.merge(pessoa);
    }
    
    public void deletar(PessoaModel pessoa){
        PessoaModel p = getIdPessoa(pessoa.getId());
        manager.remove(pessoa);
    }
}
