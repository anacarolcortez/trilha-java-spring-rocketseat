package br.com.temosvagas.gestao_vagas.modules.companies.models.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.temosvagas.gestao_vagas.modules.companies.models.Job;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobDTO {

    private UUID id;

    @NotNull(message="Campo descrição não pode ser nulo")
    @NotBlank(message = "Campo descrição não deve ser vazio")
    private String description;

    @NotNull(message="Campo nível não pode ser nulo")
    @NotBlank(message = "Campo nível não deve ser vazio")
    private String level;

    private String benefits;

    private UUID companyId;

    private LocalDateTime createdAt;
    
    public JobDTO(Job job){
        this.id = job.getId();
        this.description = job.getDescription();
        this.level = job.getLevel();
        this.benefits = job.getBenefits();
        this.companyId = job.getCompany().getId();
        this.createdAt = job.getCreatedAt();
    }
}
