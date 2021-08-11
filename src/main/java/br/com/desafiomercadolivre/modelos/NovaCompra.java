package br.com.desafiomercadolivre.modelos;

import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "tb_compras")
public class NovaCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull(message = "É necesário informar o produto.")
    private Produto produto;

    @Positive
    @NotNull(message = "É Necessário informar uma quantidade.")
    private Integer quantidade;

    @ManyToOne
    @NotNull
    private Usuario comprador;

    @Enumerated(EnumType.STRING)
    private GatewayPagamento gatewayDePagamento;

    @Enumerated(EnumType.STRING)
    private StatusCompra statusCompra;


    @Deprecated
    public NovaCompra(){

    }

    public NovaCompra(Produto produto, Integer quantidade, Usuario comprador, GatewayPagamento gatewayDePagamento) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.comprador = comprador;
        this.gatewayDePagamento = gatewayDePagamento;
        this.statusCompra = StatusCompra.INICIADA;
    }

    public Long getId() {
        return id;
    }

    public Usuario getComprador() {
        return comprador;
    }

    public String retornarUrlGateway(UriComponentsBuilder uriComponentsBuilder){
        return this.gatewayDePagamento.retornarURI(this, uriComponentsBuilder);
    }

    @Override
    public String toString() {
        return "NovaCompra{" +
                "id=" + id +
                ", produto=" + produto +
                ", quantidade=" + quantidade +
                ", comprador=" + comprador +
                ", gatewayDePagamento=" + gatewayDePagamento +
                ", statusCompra=" + statusCompra +
                '}';
    }
}
