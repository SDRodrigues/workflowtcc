package com.tcc.tcc.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Professor extends Pessoa {
    @Id
    private Integer id;
    private Titulo titulo;
    private List<Sugestao> sugestaoDeProjeto;
    private List<AreaDeInteresse> areaDeInteresse;


}
