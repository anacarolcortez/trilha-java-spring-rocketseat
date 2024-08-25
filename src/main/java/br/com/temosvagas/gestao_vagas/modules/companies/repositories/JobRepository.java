package br.com.temosvagas.gestao_vagas.modules.companies.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.temosvagas.gestao_vagas.modules.companies.models.Job;

public interface JobRepository extends JpaRepository<Job, UUID> {
    
}
