package br.com.desafiomercadolivre.modelos.formularios;

import br.com.desafiomercadolivre.annotations.IdExiste;
import br.com.desafiomercadolivre.modelos.CaracteristicaProduto;
import br.com.desafiomercadolivre.modelos.Categoria;
import br.com.desafiomercadolivre.modelos.Produto;
import br.com.desafiomercadolivre.modelos.Usuario;
import br.com.desafiomercadolivre.repositorios.CategoriaRepository;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class ProdutoRequest {

    @NotBlank
    private String nome;

    @NotNull
    @Positive
    private BigDecimal valor;

    @NotNull
    @PositiveOrZero
    private Integer quantidadeDisponivel;

    @Size(min = 3)
    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<CaracteristicaRequest> caracteristicas = new HashSet<>();

    @NotBlank
    @Size(max = 1000)
    private String descricao;

    @IdExiste(domainClass = Categoria.class, fieldName = "id")
    @NotNull
    private Long categoria;


    public Produto converterParaProduto(CategoriaRepository categoriaRepository, Usuario usuario) {

        Categoria categoria = categoriaRepository.getById(this.categoria);
        Set<CaracteristicaProduto> caracteristicas = new HashSet<>();

        this.caracteristicas.forEach(caracteritica -> {
            caracteristicas.add(new CaracteristicaProduto(caracteritica.getNome(), caracteritica.getDescricao()));
        });

        return new Produto(nome, valor, quantidadeDisponivel, caracteristicas, descricao, categoria, usuario);

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

    public Set<CaracteristicaRequest> getCaracteristicas() {
        return caracteristicas;
    }

    public String getDescricao() {
        return descricao;
    }

    public Long getCategoria() {
        return categoria;
    }

}
