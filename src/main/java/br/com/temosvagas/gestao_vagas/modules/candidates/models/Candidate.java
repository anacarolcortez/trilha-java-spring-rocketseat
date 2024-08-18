package br.com.temosvagas.gestao_vagas.modules.candidates.models;

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

@Data
@Entity(name="candidate")
@NoArgsConstructor
@AllArgsConstructor
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @Email(message = "Informe um e-mail válido")
    private String email;

    @NotBlank
    @Pattern(regexp = "\\S+", message = "Username não deve conter espaço")
    private String username;

    @Length(min = 8, max = 20, message = "A senha deve ter entre 8 e 20 caracteres")
    private String password;

    private String description;
    
    private String curriculum;

    @CreationTimestamp
    private LocalDateTime createdAt;
    
}
