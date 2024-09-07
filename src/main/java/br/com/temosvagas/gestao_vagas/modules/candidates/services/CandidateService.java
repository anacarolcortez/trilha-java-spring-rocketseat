package br.com.temosvagas.gestao_vagas.modules.candidates.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.temosvagas.gestao_vagas.exceptions.UserFoundException;
import br.com.temosvagas.gestao_vagas.modules.candidates.models.Candidate;
import br.com.temosvagas.gestao_vagas.modules.candidates.repositories.CandidateRepository;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Candidate create(Candidate candidate) throws UserFoundException{
        Candidate entity = candidateRepository.findByUsernameOrEmail(candidate.getUsername(), candidate.getEmail()).orElse(null);
        if (entity == null){
            var password = passwordEncoder.encode(candidate.getPassword());
            candidate.setPassword(password);
            return candidateRepository.save(candidate);
        }
        throw new UserFoundException("Candidato já cadastrado");
    }
    
}
