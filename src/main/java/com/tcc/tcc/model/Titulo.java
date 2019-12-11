package com.tcc.tcc.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Titulo extends IdBase {
    private List<Professor> professor;
    protected String Especializacao;
    protected String Graduacao;
    protected String Mestrado;
    protected String Doutorado;
}
