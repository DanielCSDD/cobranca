package com.algaworks.cobranca.controller;

import com.algaworks.cobranca.model.Titulo;
import com.algaworks.cobranca.model.enuns.StatusTitulo;
import com.algaworks.cobranca.repository.TituloRepository;
import com.algaworks.cobranca.service.TituloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/titulos")
public class TituloController {

    private static final String VIEW_CADASTRO_TITULO = "CadastroTitulo";
    private static final String VIEW_PESQUISA_TITULO = "PesquisaTitulos";

    private final TituloService tituloService;
    private ModelAndView mv;

    @Autowired
    public TituloController(TituloRepository tituloRepository) {
        this.tituloService = new TituloService(tituloRepository);
    }

    @RequestMapping("/novo")
    public ModelAndView novo() {
        this.mv = new ModelAndView(VIEW_CADASTRO_TITULO);
        this.mv.addObject(new Titulo());
        return this.mv;
    }

    // Método que irá salvar os dados do formulário.
    @PostMapping
    public String salvar(@Validated Titulo titulo, Errors errors, RedirectAttributes attributes) {
        this.mv = new ModelAndView();

        if (errors.hasErrors()) {
            return VIEW_CADASTRO_TITULO;
        }
        this.tituloService.getSalvar(titulo);
        attributes.addFlashAttribute("msgNovoCadastro", "Título cadastrado com sucesso!");

        return "redirect:/titulos/novo";
    }

    @RequestMapping
    public ModelAndView getPesquisar() {
        this.mv = new ModelAndView(VIEW_PESQUISA_TITULO);
        this.mv.addObject("titulos", this.tituloService.getTitulos());
        return this.mv;
    }

    // Inicializando a lista de Status de Título, sem que tenha a necessidade de atribuí-lo a uma variável ModelAndView.
    @ModelAttribute("listaStatusTitulo")
    public List<StatusTitulo> getRelacaoStatus() {
        return Arrays.asList(StatusTitulo.values());
    }

    @GetMapping("{id}")
    public ModelAndView editar(@PathVariable("id") Titulo titulo) {
        this.mv = new ModelAndView(VIEW_CADASTRO_TITULO);
        this.mv.addObject(titulo);
        return this.mv;
    }
}
