package br.com.desafiomercadolivre.modelos;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "tb_usuarios")
public class Usuario implements UserDetails {

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


    // método do spring Security

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Configuração de roles (Perfis)
        return null;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
