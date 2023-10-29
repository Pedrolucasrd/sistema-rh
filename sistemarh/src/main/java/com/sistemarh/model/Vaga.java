package com.sistemarh.model;

import com.sistemarh.model.dto.CadastroVagaDTO;
import com.sistemarh.model.enums.StatusVaga;
import com.sistemarh.model.enums.TurnoVaga;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_vaga")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVaga;
    private String titulo;
    private StatusVaga status;
    private String descricao;
    private String responsabilidade;
    private TurnoVaga turno;
    private String categoria;
    private String local;
    private LocalDate dataCriacao;
    private LocalDate dataFinal;
    private Double salario;
    private int vagasDisponiveis;


    public Vaga(CadastroVagaDTO vaga) {
        this.titulo = vaga.titulo();
        this.status = vaga.status();
        this.descricao = vaga.descricao();
        this.responsabilidade = vaga.responsabilidade();
        this.turno = vaga.turno();
        this.categoria = vaga.categoria();
        this.local = vaga.local();
        this.dataCriacao = LocalDate.now();
        this.dataFinal = vaga.dataFinal();
        this.salario = vaga.salario();
        this.vagasDisponiveis = vaga.vagasDisponiveis();

    }
}
