package br.com.dicasdev.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dicasdev.api.domain.User;
import br.com.dicasdev.api.domain.dto.UserDTO;
import br.com.dicasdev.api.services.UserService;
import br.com.dicasdev.api.services.exceptions.DataIntegrityViolationException;
import br.com.dicasdev.api.services.exceptions.ObjectNotFoundException;
import br.com.dicasdev.api.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public User findById(Integer id){
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado!"));
    }

    public List<User> findAll(){
        return repository.findAll();
    }

    @Override
    public User create(UserDTO obj) {
        findByEmail(obj);
        return repository.save(mapper.map(obj, User.class));
    }

    private void findByEmail(UserDTO obj){
        Optional<User> user = repository.findByEmail(obj.getEmail());
        if(user.isPresent()){
            throw new DataIntegrityViolationException("E-mail já cadastrado no sistema");
        }
    }

}
