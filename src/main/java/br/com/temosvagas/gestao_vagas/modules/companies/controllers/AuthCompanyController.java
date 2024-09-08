package br.com.temosvagas.gestao_vagas.modules.companies.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.temosvagas.gestao_vagas.modules.companies.models.dtos.AuthCompanyDTO;
import br.com.temosvagas.gestao_vagas.modules.companies.services.AuthCompanyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/auth")
public class AuthCompanyController {

    @Autowired
    private AuthCompanyService authCompanyService;

    @PostMapping("/company/")
    public ResponseEntity<Object> createJWT(@RequestBody AuthCompanyDTO authCompanyDTO) {
        try {
            var response = authCompanyService.getJWT(authCompanyDTO);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
    
}
