package br.com.dicasdev.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dicasdev.api.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer >{

    Optional<User> findByEmail(String email);

}
