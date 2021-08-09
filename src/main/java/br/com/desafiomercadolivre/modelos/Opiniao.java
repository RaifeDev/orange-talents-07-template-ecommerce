package br.com.desafiomercadolivre.modelos;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "tb_opinioes")
public class Opiniao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Positive
    @Min(1)
    @Max(5)
    private Integer nota;

    @NotBlank(message = "O título é obrigatório.")
    private String titulo;

    @NotBlank(message = "A descrição é obrigatória.")
    @Length(max = 500)
    private String descricao;

    @ManyToOne
    @NotNull(message = "Usuário é necessário para formar opinião.")
    private Usuario usuarioConsumidor;

    @ManyToOne
    @NotNull(message = "O produto em questão deve ser informado.")
    private Produto produto;

    @Deprecated
    public Opiniao(){

    }

    public Opiniao(Integer nota, String titulo, String descricao, Usuario usuarioConsumidor, Produto produto) {
        this.nota = nota;
        this.titulo = titulo;
        this.descricao = descricao;
        this.usuarioConsumidor = usuarioConsumidor;
        this.produto = produto;
    }




}
