package br.com.desafiomercadolivre.modelos.formularios;

import br.com.desafiomercadolivre.annotations.IdExiste;
import br.com.desafiomercadolivre.modelos.Pergunta;
import br.com.desafiomercadolivre.modelos.Produto;
import br.com.desafiomercadolivre.modelos.Usuario;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PerguntaRequest {

    @NotBlank(message = "Título é obrigatório.")
    private String titulo;

    @IdExiste(domainClass = Produto.class, fieldName = "id", message = "Este produto não existe")
    @NotNull
    private Long produto;


    public String getTitulo() {
        return titulo;
    }

    public Long getProduto() {
        return produto;
    }

    public Pergunta converterParaPergunta(Produto produto, Usuario usuario) {
        return new Pergunta(titulo, usuario, produto);
    }


}
