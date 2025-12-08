package com.GabrielsSena.Web.Service.Service;

import com.GabrielsSena.Web.Service.Entities.User;
import com.GabrielsSena.Web.Service.Repository.UserRepository;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class UserService  {

    @Autowired
    private final UserRepository repository;


    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.get();
    }

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void saveUser (User user){
        repository.saveAndFlush(user);
    }

    public void deleteById (Long id){
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

    public List<User> findAll(){
        return repository.findAll();
    }

}
