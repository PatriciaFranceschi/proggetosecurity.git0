package com.dotcomtirocinio.esercizio040;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userRepository;


    public UserDetails loadUserByUsername(String username, String password) throws UsernameNotFoundException {
        //if (string == null || string.isEmpty() || string.trim().isEmpty())


            if ((password == null) || (username == null)){
            throw new UsernameNotFoundException("User not authorized.");
        }




        String psw = userRepository.getLogin(username);

        if ((psw == null) ){
            throw new UsernameNotFoundException("User not authorized.");
        }



        if (password != psw) {
            throw new UsernameNotFoundException("User not authorized.");
        }

        //começar aqui autenticaçao



        List<Usuario> userList = new ArrayList<>();
       Usuario usuario = new Usuario();

        String dbUserName = usuario.getUsername();

        if (dbUserName == null) {
            throw new UsernameNotFoundException("User not authorized.");
        }


        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
//        GrantedAuthority authority = username.getAuthority();
//        grantList.add(authority);

       // BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        //String password = encoder.encode(usuario.getPassword());

        UserDetails userDetails = (UserDetails) new Usuario(usuario.getUsername(), usuario.getPassword());
        System.out.println("userD" + userDetails);

        return userDetails;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}