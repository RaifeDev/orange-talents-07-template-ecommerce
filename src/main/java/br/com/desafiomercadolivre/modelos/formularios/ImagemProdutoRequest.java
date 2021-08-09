package br.com.desafiomercadolivre.modelos.formularios;

import br.com.desafiomercadolivre.modelos.ImagemProduto;
import br.com.desafiomercadolivre.modelos.Produto;
import br.com.desafiomercadolivre.modelos.Usuario;
import br.com.desafiomercadolivre.utils.UploaderSimulador;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class ImagemProdutoRequest {

    @NotNull(message = "É necessário conter fotos do produto.")
    @Size(min = 1)
    private List<MultipartFile> imagens = new ArrayList<>();

    public List<MultipartFile> getImagens() {
        return imagens;
    }

    public void setImagens(List<MultipartFile> imagens) {
        this.imagens = imagens;
    }
}
