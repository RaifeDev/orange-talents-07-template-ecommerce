package br.com.desafiomercadolivre.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UploaderSimulador {


    public List<String> upload(List<MultipartFile> arquivos){
        return arquivos.stream().map(arquivo -> "https://imagem.simulator.aws/"+ arquivo.getOriginalFilename())
                .collect(Collectors.toList());
    }


}
