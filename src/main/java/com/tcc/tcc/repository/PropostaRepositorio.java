package com.tcc.tcc.repository;

import com.tcc.tcc.model.PropostaDeTrabalho;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PropostaRepositorio extends MongoRepository<PropostaDeTrabalho,Integer> {
}
