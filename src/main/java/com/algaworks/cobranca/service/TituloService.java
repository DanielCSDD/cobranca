package com.algaworks.cobranca.service;

import com.algaworks.cobranca.model.Titulo;
import com.algaworks.cobranca.model.enuns.StatusTitulo;
import com.algaworks.cobranca.repository.TituloRepository;
import com.algaworks.cobranca.repository.filter.TituloFilter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TituloService {

    private final TituloRepository tituloRepository;
    private boolean retorno = false;

    public TituloService(TituloRepository tituloRepository) {
        this.tituloRepository = tituloRepository;
    }

    public boolean getSalvar(Titulo titulo) {
        tituloRepository.save(titulo);
        retorno = true;
        return retorno;
    }

    public void getExcluir(Titulo titulo) {
        this.tituloRepository.delete(titulo);
    }

    public List<Titulo> getTitulos(TituloFilter filter) {
        return this.tituloRepository.findByDescricaoContaining(filter.getDescricao() == null ? "" : filter.getDescricao());
    }

    public String getReceber(Titulo titulo) {
        titulo.setStatus(StatusTitulo.RECEBIDO);
        this.getSalvar(titulo);
        return StatusTitulo.RECEBIDO.getDescricao();
    }
}
