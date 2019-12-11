package com.tcc.tcc.repository;

import com.tcc.tcc.model.Professor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfessorRepositorio extends MongoRepository<Professor, Integer> {
}
