package com.tcc.tcc.model;

import javax.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Data
@Document
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AreaDeInteresse extends IdBase {
    @NotNull
    private String descricao;



}
