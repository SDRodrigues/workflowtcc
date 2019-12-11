package com.tcc.tcc.repository;

import com.tcc.tcc.model.Aluno;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlunoRepositorio extends MongoRepository<Aluno,Integer> {
}
