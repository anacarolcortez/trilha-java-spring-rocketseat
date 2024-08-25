package br.com.temosvagas.gestao_vagas.modules.companies.services;

import java.util.UUID;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.temosvagas.gestao_vagas.exceptions.CompanyNotFoundException;
import br.com.temosvagas.gestao_vagas.exceptions.UserFoundException;
import br.com.temosvagas.gestao_vagas.modules.companies.models.Company;
import br.com.temosvagas.gestao_vagas.modules.companies.repositories.CompanyRepository;

@Service
public class CompanyService {
    
    @Autowired
    private CompanyRepository companyRepository;

    public Company create(Company company) throws UserFoundException {
        Company entity = companyRepository.findByUsernameOrEmail(company.getUsername(), company.getEmail()).orElse(null);
        if (entity == null){
            return companyRepository.save(company);
        }
        throw new UserFoundException("Empresa já cadastrada");
    }    

    public Company findById(UUID id) throws CompanyNotFoundException {
       return companyRepository.findById(id)
       .orElseThrow(() -> new CompanyNotFoundException("Empresa não encontrada"));
    }  


}
