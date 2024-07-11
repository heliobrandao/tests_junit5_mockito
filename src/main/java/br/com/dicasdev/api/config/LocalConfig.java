package br.com.dicasdev.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.dicasdev.api.domain.User;
import br.com.dicasdev.api.repositories.UserRepository;
import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository repository;

    @Bean
    public Boolean startDB(){
        User u1 = new User(null, "Hélio", "helio@mail.com.br", "1234");
        User u2 = new User(null, "Letícia", "lele@mail.com.br", "1234");

        repository.saveAll(List.of(u1, u2));
        return true;
    }
}

