package br.com.temosvagas.gestao_vagas.modules.companies.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.temosvagas.gestao_vagas.exceptions.CompanyNotFoundException;
import br.com.temosvagas.gestao_vagas.modules.companies.models.Company;
import br.com.temosvagas.gestao_vagas.modules.companies.models.Job;
import br.com.temosvagas.gestao_vagas.modules.companies.repositories.JobRepository;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private CompanyService companyService;

    public Job create(Job entity) throws Exception{
        try {
            Company company = companyService.findById(entity.getCompany().getId());
            entity.setCompany(company);
            return this.jobRepository.save(entity);
        } catch (CompanyNotFoundException e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }
    
}
