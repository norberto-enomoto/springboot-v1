package com.example.workshop.springboot.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
  
  @NotEmpty(message = "Nome não pode ser vazio")
  private String name;  
  
  @NotEmpty(message = "Nome não pode ser vazio")
  private String email;
}