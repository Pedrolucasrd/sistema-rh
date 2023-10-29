package com.sistemarh.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sistemarh.model.Vaga;
import com.sistemarh.model.dto.CadastroVagaDTO;
import com.sistemarh.model.enums.StatusVaga;
import com.sistemarh.model.enums.TurnoVaga;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class VagaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    Vaga vaga;
    @BeforeEach
    public void setUp () {
        LocalDate dataAtual = LocalDate.now();
        vaga = Vaga.builder().idVaga(1L).titulo("Test").status(StatusVaga.EM_ABERTO)
                .descricao("testando").responsabilidade("Trabalhar").turno(TurnoVaga.MANHÃ)
                .categoria("Auxiliar").local("Caçapava").dataCriacao(dataAtual).dataFinal(dataAtual)
                .salario(13000D).vagasDisponiveis(10).build();
    }
    @Test
    public void criarVagaOk () throws Exception {
        CadastroVagaDTO cadastroVagaDTO = new CadastroVagaDTO(vaga);
        String requestBody = objectMapper.writeValueAsString(cadastroVagaDTO);
        mockMvc.perform(MockMvcRequestBuilders.post("/vaga")
                .content(requestBody).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idVaga").exists());

    }
}
