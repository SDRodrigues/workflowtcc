package com.tcc.tcc.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PropostaDeTrabalho extends IdBase {
    private Professor orientador;
    private String titulo;
    private Aluno autor;

}
