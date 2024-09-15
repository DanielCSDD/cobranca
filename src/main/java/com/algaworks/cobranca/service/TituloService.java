package com.algaworks.cobranca.service;

import com.algaworks.cobranca.model.Titulo;
import com.algaworks.cobranca.repository.TituloRepository;
import org.springframework.stereotype.Service;

@Service
public class TituloService {

    private final TituloRepository tituloRepository;
    private boolean retorno = false;

    public TituloService(TituloRepository tituloRepository) {
        this.tituloRepository = tituloRepository;
    }

    public boolean getSalvar(Titulo titulo) {
        if (isTituloValido(titulo)) {
            tituloRepository.save(titulo);
            retorno = true;
        }
        return retorno;
    }

    private boolean isTituloValido(Titulo titulo) {
        return (!(titulo.getDescricao() == null || titulo.getDescricao().isEmpty()) &&
                (titulo.getDataVencimento() != null) && (titulo.getValor() != null) &&
                !(titulo.getStatus() == null || titulo.getStatus().getDescricao().isEmpty()));
    }
}
