package br.com.dicasdev.api.services;

import java.util.List;

import br.com.dicasdev.api.domain.User;

public interface UserService {

    User findById(Integer id);

    List<User> findAll();
}
