package br.com.desafiomercadolivre.modelos.respostas;

import br.com.desafiomercadolivre.modelos.CaracteristicaProduto;

public class CaracteristicaProdutoResponse {

    private String nome;

    private String descricao;

    @Deprecated
    public CaracteristicaProdutoResponse(){

    }

    public CaracteristicaProdutoResponse(CaracteristicaProduto caracteristicaProduto) {
        this.nome = caracteristicaProduto.getNome();
        this.descricao = caracteristicaProduto.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
