package com.sistemarh.controller;

import com.sistemarh.model.dto.CadastroVagaDTO;
import com.sistemarh.model.Vaga;
import com.sistemarh.service.VagaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("vaga")
public class VagaController {

    @Autowired
    private VagaService vagaService;

    @PostMapping
    public Vaga criarVaga (@RequestBody @Valid CadastroVagaDTO vaga) {
        return vagaService.criarVaga(vaga);
    }

}
