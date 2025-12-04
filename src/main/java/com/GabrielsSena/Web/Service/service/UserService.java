package com.GabrielsSena.Web.Service.service;

import com.GabrielsSena.Web.Service.Entities.User;
import com.GabrielsSena.Web.Service.repository.UserRepository;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;

public class UserService  {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void saveUser (User user){
        repository.saveAndFlush(user);
    }

    public void deleteById (Integer id){
        repository.deleteById(id);
    }

    public void deleteByEmail(String email){
        repository.deleteByEmail(email);
    }

    public User findByEmail(String email){
        return repository.findByEmail(email).orElseThrow(() ->
                new RuntimeException("Email não encontrado"));
    }

    public User findByPhone(String phone){
        return repository.findByPhone(phone).orElseThrow(() ->
                new RuntimeException("Telefone não encontrado"));
    }
}
