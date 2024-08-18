package br.com.temosvagas.gestao_vagas.modules.candidates.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.temosvagas.gestao_vagas.modules.candidates.models.Candidate;


public interface CandidateRepository extends JpaRepository<Candidate, UUID>{

    Optional<Candidate> findByUsernameOrEmail(String username, String email);
    
}
