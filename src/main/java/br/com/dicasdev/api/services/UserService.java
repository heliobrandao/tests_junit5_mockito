package br.com.dicasdev.api.services;

import br.com.dicasdev.api.domain.User;

public interface UserService {

    User findById(Integer id);
}
