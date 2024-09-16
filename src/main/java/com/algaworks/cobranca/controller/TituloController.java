package com.algaworks.cobranca.controller;

import com.algaworks.cobranca.model.Titulo;
import com.algaworks.cobranca.model.enuns.StatusTitulo;
import com.algaworks.cobranca.repository.TituloRepository;
import com.algaworks.cobranca.service.TituloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

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
    public ModelAndView novo() {
        this.mv = new ModelAndView("CadastroTitulo");
        this.mv.addObject(new Titulo());
        return this.mv;
    }

    // Método que irá salvar os dados do formulário.
    @PostMapping
    public ModelAndView salvar(@Validated Titulo titulo, Errors errors) {
        this.mv = new ModelAndView("CadastroTitulo");

        if (errors.hasErrors()) {
            return this.mv;
        }
        this.tituloService.getSalvar(titulo);
        this.mv.addObject("msgNovoCadastro", "Título cadastrado com sucesso!");

        return this.mv;
    }

    @RequestMapping
    public ModelAndView getPesquisar() {
        this.mv = new ModelAndView("PesquisaTitulos");
        this.mv.addObject("titulos", this.tituloService.getTitulos());
        return this.mv;
    }

    // Inicializando a lista de Status de Título, sem que tenha a necessidade de atribuí-lo a uma variável ModelAndView.
    @ModelAttribute("listaStatusTitulo")
    public List<StatusTitulo> getRelacaoStatus() {
        return Arrays.asList(StatusTitulo.values());
    }
}
