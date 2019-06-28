package com.packs.myapp.models.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"), @UniqueConstraint(columnNames = "email")
})
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter
    @Setter
    Long user_id;


    @NotBlank
    @Size(max = 50)
    private @Getter
    @Setter
    String name;

    @NotBlank
    @Size(max = 16)
    private @Getter
    @Setter
    String username;

    @NaturalId
    @NotBlank
    @Size(max = 40)
    @Email
    private @Getter
    @Setter
    String email;

    @NotBlank
    @Size(max = 100)
    private @Getter
    @Setter
    String password;

    public Users(Long user_id, @NotBlank @Size(max = 50) String name, @NotBlank @Size(max = 16) String username,
                 @NotBlank @Size(max = 40) @Email String email, @NotBlank @Size(max = 100) String password) {
        this.user_id = user_id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Users(){

    }
}
