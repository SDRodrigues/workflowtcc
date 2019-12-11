package com.tcc.tcc.service;

import com.tcc.tcc.exception.ObjetoNaoEncontrado;
import com.tcc.tcc.model.Aluno;
import com.tcc.tcc.repository.AlunoRepositorio;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class AlunoServico {

    private AlunoRepositorio repositorioAluno;
    private static final String NOTFOUND = "Ocorreu um erro com o usuario";

    public Aluno postSalvarAluno(Aluno aluno) {
        try {
            this.repositorioAluno.insert(aluno);
        } catch (Exception exception) {
            throw new ObjetoNaoEncontrado(NOTFOUND);
        }
        return aluno;
    }

    public Optional<Aluno> getUsuarioPorId(Integer id) {
        Optional<Aluno> usuario = repositorioAluno.findById(id);
        if (!usuario.isPresent()) {
            throw new ObjetoNaoEncontrado(NOTFOUND);
        }
        return usuario;
    }

    public List<Aluno> getAllUsuarios() {
        return this.repositorioAluno.findAll();
    }

        public Aluno putEditarAluno(Aluno editaAluno) {
            Aluno alunoEditado = atualizandoAluno(editaAluno.getId());
            atualizouAluno(alunoEditado, editaAluno);
            return this.repositorioAluno.save(alunoEditado);
        }

        private Aluno atualizandoAluno(Integer id) {
            Optional<Aluno> usuario = this.repositorioAluno.findById(id);
            if (usuario.isPresent()) {
                return usuario.get();
            } else {
                throw new ObjetoNaoEncontrado(NOTFOUND);
            }
        }

        private void atualizouAluno(Aluno alunoEditado, Aluno editaAluno) {
            alunoEditado.setId(editaAluno.getId());
            alunoEditado.setNome(editaAluno.getNome());
            alunoEditado.setProposta(editaAluno.getProposta());
            alunoEditado.setEmail(editaAluno.getEmail());
            alunoEditado.setCpf(editaAluno.getCpf());
            alunoEditado.setMatricula(editaAluno.getMatricula());
            alunoEditado.setTelefone(editaAluno.getTelefone());
        }


    public void deleteUsuarioId(Integer id) {
        try {
            Optional<Aluno> aluno = this.repositorioAluno.findById(id);
            aluno.ifPresent(value -> this.repositorioAluno.deleteById(value.getId()));
        } catch (Exception exception) {
            throw new ObjetoNaoEncontrado(NOTFOUND);
        }
    }

    public void deleteAllUsuarios() {
            this.repositorioAluno.deleteAll();
    }

}
