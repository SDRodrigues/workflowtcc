package com.tcc.tcc.controller;

import com.tcc.tcc.model.Aluno;
import com.tcc.tcc.service.AlunoServico;

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
@RequestMapping("v1/usuarios")
@Api(value = "usuarios")
public class AlunoController {

    private AlunoServico alunoServico;

    @GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Buscar usuário", response= Aluno.class, notes="Essa operação busca os usuários.")
    public List<Aluno> getAllUsuarios() {
        return this.alunoServico.getAllUsuarios();
    }

    @GetMapping(value = "/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Buscar usuário", response= Aluno.class, notes="Essa operação busca um usuário especifico.")
    public Optional<Aluno> getUsuarioPorId(@PathVariable Integer id) {
        return this.alunoServico.getUsuarioPorId(id);
    }

    @PostMapping(produces=MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Criar usuário", response= Aluno.class, notes="Essa operação cria o usuario.")
    public Aluno criaUsuario(@RequestBody Aluno aluno) {
        return alunoServico.postSalvarAluno(aluno);
    }

    @PutMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Editar usuário", response= Aluno.class, notes="Essa operação edita o usuario.")
    public Aluno editaUsuario(@RequestBody Aluno aluno) {
        return alunoServico.putEditarAluno(aluno);
    }

    @DeleteMapping(value = "/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Excluir usuário", response= Aluno.class, notes="Essa operação exclui o usuario.")
    public void deletaUsuario(@PathVariable Integer id) {
        alunoServico.deleteUsuarioId(id);
    }

    @DeleteMapping(value = "", produces=MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Excluir usuário", response= Aluno.class, notes="Essa operação exclui o usuario.")
    public void deletaUsuario() {
        alunoServico.deleteAllUsuarios();
    }

}
