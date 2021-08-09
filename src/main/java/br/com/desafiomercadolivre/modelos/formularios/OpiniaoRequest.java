package br.com.desafiomercadolivre.modelos.formularios;

import br.com.desafiomercadolivre.annotations.IdExiste;
import br.com.desafiomercadolivre.modelos.Opiniao;
import br.com.desafiomercadolivre.modelos.Produto;
import br.com.desafiomercadolivre.modelos.Usuario;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

public class OpiniaoRequest {

    @Positive
    @Min(1)
    @Max(5)
    private Integer nota;

    @NotBlank(message = "O título é obrigatório.")
    private String titulo;

    @NotBlank(message = "A descrição é obrigatória.")
    @Length(max = 500)
    private String descricao;

    @IdExiste(domainClass = Produto.class, fieldName = "id", message = "Este produto não existe.")
    @NotNull(message = "O produto em questão deve ser informado.")
    private Long produto;


    public OpiniaoRequest(Integer nota, String titulo, String descricao, Long produto) {
        this.nota = nota;
        this.titulo = titulo;
        this.descricao = descricao;
        this.produto = produto;
    }

    public Integer getNota() {
        return nota;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Long getProduto() {
        return produto;
    }

    public Opiniao converterParaOpiniao(Usuario usuarioLogado, Produto produto) {
        System.out.println(getDescricao());
        return new Opiniao(nota, titulo, descricao, usuarioLogado, produto);

    }



}
