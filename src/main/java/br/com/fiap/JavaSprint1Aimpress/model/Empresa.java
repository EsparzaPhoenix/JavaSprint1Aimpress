package br.com.fiap.JavaSprint1Aimpress.model;

import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "JV_EMPRESA")
@EntityListeners(AuditingEntityListener.class)
public class Empresa {

    @Id
    @GeneratedValue
    @Column(name = "id_empresa")
    private Long id;

    @Column(name = "nm_empresa", nullable = false, length = 50)
    private String name;

}

//    id              INTEGER NOT NULL,
//    nome            CLOB,
//    localização     CLOB,
//    recrutadores_id INTEGER NOT NULL,
//    ia_id           INTEGER NOT NULL