package com.tcc.tcc.controller;

import com.tcc.tcc.model.Aluno;
import com.tcc.tcc.model.PropostaDeTrabalho;
import com.tcc.tcc.service.PropostaServico;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("v1/proposta")
@Api(value = "proposta")
public class PropostaController {

    private PropostaServico propostaServico;

    @GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Buscar proposta", response= PropostaDeTrabalho.class, notes="Essa operação busca as propostas.")
    public List<PropostaDeTrabalho> getAllUsuarios() {
        return this.propostaServico.getAllProposta();
    }

    @GetMapping(value = "/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Buscar proposta", response= PropostaDeTrabalho.class, notes="Essa operação busca uma proposta especifico.")
    public Optional<PropostaDeTrabalho> getUsuarioPorId(@PathVariable Integer id) {
        return this.propostaServico.getPropostaId(id);
    }


    @PostMapping(produces=MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Criar proposta", response= PropostaDeTrabalho.class, notes="Essa operação cria o usuario.")
    public PropostaDeTrabalho criaUsuario(@RequestBody PropostaDeTrabalho aluno) {
        return propostaServico.postSalvaProposta(aluno);
    }

    @PutMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Editar proposta", response= PropostaDeTrabalho.class, notes="Essa operação edita o usuario.")
    public PropostaDeTrabalho editaUsuario(@RequestBody PropostaDeTrabalho aluno) {
        return propostaServico.putPropostaEdit(aluno);
    }

    @DeleteMapping(value = "/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Excluir proposta", response= PropostaDeTrabalho.class, notes="Essa operação exclui a proposta.")
    public void deletaUsuario(@PathVariable Integer id) {
        propostaServico.deletePropostaId(id);
    }

    @DeleteMapping(value = "", produces=MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Excluir proposta", response= PropostaDeTrabalho.class, notes="Essa operação exclui todas propostas.")
    public void deletaUsuario() {
        propostaServico.deleteAllProposta();
    }
}
