package com.tcc.tcc.service;

import com.tcc.tcc.exception.ObjetoNaoEncontrado;
import com.tcc.tcc.model.PropostaDeTrabalho;
import com.tcc.tcc.repository.PropostaRepositorio;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class PropostaServico {

    private PropostaRepositorio propostaRepositorio;
    private static final String NOTFOUND = "Ocorreu um erro com a proposta";

    public PropostaDeTrabalho postSalvaProposta(PropostaDeTrabalho proposta) {
        try {
            this.propostaRepositorio.insert(proposta);
        } catch (Exception exception) {
            throw new ObjetoNaoEncontrado(NOTFOUND);
        }
        return proposta;
    }

    public List<PropostaDeTrabalho> getAllProposta() {
        return propostaRepositorio.findAll();
    }

    public Optional<PropostaDeTrabalho> getPropostaId(Integer id){
        Optional<PropostaDeTrabalho> proposta = propostaRepositorio.findById(id);
        if (!proposta.isPresent()) {
            throw new ObjetoNaoEncontrado(NOTFOUND);
        }
        return proposta;
    }

    public PropostaDeTrabalho putPropostaEdit(PropostaDeTrabalho professor) {
        PropostaDeTrabalho novoProfessor = editandoProposta(professor.getId());
        propostaEditada(novoProfessor, professor);
        return this.propostaRepositorio.save(novoProfessor);
    }

    private PropostaDeTrabalho editandoProposta(Integer id) {
        Optional<PropostaDeTrabalho> banca = this.propostaRepositorio.findById(id);
        if (banca.isPresent()) {
            return banca.get();
        } else {
            throw new ObjetoNaoEncontrado(NOTFOUND);
        }
    }

    private void propostaEditada(PropostaDeTrabalho novaBanca, PropostaDeTrabalho banca) {
       novaBanca.setAutor(banca.getAutor());
       novaBanca.setOrientador(banca.getOrientador());
       novaBanca.setTitulo(banca.getTitulo());
       novaBanca.setId(banca.getId());
    }

    public void deletePropostaId(Integer id){
        try {
            Optional<PropostaDeTrabalho> proposta = this.propostaRepositorio.findById(id);
            proposta.ifPresent(value -> this.propostaRepositorio.deleteById(value.getId()));
        } catch (Exception exception) {
            throw new ObjetoNaoEncontrado(NOTFOUND);
        }
    }


    public void deleteAllProposta() {
        this.propostaRepositorio.deleteAll();

    }

}
