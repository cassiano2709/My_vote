package com.votacao.entity;


import lombok.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Data
@With
@Table(name = "topic")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private String description;
    private Long countYes;
    private Long countNo;

}
