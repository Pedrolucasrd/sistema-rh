package com.sistemarh.service;

import com.sistemarh.model.Vaga;
import com.sistemarh.model.dto.CadastroVagaDTO;
import com.sistemarh.model.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VagaService {

    @Autowired
    private VagaRepository vagaRepository;

    public Vaga criarVaga (CadastroVagaDTO vaga) {

        return vagaRepository.save(new Vaga(vaga));

    }
}
