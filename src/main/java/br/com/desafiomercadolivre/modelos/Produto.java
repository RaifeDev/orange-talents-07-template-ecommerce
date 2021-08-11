package br.com.desafiomercadolivre.modelos;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "tb_produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotNull
    @Positive
    private BigDecimal valor;

    @NotNull
    @PositiveOrZero
    private Integer quantidadeDisponivel;

    //Necessita colocr o mappedBy caso precise.
    @Size(min = 3)
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "produto_id")
    private Set<CaracteristicaProduto> caracteristicas = new HashSet<>();

    @NotBlank
    @Size(max = 1000)
    private String descricao;

    @ManyToOne
    @NotNull
    private Categoria categoria;

    private LocalDateTime dataCadastro;

    @ManyToOne
    private Usuario usuarioProprietario;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.MERGE)
    private List<ImagemProduto> imagensDoProduto = new ArrayList<>();

    @OneToMany(mappedBy = "produto")
    private List<Opiniao> opinioes = new ArrayList<>();

    @OneToMany(mappedBy = "produtoRelacionado")
    private List<Pergunta> perguntas = new ArrayList<>();

    @Deprecated
    public Produto(){

    }

    public Produto(String nome, BigDecimal valor, Integer quantidadeDisponivel,
                   Set<CaracteristicaProduto> caracteristicas, String descricao,
                   Categoria categoria, Usuario usuarioProprietario) {
        this.nome = nome;
        this.valor = valor;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.caracteristicas = caracteristicas;
        this.descricao = descricao;
        this.categoria = categoria;
        this.dataCadastro = LocalDateTime.now();
        this.usuarioProprietario = usuarioProprietario;
    }

    public Usuario getUsuarioProprietario() {
        return usuarioProprietario;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Integer getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public Set<CaracteristicaProduto> getCaracteristicas() {
        return caracteristicas;
    }

    public String getDescricao() {
        return descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public List<ImagemProduto> getImagensDoProduto() {
        return imagensDoProduto;
    }

    public List<Opiniao> getOpinioes() {
        return opinioes;
    }

    public List<Pergunta> getPerguntas() {
        return perguntas;
    }

    public void associaImagens(List<String> urls){
        List<ImagemProduto> imagens = urls.stream().map(url ->
            new ImagemProduto(url, this)
        ).collect(Collectors.toList());
        this.imagensDoProduto.addAll(imagens);
    }

    public boolean verificaEstoque(Integer quantidadeInformada){
        if(quantidadeInformada <= this.quantidadeDisponivel){
            this.quantidadeDisponivel -= quantidadeInformada;
            return true;
        }

        return false;
    }


}
