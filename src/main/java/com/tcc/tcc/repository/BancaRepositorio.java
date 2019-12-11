package com.tcc.tcc.repository;

import com.tcc.tcc.model.BancaAvaliacao;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BancaRepositorio extends MongoRepository<BancaAvaliacao, Integer> {
}
