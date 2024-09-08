package br.com.temosvagas.gestao_vagas.modules.companies.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthCompanyDTO {
    private String username;
    private String password;
}
