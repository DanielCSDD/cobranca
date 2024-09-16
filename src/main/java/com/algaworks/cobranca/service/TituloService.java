package com.algaworks.cobranca.service;

import com.algaworks.cobranca.model.Titulo;
import com.algaworks.cobranca.repository.TituloRepository;
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

    public List<Titulo> getTitulos() {
        return this.tituloRepository.findAll();
    }
}
