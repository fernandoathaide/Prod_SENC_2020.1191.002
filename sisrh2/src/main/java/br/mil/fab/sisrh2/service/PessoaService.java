package br.mil.fab.sisrh2.service;

import java.io.Serializable;
import javax.inject.Inject;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author fernando
 */
import br.mil.fab.sisrh2.model.PessoaModel;
import br.mil.fab.sisrh2.repository.PessoasRepository;
import br.mil.fab.sisrh2.util.Transacional;



public class PessoaService implements Serializable{
    
    private static final long erialVersionUID = 1L;
    
    @Inject
    private PessoasRepository pessoasRepository;
    
    @Transacional
    public void salvar(PessoaModel pessoa){
        pessoasRepository.inserir(pessoa);
    }    
}
