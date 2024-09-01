package com.algaworks.cobranca.controller;

import com.algaworks.cobranca.model.Titulo;
import com.algaworks.cobranca.repository.TituloRepository;
import com.algaworks.cobranca.service.TituloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/titulos")
public class TituloController {

    private final TituloService tituloService;

    @Autowired
    public TituloController(TituloRepository tituloRepository) {
        this.tituloService = new TituloService(tituloRepository);
    }

    @RequestMapping("/novo")
    public String novo() {
        return "CadastroTitulo";
    }

    // Método que irá salvar os dados do formulário.
    @PostMapping
    public String salvar(Titulo titulo) {

        if (this.tituloService.getSalvar(titulo)) {
            System.out.println("Título, salvo com sucesso!");
        } else {
            System.out.println("Título, falha ao tentar salvar!");
        }

        return "CadastroTitulo";
    }
}
