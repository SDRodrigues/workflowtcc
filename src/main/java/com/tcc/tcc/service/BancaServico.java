package com.tcc.tcc.service;

import com.tcc.tcc.exception.ObjetoNaoEncontrado;
import com.tcc.tcc.model.BancaAvaliacao;
import com.tcc.tcc.repository.BancaRepositorio;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class BancaServico {

    private BancaRepositorio bancaRepositorio;
    private static final String NOTFOUND = "Ocorreu um erro com a banca de avaliação";


    public BancaAvaliacao postBancaSalvar(BancaAvaliacao banca){
        try {
            this.bancaRepositorio.insert(banca);
        } catch (Exception exception) {
            throw new ObjetoNaoEncontrado(NOTFOUND);
        }
        return banca;
    }

    public Optional<BancaAvaliacao> getBancaId(Integer id) {
        Optional<BancaAvaliacao> banca = bancaRepositorio.findById(id);
        if (!banca.isPresent()) {
            throw new ObjetoNaoEncontrado(NOTFOUND);
        }
        return banca;
    }

    public List<BancaAvaliacao> getAllBancas(){
            return bancaRepositorio.findAll();
    }

    public BancaAvaliacao putBancaEdit(BancaAvaliacao bancaAvaliacao) {
        BancaAvaliacao novaBanca = editandoBanca(bancaAvaliacao.getId());
        bancaEditada(novaBanca, bancaAvaliacao);
        return this.bancaRepositorio.save(novaBanca);
    }

    private BancaAvaliacao editandoBanca(Integer id) {
        Optional<BancaAvaliacao> banca = this.bancaRepositorio.findById(id);
        if (banca.isPresent()) {
            return banca.get();
        } else {
            throw new ObjetoNaoEncontrado(NOTFOUND);
        }
    }

    private void bancaEditada(BancaAvaliacao novaBanca, BancaAvaliacao editaBanca) {
        novaBanca.setId(editaBanca.getId());
        novaBanca.setAvaliador1(editaBanca.getAvaliador1());
        novaBanca.setAvaliador2(editaBanca.getAvaliador2());
        novaBanca.setData(editaBanca.getData());
        novaBanca.setHora(editaBanca.getHora());
        novaBanca.setOrientador(editaBanca.getOrientador());
    }

    public void deleteBancaId(Integer id){
        try {
            Optional<BancaAvaliacao> banca = this.bancaRepositorio.findById(id);
            banca.ifPresent(bancaAvaliacao -> this.bancaRepositorio.deleteById(id));
        } catch (Exception exception) {
            throw new ObjetoNaoEncontrado(NOTFOUND);
        }
    }

    public void deleteAllBanca(){
        try {
            this.bancaRepositorio.deleteAll();
        } catch (Exception exception) {
            throw new ObjetoNaoEncontrado(NOTFOUND);
        }
    }
}
