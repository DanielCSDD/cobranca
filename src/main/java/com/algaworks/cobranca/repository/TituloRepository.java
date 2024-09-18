package com.algaworks.cobranca.repository;

import com.algaworks.cobranca.model.Titulo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TituloRepository extends JpaRepository<Titulo, Long> {

    /*
     * Definindo método para realizar uma pesquisa tendo por base a descrição do título.
     * Será feito o uso do padrão da JPA, onde os métodos são gerados automáticamente ao
     * seguirmos um padrão de declaração de método.
     * Assim, evita de fazermos uso de Criteria, por exemplo. Não siginifica que será suficiente,
     * mas resolverá muitos dos casos.
     */
    List<Titulo> findByDescricaoContaining(String descricao);
}
