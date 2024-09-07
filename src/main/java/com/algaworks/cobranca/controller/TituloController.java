package com.algaworks.cobranca.controller;

import com.algaworks.cobranca.model.Titulo;
import com.algaworks.cobranca.repository.TituloRepository;
import com.algaworks.cobranca.service.TituloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/titulos")
public class TituloController {

    private final TituloService tituloService;
    private ModelAndView mv;

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
    public ModelAndView salvar(Titulo titulo) {
        this.mv = new ModelAndView("CadastroTitulo");

        if (this.tituloService.getSalvar(titulo)) {
            this.mv.addObject("msgNovoCadastro", "Título cadastrado com sucesso!");
        } else {
            this.mv.addObject("msgNovoCadastro", "Título não cadastrado!");
        }

        return this.mv;
    }
}
