package br.com.desafiomercadolivre.modelos;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "É necessário preencher login.")
    @Email
    @Column(unique = true)
    private String login;

    @NotBlank(message = "É necessário uma senha.")
    @Size(min = 6, message = "A senha precisa de 6 caracteres no mínimo.")
    private String senha;

    private LocalDateTime dataCadastro;

    @Deprecated
    public Usuario(){

    }

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
        this.dataCadastro = LocalDateTime.now();
    }

}
