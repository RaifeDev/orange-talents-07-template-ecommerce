package br.com.desafiomercadolivre.modelos.respostas;

import br.com.desafiomercadolivre.modelos.ImagemProduto;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ImagemProdutoResponse {

    private String url;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public ImagemProdutoResponse(ImagemProduto imagemProduto) {
        this.url = imagemProduto.getUrl();
    }

    public String getUrl() {
        return url;
    }
}
