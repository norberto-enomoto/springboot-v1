package com.example.workshop.springboot.controller;


import com.example.workshop.springboot.dto.UserDTO;
import com.example.workshop.springboot.exception.ResourseException;
import com.example.workshop.springboot.model.UserModel;
import com.example.workshop.springboot.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
public class UserController {

  private final UserService userService;
  
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public ResponseEntity<Iterable<UserModel>> getUsers(@RequestParam(value = "name", defaultValue = "") String name) {
    Iterable<UserModel> users = null;
    if (name.isEmpty())
       users = userService.getUsers();
    else
       users = userService.getUsersbyName(name);
    return ResponseEntity.ok(users);
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserModel> getPerson(@PathVariable Long id) throws ResourseException {
    UserModel user = userService.getUser(id);
    return ResponseEntity.ok(user);
  }

  @PostMapping
  public ResponseEntity<UserModel> createUser(@RequestBody @Validated UserDTO userDTO) {
    UserModel user = userService.createUser(userDTO.getName(), userDTO.getEmail());
    return ResponseEntity.status(HttpStatus.CREATED).body(user);
  }

  @PutMapping("/{id}")
  public ResponseEntity<UserModel> createUser(@PathVariable Long id,
      @RequestBody @Validated UserDTO userDTO) throws ResourseException {
    UserModel user = userService.updateUser(id, userDTO.getName(), userDTO.getEmail());
    return ResponseEntity.ok(user);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<UserModel> deletePerson(@PathVariable Long id) throws ResourseException {
    UserModel user = userService.delete(id);
    return ResponseEntity.ok(user);
  }

}