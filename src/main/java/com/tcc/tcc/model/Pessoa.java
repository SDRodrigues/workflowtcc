package com.tcc.tcc.model;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pessoa {
    @NotNull
    protected String nome;
    @NotNull
    protected String cpf;
    @NotNull
    protected String matricula;
    @NotNull
    protected String email;
    @NotNull
    protected String telefone;





}
