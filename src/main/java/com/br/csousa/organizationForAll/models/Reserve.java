package com.br.csousa.organizationForAll.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reserves")
public class Reserve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String mail;

    private String telephone;

    @ManyToOne
    @JoinColumn(name = "local_id", nullable = false, foreignKey = @ForeignKey(name = "fk_reserve_local"))
    private Local local;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private Long qtdAdults;

    @Column(nullable = false)
    private Long qtdChilds;

    @Column(nullable = false)
    private String hour;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
