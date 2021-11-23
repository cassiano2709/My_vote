package com.votacao.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    @NotBlank
    @NotNull
    private String participant;

    @Column
    @NotNull
    private LocalDateTime date;


    @OneToOne(mappedBy = "participant")
    private Session session;
}
