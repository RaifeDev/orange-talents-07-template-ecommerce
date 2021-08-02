package br.com.desafiomercadolivre.modelos.formularios;

import br.com.desafiomercadolivre.annotations.CampoUnico;
import br.com.desafiomercadolivre.modelos.Usuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UsuarioRequest {

    @NotBlank(message = "É necessário preencher login.")
    @CampoUnico(fieldName = "login", domainClass = Usuario.class, message = "Já existe um email cadastrado com este endereço.")
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
        return new Usuario(login, new BCryptPasswordEncoder().encode(senha));
    }
}
