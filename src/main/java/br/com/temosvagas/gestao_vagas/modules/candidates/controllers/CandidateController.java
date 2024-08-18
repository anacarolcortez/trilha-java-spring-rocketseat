package br.com.temosvagas.gestao_vagas.modules.candidates.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.temosvagas.gestao_vagas.modules.candidates.models.Candidate;
import br.com.temosvagas.gestao_vagas.modules.candidates.services.CandidateService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @PostMapping("/")
    public ResponseEntity<Object> postMethodName(@Valid @RequestBody Candidate candidate) {
        try{
            Candidate entity = candidateService.create(candidate);
            return ResponseEntity.status(201).body(entity);
        } catch (Exception e){
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }


}
