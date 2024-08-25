package br.com.temosvagas.gestao_vagas.modules.companies.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.temosvagas.gestao_vagas.modules.companies.models.Job;
import br.com.temosvagas.gestao_vagas.modules.companies.models.dtos.JobDTO;
import br.com.temosvagas.gestao_vagas.modules.companies.services.JobService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody JobDTO dto) {
        try{
            Job job = new Job(dto);
            var entity = this.jobService.create(job);
            JobDTO jobdto = new JobDTO(entity);
            return ResponseEntity.status(201).body(jobdto);
        } catch (Exception e){
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
    
}
