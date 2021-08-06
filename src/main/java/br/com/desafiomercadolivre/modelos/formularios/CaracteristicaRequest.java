package br.com.desafiomercadolivre.modelos.formularios;

public class CaracteristicaRequest {

    private String nome;

    private String descricao;

    public CaracteristicaRequest(String nome, String descricao) {
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
