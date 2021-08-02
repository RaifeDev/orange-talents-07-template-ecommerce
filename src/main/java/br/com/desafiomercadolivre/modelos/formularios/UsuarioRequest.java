package br.com.desafiomercadolivre.modelos.formularios;

import br.com.desafiomercadolivre.modelos.Usuario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UsuarioRequest {

    @NotBlank(message = "É necessário preencher login.")
    @Email
    private String login;

    @NotBlank(message = "É necessário uma senha.")
    @Size(min = 6, message = "A senha precisa de 6 caracteres no mínimo.")
    private String senha;

    public UsuarioRequest(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }


    public Usuario converterParaUsuario() {
        return new Usuario(login, senha);
    }
}
