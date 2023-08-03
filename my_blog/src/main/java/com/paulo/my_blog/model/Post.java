package com.paulo.my_blog.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "postagens")
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "O campo titulo não pode ser nulo or estar em branco")
    private String titulo;
    @NotBlank(message = "O campo autor não pode ser nulo or estar em branco")
    private String autor;
    @NotNull (message="A data de publicação é obrigatória!")
    @NotBlank
    private String data;
    @NotBlank(message = "O campo não pode ser nulo or estar em branco")

    @NotBlank
    @Lob
    private String texto;
}
