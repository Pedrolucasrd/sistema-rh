package com.sistemarh.service;

import com.sistemarh.model.Vaga;
import com.sistemarh.model.dto.CadastroVagaDTO;
import com.sistemarh.model.enums.StatusVaga;
import com.sistemarh.model.enums.TurnoVaga;
import com.sistemarh.model.repository.VagaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class VagaServiceTest {

    @Mock
    private VagaRepository vagaRepository;
    @InjectMocks
    private VagaService vagaService;

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
    public void criarVagaOk() {
        CadastroVagaDTO cadastroVagaDTO = new CadastroVagaDTO(vaga);
        Mockito.when(vagaRepository.save(any(Vaga.class))).thenReturn(vaga);
        var vagaSalva = vagaService.criarVaga(cadastroVagaDTO);

        assertEquals(vagaSalva, vaga);

        Mockito.verify(vagaRepository, Mockito.times(1))
                .save(any(Vaga.class));
    }
}
