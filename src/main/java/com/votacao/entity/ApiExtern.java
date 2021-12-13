package com.votacao.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.Valid;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Data
@Valid
public class ApiExtern {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CPF(message = "Invalid CPF")
    @Column(unique = true, nullable = false)
    private String cpf;

}
