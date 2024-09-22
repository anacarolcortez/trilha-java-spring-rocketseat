package br.com.temosvagas.gestao_vagas.modules.companies.models;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import br.com.temosvagas.gestao_vagas.modules.companies.models.dtos.JobDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "job")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Campo descrição não deve ser vazio")
    private String description;

    @NotBlank(message = "Campo nível não deve ser vazio")
    private String level;

    private String benefits;

    @ManyToOne()
    @JoinColumn(name = "company_id")
    private Company company;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public Job(JobDTO dto){
        this.id = dto.getId();
        this.description = dto.getDescription();
        this.level = dto.getLevel();
        this.benefits = dto.getBenefits();
        this.company = new Company(dto.getCompanyId());
        this.createdAt = dto.getCreatedAt();
    }
}
