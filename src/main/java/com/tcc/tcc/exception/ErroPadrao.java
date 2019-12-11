package com.tcc.tcc.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ErroPadrao {
    private Long timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
