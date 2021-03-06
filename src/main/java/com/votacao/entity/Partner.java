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
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "cpf")})
public class Partner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;

}
