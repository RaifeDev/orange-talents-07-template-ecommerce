package br.com.desafiomercadolivre.modelos.formularios;

import br.com.desafiomercadolivre.annotations.CampoUnico;
import br.com.desafiomercadolivre.annotations.IdExiste;
import br.com.desafiomercadolivre.modelos.Categoria;
import br.com.desafiomercadolivre.repositorios.CategoriaRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class CategoriaRequest {

    @NotBlank(message = "O campo nome precisa ser preenchido")
    @CampoUnico(fieldName = "nome", domainClass = Categoria.class, message = "Categoria já existente no banco.")
    private String nome;

    @Positive
    @IdExiste(domainClass = Categoria.class, fieldName = "id", allowNull = true)
    private Long categoriaId;

    public CategoriaRequest(String nome, Long categoriaId) {
        this.nome = nome;
        this.categoriaId = categoriaId;
    }


    public Categoria converterParaCategoria(CategoriaRepository categoriaRepository) {

        if(categoriaId != null){
            Categoria categoriaMae = categoriaRepository.getById(categoriaId);
            return new Categoria(nome, categoriaMae);
        }else{
            return new Categoria(nome);
        }

    }
}
