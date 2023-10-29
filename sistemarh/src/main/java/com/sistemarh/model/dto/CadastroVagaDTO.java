package com.sistemarh.model.dto;

import com.sistemarh.model.Vaga;
import com.sistemarh.model.enums.StatusVaga;
import com.sistemarh.model.enums.TurnoVaga;

import java.time.LocalDate;

public record CadastroVagaDTO(
        String titulo,
        StatusVaga status,
        String descricao,
        String responsabilidade,
        TurnoVaga turno,
        String categoria,
        String local,
        LocalDate dataFinal,
        Double salario,
        int vagasDisponiveis) {
    public CadastroVagaDTO(Vaga vaga) {
        this(vaga.getTitulo(), vaga.getStatus(), vaga.getDescricao(),
                vaga.getResponsabilidade(), vaga.getTurno(), vaga.getCategoria(),
                vaga.getLocal(), vaga.getDataFinal(), vaga.getSalario(), vaga.getVagasDisponiveis());

    }
}
