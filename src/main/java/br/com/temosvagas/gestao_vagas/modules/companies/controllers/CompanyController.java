package br.com.temosvagas.gestao_vagas.modules.companies.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.temosvagas.gestao_vagas.exceptions.UserFoundException;
import br.com.temosvagas.gestao_vagas.modules.companies.models.Company;
import br.com.temosvagas.gestao_vagas.modules.companies.services.CompanyService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody Company entity) {
        try{
            var result = this.companyService.create(entity);
            return ResponseEntity.status(201).body(result);
        }catch (UserFoundException e){
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
    
    
}
