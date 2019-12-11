package com.tcc.tcc.model;

import javax.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BancaAvaliacao extends IdBase {
    private Date data;
    @NotNull
    private Date hora;
    @NotNull
    private Professor orientador;
    @NotNull
    private Professor avaliador1;
    @NotNull
    private Professor avaliador2;


}
