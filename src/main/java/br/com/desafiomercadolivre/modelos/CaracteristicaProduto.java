package br.com.desafiomercadolivre.modelos;

import javax.persistence.*;

@Entity
@Table(name = "tb_caracteristicas_do_produto")
public class CaracteristicaProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    @ManyToOne
    private Produto produto;

    @Deprecated
    public CaracteristicaProduto(){

    }

    public CaracteristicaProduto(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
