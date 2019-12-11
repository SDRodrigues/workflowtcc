package com.tcc.tcc.controller;

import com.tcc.tcc.model.Aluno;
import com.tcc.tcc.model.Professor;
import com.tcc.tcc.service.ProfessorServico;
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
@RequestMapping("v1/professor")
@Api(value = "professor")
public class ProfessorController {

    private ProfessorServico professorServico;

    @GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Buscar usuário", response= Professor.class, notes="Essa operação busca os professores.")
    public List<Professor> getAllProfessores() {
        return this.professorServico.getAllProfessores();
    }

    @GetMapping(value = "/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Buscar usuário", response= Professor.class, notes="Essa operação busca um professor especifico.")
    public Optional<Professor> getUsuarioPorId(@PathVariable Integer id) {
        return this.professorServico.getProfessorId(id);
    }


    @PostMapping(produces=MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Criar usuário", response= Professor.class, notes="Essa operação cria o professor.")
    public Professor criaUsuario(@RequestBody Professor professor) {
        return professorServico.postSalvaProfessor(professor);
    }

    @PutMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Editar usuário", response= Professor.class, notes="Essa operação edita o usuario.")
    public Professor editaUsuario(@RequestBody Professor professor) {
        return professorServico.putBancaEdit(professor);
    }

    @DeleteMapping(value = "/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Excluir usuário", response= Professor.class, notes="Essa operação exclui o usuario.")
    public void deletaUsuario(@PathVariable Integer id) {
        professorServico.deleteProfessorId(id);
    }

    @DeleteMapping(value = "", produces=MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Excluir usuário", response= Professor.class, notes="Essa operação exclui o usuario.")
    public void deletaUsuario() {
        professorServico.deleteAllProfessor();
    }
}
