package com.example.gip5team5api.User;
import org.jetbrains.annotations.NotNull;
import jakarta.persistence.*;

@Entity
@Table(name= "com/example/gip5team5api/User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    String firstname;

    @NotNull
    String lastname;

    @NotNull
    String email;

    @NotNull
    String birthdate;

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public User() {
    }

    public User( String firstname,String lastname,  String email,  String birthdate) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.birthdate = birthdate;
    }
}
