package com.example.gip5team5api.User;
import org.jetbrains.annotations.NotNull;
import jakarta.persistence.*;

@Entity
@Table(name= "User")
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

    @NotNull
    String roles;

    @NotNull
    String password;

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

    public String getRoles() {
        return roles;
    }

    public void setRole(String roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }

    public User( String firstname, String lastname,  String email,  String birthdate, String roles, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.birthdate = birthdate;
        this.roles = roles;
        this.password = password;
    }
}
