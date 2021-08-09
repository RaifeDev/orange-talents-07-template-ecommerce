package br.com.desafiomercadolivre.modelos;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_imagens_do_produto")
public class ImagemProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo url precisa ser preenchido.")
    private String url;

    @ManyToOne
    private Produto produto;

    @Deprecated
    public ImagemProduto(){

    }

    public ImagemProduto(String url, Produto produto) {
        this.url = url;
        this.produto = produto;
    }

    public String getUrl() {
        return url;
    }
}
