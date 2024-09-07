package br.com.temosvagas.gestao_vagas.modules.companies.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.temosvagas.gestao_vagas.exceptions.CompanyNotFoundException;
import br.com.temosvagas.gestao_vagas.exceptions.UserFoundException;
import br.com.temosvagas.gestao_vagas.modules.companies.models.Company;
import br.com.temosvagas.gestao_vagas.modules.companies.repositories.CompanyRepository;

@Service
public class CompanyService {
    
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Company create(Company company) throws UserFoundException {
        Company entity = companyRepository.findByUsernameOrEmail(company.getUsername(), company.getEmail()).orElse(null);
        if (entity == null){

            var password = passwordEncoder.encode(company.getPassword());
            company.setPassword(password);
            return companyRepository.save(company);
        }
        throw new UserFoundException("Empresa já cadastrada");
    }    

    public Company findById(UUID id) throws CompanyNotFoundException {
       return companyRepository.findById(id)
       .orElseThrow(() -> new CompanyNotFoundException("Empresa não encontrada"));
    }  


}
