package com.tcc.tcc.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Aluno extends Pessoa {
    @Id
    private Integer id;
    private PropostaDeTrabalho proposta;

}
