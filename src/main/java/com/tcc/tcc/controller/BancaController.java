package com.tcc.tcc.controller;

import com.tcc.tcc.model.Aluno;
import com.tcc.tcc.model.BancaAvaliacao;
import com.tcc.tcc.service.BancaServico;
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
@RequestMapping("v1/bancas")
@Api(value = "bancas")
public class BancaController {

    private BancaServico bancaServico;

    @GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Buscar bancas", response= BancaAvaliacao.class, notes="Essa operação busca as bancas de" +
            "avaliação.")
    public List<BancaAvaliacao> getAllBancas() {
        return this.bancaServico.getAllBancas();
    }

    @GetMapping(value = "/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Buscar banca por id", response= BancaAvaliacao.class, notes="Essa operação busca " +
            "uma banca especifica.")
    public Optional<BancaAvaliacao> getBancaId(@PathVariable Integer id) {
        return this.bancaServico.getBancaId(id);
    }


    @PostMapping(produces=MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Criar banca", response= BancaAvaliacao.class, notes="Essa operação cria a banca de avaliação.")
    public BancaAvaliacao postBancaSalvar(@RequestBody BancaAvaliacao banca) {
        return bancaServico.postBancaSalvar(banca);
    }

    @PutMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Editar banca", response= BancaAvaliacao.class, notes="Essa operação edita a banca de avaliação.")
    public BancaAvaliacao putBancaEdit(@RequestBody BancaAvaliacao banca) {
        return bancaServico.putBancaEdit(banca);
    }

    @DeleteMapping(value = "/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Excluir banca", response= Aluno.class, notes="Essa operação exclui a banca.")
    public void deleteBancaId(@PathVariable Integer id) {
        bancaServico.deleteBancaId(id);
    }

    @DeleteMapping(value = "", produces=MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Excluir todas as bancas", response= Aluno.class, notes="Essa operação exclui todas as bancas.")
    public void deleteAllBanca() {
        bancaServico.deleteAllBanca();
    }
}
