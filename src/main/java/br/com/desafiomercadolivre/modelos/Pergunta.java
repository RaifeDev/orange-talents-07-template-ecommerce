package br.com.desafiomercadolivre.modelos;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_perguntas")
public class Pergunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Título é obrigatório.")
    private String titulo;

    private LocalDateTime dataCriacao;

    @ManyToOne
    @NotNull
    private Usuario usuario;

    @ManyToOne
    @NotNull
    private Produto produtoRelacionado;

    @Deprecated
    public Pergunta(){

    }

    public Pergunta(String titulo, Usuario usuario, Produto produtoRelacionado) {
        this.titulo = titulo;
        this.dataCriacao = LocalDateTime.now();
        this.usuario = usuario;
        this.produtoRelacionado = produtoRelacionado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    @Override
    public String toString() {
        return "Pergunta{" +
                "titulo='" + titulo + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", produtoRelacionado=" + produtoRelacionado +
                '}';
    }
}
