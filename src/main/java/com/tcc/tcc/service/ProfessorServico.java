package com.tcc.tcc.service;

import com.tcc.tcc.exception.ObjetoNaoEncontrado;
import com.tcc.tcc.model.Professor;
import com.tcc.tcc.repository.ProfessorRepositorio;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorServico {

    private ProfessorRepositorio professorRepositorio;
    private static final String NOTFOUND = "Ocorreu um erro com o professor";

    public Professor postSalvaProfessor(Professor professor){
        try {
            this.professorRepositorio.insert(professor);
        } catch (Exception exception) {
            throw new ObjetoNaoEncontrado(NOTFOUND);
        }
        return professor;
    }

    public List<Professor> getAllProfessores() {
        return professorRepositorio.findAll();
    }

    public Optional<Professor> getProfessorId(Integer id){
        Optional<Professor> professor = professorRepositorio.findById(id);
        if (!professor.isPresent()) {
            throw new ObjetoNaoEncontrado(NOTFOUND);
        }
        return professor;
    }

    public Professor putBancaEdit(Professor professor) {
        Professor novoProfessor = editandoBanca(professor.getId());
        bancaEditada(novoProfessor, professor);
        return this.professorRepositorio.save(novoProfessor);
    }

    private Professor editandoBanca(Integer id) {
        Optional<Professor> banca = this.professorRepositorio.findById(id);
        if (banca.isPresent()) {
            return banca.get();
        } else {
            throw new ObjetoNaoEncontrado(NOTFOUND);
        }
    }

    private void bancaEditada(Professor novaBanca, Professor banca) {
        novaBanca.setId(banca.getId());
        novaBanca.setTitulo(banca.getTitulo());
        novaBanca.setCpf(banca.getCpf());
        novaBanca.setEmail(banca.getEmail());
        novaBanca.setNome(banca.getNome());
        novaBanca.setAreaDeInteresse(banca.getAreaDeInteresse());
        novaBanca.setSugestaoDeProjeto(banca.getSugestaoDeProjeto());
    }

    public void deleteProfessorId(Integer id){
        try {
            Optional<Professor> professor = this.professorRepositorio.findById(id);
            professor.ifPresent(value -> this.professorRepositorio.deleteById(value.getId()));
        } catch (Exception exception) {
            throw new ObjetoNaoEncontrado(NOTFOUND);
        }
    }


    public void deleteAllProfessor() {
            this.professorRepositorio.deleteAll();

    }

}
