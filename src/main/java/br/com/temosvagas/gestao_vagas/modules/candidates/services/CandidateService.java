package br.com.temosvagas.gestao_vagas.modules.candidates.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.temosvagas.gestao_vagas.modules.candidates.models.Candidate;

@Service
public class CandidateService {

    @Autowired
    CandidateRepository candidateRepository;

    public Candidate create(Candidate candidate) throws Exception{
        Candidate entity = candidateRepository.findByUsernameOrEmail(candidate.getUsername(), candidate.getEmail()).orElse(null);
        if (entity == null){
            return candidateRepository.save(candidate);
        }
        throw new Exception("Candidato já cadastrado");
    }
    
}
