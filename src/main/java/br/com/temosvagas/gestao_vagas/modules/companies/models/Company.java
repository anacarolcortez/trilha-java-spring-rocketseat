package br.com.temosvagas.gestao_vagas.modules.companies.models;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "company")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Nome não deve ser vazio")
    private String name;

    private String cpnj;

    @NotBlank
    @Pattern(regexp = "\\S+", message = "Username não deve conter espaço")
    private String username;

    @Email(message = "E-mail inválido")
    private String email;

    @Length(min = 8, message = "A senha deve ter no mínimo 8 caracteres")
    private String password;

    private String website;

    private String description;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public Company(UUID id){
        this.id = id;
    }
    
}
