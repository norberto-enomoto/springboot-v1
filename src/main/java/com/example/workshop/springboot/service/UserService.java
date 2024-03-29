package com.example.workshop.springboot.service;

import com.example.workshop.springboot.exception.ResourseException;
import com.example.workshop.springboot.model.UserModel;
import com.example.workshop.springboot.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

  @Autowired
  private UserRepository userRepository;
  
  
  public Iterable<UserModel> getUsers() {
    log.info("Recuperando todos users");    
    return userRepository.findAll();
  }

  public UserModel getUser(Long id) throws ResourseException {
    log.info("Recuperando user pelo id {}", id);    
    return userRepository.findById(id).orElseThrow(() -> {
      return new ResourseException(String.format("User=[%s] não foi encontrado", id));
    });
  }

  public UserModel delete(Long id) throws ResourseException {
    log.info("Apagando user pelo id {}", id);
    UserModel user = userRepository.findById(id).orElseThrow(() -> {
      return new ResourseException(String.format("User=[%s] não foi encontrado", id));
    });
    userRepository.deleteById(id);
    return user;
  }

  public UserModel createUser(String name, String email) {
    UserModel user = UserModel.builder().name(name).email(email).build();
    log.info("Criando {}", user);
    log.info("teste do Github Action");
    return userRepository.save(user);
  }

  public UserModel updateUser(Long id, String name, String email) throws ResourseException {
    log.info("Atualizando user pelo id {}", id);
    UserModel user = userRepository.findById(id).orElseThrow(() -> {
      return new ResourseException(String.format("User=[%s] não foi encontrado", id));
    });

    if (name != null) {
      user.setName(name);
    }

    if (email != null) {
      user.setEmail(email);
    }

    userRepository.save(user);
    return user;
  }

  public Iterable<UserModel> getUsersbyName(String name) {
     log.info("Recuperando user pelo Nome {}", name);
     Iterable<UserModel> user = userRepository.findByName(name);
     return user;   
  }

}
