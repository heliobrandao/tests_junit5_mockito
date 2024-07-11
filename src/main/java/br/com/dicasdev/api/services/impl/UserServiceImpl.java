package br.com.dicasdev.api.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dicasdev.api.domain.User;
import br.com.dicasdev.api.services.UserService;
import br.com.dicasdev.api.services.exceptions.ObjectNotFoundException;
import br.com.dicasdev.api.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;

    @Override
    public User findById(Integer id){
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado!"));
    }

}
