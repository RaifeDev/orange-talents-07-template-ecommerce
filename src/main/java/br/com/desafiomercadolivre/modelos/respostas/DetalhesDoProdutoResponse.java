package br.com.desafiomercadolivre.modelos.respostas;

import br.com.desafiomercadolivre.modelos.Produto;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class DetalhesDoProdutoResponse {

    private String nome;

    private BigDecimal preco;

    private String descricao;

    private Set<CaracteristicaProdutoResponse> caracteristica = new HashSet<>();

    private List<ImagemProdutoResponse> imagens = new ArrayList<>();

    private List<OpiniaoResponse> opinioes = new ArrayList<>();

    private List<PerguntaResponse> perguntas = new ArrayList<>();

    private Integer numeroDeNotas;

    private Double mediaNotas;

    @Deprecated
    public DetalhesDoProdutoResponse(){

    }

    public DetalhesDoProdutoResponse(Produto produto) {
        this.nome = produto.getNome();
        this.preco = produto.getValor();
        this.descricao = produto.getDescricao();
        this.caracteristica = produto.getCaracteristicas().stream().map(CaracteristicaProdutoResponse::new).collect(Collectors.toSet());
        this.imagens = produto.getImagensDoProduto().stream().map(ImagemProdutoResponse::new).collect(Collectors.toList());
        this.opinioes = produto.getOpinioes().stream().map(OpiniaoResponse::new).collect(Collectors.toList());
        this.perguntas = produto.getPerguntas().stream().map(PerguntaResponse::new).collect(Collectors.toList());
        List<Integer> notas = produto.getOpinioes().stream().map(opiniao -> opiniao.getNota()).collect(Collectors.toList());
        this.numeroDeNotas = notas.size();
        OptionalDouble mediasProvisorias = notas.stream().mapToInt(nota -> nota).average();
        this.mediaNotas = mediasProvisorias.orElseGet(() -> 0.0);
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public Set<CaracteristicaProdutoResponse> getCaracteristica() {
        return caracteristica;
    }

    public List<ImagemProdutoResponse> getImagens() {
        return imagens;
    }

    public List<OpiniaoResponse> getOpinioes() {
        return opinioes;
    }

    public List<PerguntaResponse> getPerguntas() {
        return perguntas;
    }

    public Integer getNumeroDeNotas() {
        return numeroDeNotas;
    }

    public Double getMediaNotas() {
        return mediaNotas;
    }
}
