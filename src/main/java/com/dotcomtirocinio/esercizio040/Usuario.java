package com.dotcomtirocinio.esercizio040;

import java.time.LocalDateTime;
import java.util.Objects;


public class Usuario
{


    private Long id;


    private String username;


    private String password;


    private String role;

    public Usuario() {
    }

    protected Usuario(String someName) {}

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
        this.role = Role.USER.getNome();
    }

    public Long getId()
    {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    //@Override
    //public int hashCode() {
    //    return Objects.hash(id);
    //}

    ///@Override
    //public boolean equals(Object obj) {
    ///    if (this == obj)
    //        return true;
    //    if (obj == null)
    //        return false;
    //    if (getClass() != obj.getClass())
    //        return false;
    //    Usuario other = (Usuario) obj;
    //    return id == other.id;
    //}

    //public String getUserName() {       return null;}
}