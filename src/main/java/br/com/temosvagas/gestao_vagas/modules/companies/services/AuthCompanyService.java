package br.com.temosvagas.gestao_vagas.modules.companies.services;

import java.time.Duration;
import java.time.Instant;

import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.temosvagas.gestao_vagas.modules.companies.models.dtos.AuthCompanyDTO;
import br.com.temosvagas.gestao_vagas.modules.companies.repositories.CompanyRepository;

@Service
public class AuthCompanyService {

    @Value("${security.key}")
    private String superSecretKey;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired PasswordEncoder passwordEncoder;
    
    public String getJWT(AuthCompanyDTO authCompanyDTO) throws AuthenticationException{
        var company = this.companyRepository
                        .findByUsername(authCompanyDTO.getUsername())
                        .orElseThrow(() -> new AuthenticationException("Usuário/senha inválidos"));

        var password = this.passwordEncoder.matches(authCompanyDTO.getPassword(), company.getPassword());

        if (!password){
            throw new AuthenticationException("Usuário/senha inválidos");
        }

        Algorithm algorithm = Algorithm.HMAC256(superSecretKey);        
        return JWT.create()
            .withExpiresAt(Instant.now().plus(Duration.ofHours(2)))
            .withIssuer("vagasdev")
            .withSubject(company.getId().toString())
            .sign(algorithm);

    }
}
