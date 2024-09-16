package com.algaworks.cobranca.model;

import com.algaworks.cobranca.model.enuns.StatusTitulo;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

// Parou na aula 2.3 em 7:25 segundos
@Entity
@Table(name = "titulo")
public class Titulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = " Não pode estar vazio!")
    @Size(max = 60, message = " Não pode conter mais que 60 caracteres!")
    @Column(name = "descricao")
    private String descricao;

    @NotNull(message = " Não pode estar vazio!")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date dataVencimento;

    @NotNull(message = " Não pode estar vazio!")
    @DecimalMin(value = "0.01", message = " Não pode ser menor que R$ 0,01!")
    @DecimalMax(value = "9999999.99", message = " Não pode ser maior que 9.999.999,99!")
    @NumberFormat(pattern = "#,##0.00")
    @Column(name = "valor")
    private BigDecimal valor;

    @NotNull(message = " Deverá receber um valor válido!")
    @Enumerated(EnumType.STRING)
    private StatusTitulo status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public StatusTitulo getStatus() {
        return status;
    }

    public void setStatus(StatusTitulo status) {
        this.status = status;
    }

    public boolean isPendente() {
        return StatusTitulo.PENDENTE.equals(status);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Titulo titulo = (Titulo) o;
        return Objects.equals(id, titulo.id) && Objects.equals(descricao, titulo.descricao) && Objects.equals(dataVencimento, titulo.dataVencimento) && Objects.equals(valor, titulo.valor) && status == titulo.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, dataVencimento, valor, status);
    }
}
