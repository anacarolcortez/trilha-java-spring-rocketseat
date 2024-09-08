package br.com.temosvagas.gestao_vagas.modules.companies.repositories;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.temosvagas.gestao_vagas.modules.companies.models.Company;

public interface CompanyRepository extends JpaRepository<Company, UUID>{

    Optional<Company> findByUsernameOrEmail(String username, String email);

    Optional<Company> findByUsername(String username);
    
}
