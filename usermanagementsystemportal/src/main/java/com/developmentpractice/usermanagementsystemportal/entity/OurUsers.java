package com.developmentpractice.usermanagementsystemportal.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

//create entity as OurUser instaed of User -> we use user from spring security
// @Data is a Lombok annotation that automatically generates getter, setter, toString, equals, and hashCode methods.

// Implementing the UserDetails interface allows the OurUsers class to be used by Spring Security for authentication and authorization.

/*
* Spring Security uses the UserDetails interface to retrieve user-related data during authentication. By implementing UserDetails,
* the OurUsers class can be used directly by Spring Security's authentication manager to:

Load user details by username (email in this case).
Get user authorities (roles or permissions).
Check account status (enabled, locked, expired).
This setup integrates the OurUsers entity with Spring Security, allowing for seamless user authentication and authorization.*/

@Entity
@Table(name = "ourusers")
@Data
public class OurUsers implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String name;
    private String password;
    private String city;
    private String role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role)); // Role is determining the access to application
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        //return UserDetails.super.isAccountNonExpired();
        return true;  //  the account is not expired.
    }

    @Override
    public boolean isAccountNonLocked() {
        //return UserDetails.super.isAccountNonLocked();
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        //return UserDetails.super.isCredentialsNonExpired();
        return true; // credentials are not expired.
    }

    @Override
    public boolean isEnabled() {
        //return UserDetails.super.isEnabled();
        return true; // user is enabled.
    }
}
