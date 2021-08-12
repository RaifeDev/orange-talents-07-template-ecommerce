package br.com.desafiomercadolivre.modelos;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tb_transacoes")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String idTransacao;

    @NotNull
    private StatusTransacao status;

    @ManyToOne
    private NovaCompra compra;

    private LocalDateTime instante;

    @Deprecated
    public Transacao(){

    }

    public Transacao(String idTransacao, StatusTransacao status, NovaCompra compra) {
        this.idTransacao = idTransacao;
        this.status = status;
        this.instante = LocalDateTime.now();
        this.compra = compra;
    }

    public boolean concluidaComSucesso(){
        return this.status.equals(StatusTransacao.Sucesso);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transacao transacao = (Transacao) o;
        return id.equals(transacao.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
